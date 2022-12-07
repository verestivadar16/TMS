package com.TMS.routes

import com.TMS.Authentification.JwtService
import com.TMS.Authentification.hash
import com.TMS.data.model.LoginRequest
import com.TMS.data.model.RegisterRequest
import com.TMS.data.model.SimpleResponse
import com.TMS.data.model.User
import com.TMS.repository.repo
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.locations.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.util.SimpleTimeZone

private const val BASE_URL = "http://192.168.1.5:8100"

const val API_VERSION = "/v1"
const val USERS = "$API_VERSION/users"
const val REGISTER_REQUEST = "$USERS/register"
const val LOGIN_REQUEST = "$USERS/login"

@Location(REGISTER_REQUEST)
class UserRegisterRoute

@Location(LOGIN_REQUEST)
class UserLoginRoute



fun Route.UserRoutes(
    db:repo,
    jwtService: JwtService,
    hashFunction:(String)->String
){

    post("/register"){
        val registerRequest = try {
            call.receive<RegisterRequest>()
        }   catch (e:Exception){
            call.respond(HttpStatusCode.BadRequest,SimpleResponse(false,"Missing Some Fields"))
            return@post
        }
        try {
            val user = User(registerRequest.email,hashFunction(registerRequest.password),registerRequest.name)
            db.addUser(user)
            call.respond(HttpStatusCode.OK,SimpleResponse(true,jwtService.generateToken(user)))
        }catch (e:Exception){
            call.respond(HttpStatusCode.Conflict,SimpleResponse(false,e.message ?: "Some Problem Occurred"))
        }
    }

    post(LOGIN_REQUEST){
        val loginRequest = try{
            call.receive<LoginRequest>()
        }catch (e:Exception){
            call.respond(HttpStatusCode.BadRequest,SimpleResponse(false,"Missing Some Fields"))
            return@post
        }

        try {
            val user = db.findUserByEmail(loginRequest.email)

            if(user == null){
                call.respond(HttpStatusCode.BadRequest,SimpleResponse(false,"Wrong Email ID"))
            }else{

                if(user.hashPassword == hashFunction(loginRequest.password)){
                    call.respond(HttpStatusCode.OK,SimpleResponse(true,jwtService.generateToken(user)))
                }else{
                    call.respond(HttpStatusCode.BadRequest,SimpleResponse(false,"Password Incorrect"))
                }
            }
        }catch (e:Exception){
            call.respond(HttpStatusCode.Conflict,SimpleResponse(false,e.message ?: "Some Problem Occurred"))
        }

    }

    get("/token") {
        val email = call.request.queryParameters["email"]!!
        val password = call.request.queryParameters["password"]!!
        val username = call.request.queryParameters["username"]!!

        val user = User(email,hashFunction(password),username)
        call.respond(
            HttpStatusCode.OK,
            jwtService.generateToken(user)
        )
    }
}