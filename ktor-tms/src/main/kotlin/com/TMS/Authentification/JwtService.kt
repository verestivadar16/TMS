package com.TMS.Authentification

import com.TMS.data.model.User
import com.auth0.jwt.JWT
import com.auth0.jwt.JWTVerifier
import com.auth0.jwt.algorithms.Algorithm


class JwtService {

    private val issuer = "tmsServer"
    private val jwtSecret = System.getenv("JWT_SECRET")
    private val algorithm = Algorithm.HMAC512(jwtSecret)

    val verifier:JWTVerifier = JWT
        .require(algorithm)
        .withIssuer(issuer)
        .build()

    fun generateToken(user: User):String{
         return JWT.create()
             .withSubject("UserAuthentication")
             .withIssuer(issuer)
             .withClaim("email",user.email)
             .sign(algorithm)
    }


}