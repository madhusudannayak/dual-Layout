package com.example.multisuportscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() ,CustomListAdapter.OnItemClick{
    private var mIsDualPane = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentBView = findViewById<View>(R.id.fragmentB)
        mIsDualPane = fragmentBView?.visibility == View.VISIBLE
    }

    override fun onItemClick(item: DataModel) {
        if (mIsDualPane) { // If we are in Tablet
            val fragmentB = supportFragmentManager.findFragmentById(R.id.fragmentB) as DetailsFragment?
            fragmentB?.displayDetails(item.title, item.title)
            Log.d("aaaaaaaaaaa","sssssssssssssssssssssssssssssss")
        } else {
            Log.d("aaaaaaaaaaa","sssssssssssssssssssssssssssssss")
            // When we are in Smart phone
            val bundle = Bundle()
            bundle.putString("Name", item.title)
            bundle.putString("Description", item.title)

            val transaction = this.supportFragmentManager.beginTransaction()
            val frag2 = DetailsFragment()
            frag2.arguments = bundle

            transaction.replace(R.id.nav_host_fragment, frag2)
            transaction.addToBackStack(null)
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            transaction.commit()
        }
    }
}