package com.example.tms.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tms.R
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tms.databinding.ChatInputBinding


class ChatPageFragment :Fragment(){
    private lateinit var binding: ChatInputBinding
    private lateinit var messageAdapter: MessageAdapter
    private lateinit var messageList: ArrayList<Message>


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = ChatInputBinding.inflate(layoutInflater)
        binding.imageButtonBack.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_chatpage_to_inboxpage)
        })


        return binding.root
    }
    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        val recyclerview = getView()?.findViewById<RecyclerView>(R.id.message_list)
        if (recyclerview != null) {
            recyclerview.layoutManager = LinearLayoutManager(getContext())
        }
        val data = ArrayList<Message>()
        data.add(Message("Hello","1"))
        data.add(Message("Hello","2"))
        data.add(Message("How you doing","2"))
        data.add(Message("Doing Fine","1"))
        data.add(Message("Then meet up at 7pm?","1"))
        data.add(Message("Bringin the evo, the new exhaust system gonna blow your ears","1"))
        data.add(Message("Yeah","2"))
        data.add(Message("Cant wait for it","2"))
        binding.chatSendMsg.setOnClickListener(){
            data.add(Message(binding.chatInputMsg.toString(),"1"))
        }



        val adapter = context?.let { MessageAdapter(it,data) }
        if (recyclerview != null) {
            recyclerview.adapter = adapter
        }
        if (recyclerview != null) {
            recyclerview.adapter = adapter
        }
    }
}