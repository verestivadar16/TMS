package com.example.tms.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tms.R
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tms.databinding.ChatInputBinding
import android.widget.EditText
import android.widget.ImageView
import com.example.tms.adapter.MessageAdapter
import com.example.tms.data.Message
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class ChatPageFragment : Fragment() {
    private lateinit var binding: ChatInputBinding
    private lateinit var mAuth : FirebaseAuth
    private lateinit var chatRecyclerView: RecyclerView
    private lateinit var messageBox : EditText
    private lateinit var sendButton: ImageView
    private lateinit var messageAdapter: MessageAdapter
    private lateinit var messageList: ArrayList<Message>
    private lateinit var mDbRef : DatabaseReference

    var receiveRoom : String? = null
    var senderRoom : String? = null

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        binding = ChatInputBinding.inflate(layoutInflater)
        binding.imageButtonBack.setOnClickListener(View.OnClickListener {
            getActivity()?.onBackPressed()
        })


        return binding.root
    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        val recyclerview = getView()?.findViewById<RecyclerView>(R.id.message_list)
        if (recyclerview != null) {
            recyclerview.layoutManager = LinearLayoutManager(getContext())
        }

        mAuth = FirebaseAuth.getInstance()

        val senderUid = mAuth.currentUser?.uid.toString()

        mDbRef = FirebaseDatabase.getInstance().getReference()

        val data = ArrayList<Message>()
        data.add(Message("Hello", "1"))
        data.add(Message("Hello", "2"))
        data.add(Message("How you doing", "2"))
        data.add(Message("Doing Fine", "1"))
        data.add(Message("Then meet up at 7pm?", "1"))
        data.add(Message("Bringin the evo, the new exhaust system gonna blow your ears", "1"))
        data.add(Message("Yeah", "2"))
        data.add(Message("Cant wait for it", "2"))


        binding.chatSendMsg.setOnClickListener() {
            val inputMessage = getView()?.findViewById<EditText>(R.id.input_message)?.text
            val inputMessage2 = binding.inputMessage.text
            data.add(Message(inputMessage2.toString(), "2"))
            getView()?.findViewById<EditText>(R.id.input_message)?.text?.clear()

           mDbRef.child("chats")


            val adapter = context?.let { MessageAdapter(it, data) }
            if (recyclerview != null) {
                recyclerview.adapter = adapter
            }
            if (recyclerview != null) {
                recyclerview.adapter = adapter
            }
        }


        val adapter = context?.let { MessageAdapter(it, data) }
        if (recyclerview != null) {
            recyclerview.adapter = adapter
        }
        if (recyclerview != null) {
            recyclerview.adapter = adapter
        }

    }
}