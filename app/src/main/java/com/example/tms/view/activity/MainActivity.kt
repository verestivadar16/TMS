package com.example.tms.view.activity


import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tms.R
import com.example.tms.view.fragment.ConversationViewModel
import com.example.tms.view.fragment.CustomAdapter
//import com.example.tms.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
//        private lateinit var binding: ActivityMainBinding

       private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.notification_page)
        // getting the recyclerview by its id
        val recyclerview = findViewById<RecyclerView>(R.id.conversation_list)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)

        // ArrayList of class ItemsViewModel
        val data = ArrayList<ConversationViewModel>()

        // This loop will create 20 Views containing
        // the image with the count of view
        for (i in 1..20) {
            data.add(ConversationViewModel(R.drawable.map, "Arany Janos", "invited to an upcoming event", "12:00"))
        }

        // This will pass the ArrayList to our Adapter
        val adapter = CustomAdapter(data)

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter

//       binding = ActivityMainBinding.inflate(layoutInflater)
//
//        setContentView(binding.root)
//        binding.bottomNavigationView.visibility= View.INVISIBLE
//
//        val navController =
//            Navigation.findNavController(this, R.id.nav_host_fragment) as NavController
//        val bottomNavigationView = binding.bottomNavigationView as BottomNavigationView
//        NavigationUI.setupWithNavController(bottomNavigationView, navController)
//        if (layoutInflater.equals(R.id.insta_upload)){
//            binding.bottomNavigationView.visibility= View.VISIBLE
//        }
//
//        navController.addOnDestinationChangedListener { _, destination, _ ->
//            when (destination.id) {
//                R.id.loginPage -> hideBottomNav()
//                R.id.startPage -> hideBottomNav()
//                R.id.registerPage -> hideBottomNav()
//                R.id.forgot_password -> hideBottomNav()
//                else -> showBottomNav()
//            }
//        }


    }

//    private fun showBottomNav() {
//        binding.bottomNavigationView.visibility = View.VISIBLE
//
//    }
//
//    private fun hideBottomNav() {
//        binding.bottomNavigationView.visibility = View.GONE
//   }


}
