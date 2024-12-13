
package com.gehad.recyclerview

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
class MainActivity2: AppCompatActivity() {

 lateinit var newRecyclerView: RecyclerView
    lateinit var newArrayList: ArrayList<Films>
     lateinit var adapter: MyAdapter
    lateinit var textview: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
       
            textview = findViewById(R.id.textView)
        var intent: Intent = intent
        var myusername = intent.getStringExtra("username")
        textview.text = myusername
       
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener {
            finishAffinity()
        }

       
        newRecyclerView = findViewById(R.id.recyclerView)
       newRecyclerView.layoutManager = LinearLayoutManager(this)
      newRecyclerView.setHasFixedSize(true)
        val imgeid = arrayOf(
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
            R.drawable.img6,
            R.drawable.img7,
            R.drawable.img8,
            R.drawable.img9,
            R.drawable.img10


        )
        val descripe = arrayOf(
            """ In a post-apocalyptic world, cities have become moving fortresses battling for resources.
                | -Rating: 6.1/10 (IMDb)
                | -Publish Date: December 14, 2018""".trimMargin(),
            """ A Day to Die follows a former police officer who must navigate a dangerous world after a heist goes wrong. 
                |-Rating: 5.5/10
                |-Publish Date: March 11, 2022  """.trimMargin(),
            """ Free Guy is a unique action-comedy that tells the story of Guy, a bank teller who discovers he is actually a background character in an open-world video game
                | -Rating: 7.1/10 
              | -Publish Date: August 13, 2021  """.trimMargin(),
            """ Retribution is a gripping thriller that follows a businessman who finds himself in a deadly game of cat and mouse when he receives a mysterious phone call while driving.
               | -Rating: 6.5/10
               |  -Publish Date: August 2023  """.trimMargin(),
            """ Kingsman: The Secret Service is an action-packed spy film that introduces us to a secret organization of elite spies 
               |-Rating: 7.7/10
               |- Publish Date: February 13, 2015  """.trimMargin(),
            """ Interstellar is a visually stunning sci-fi epic that explores the depths of space and time.
               | -Rating: 8.6/10 
               | -Publish Date: November 7, 2014  """.trimMargin(),
            """ In Captain America: The Winter Soldier, Steve Rogers teams up with Black Widow and the Falcon to uncover a conspiracy within S.H.I.E.L.D
               | -Rating: 7.7/10
               | -Publish Date: April 4, 2014  """.trimMargin(),
            """ The Hobbit: An Unexpected Journey takes audiences on an adventure with Bilbo Baggins, who is swept into an epic quest to reclaim the Lonely Mountain from the dragon Smaug.
               | -Rating: 7.8/10 
               |  -Publish Date: December 14, 2012  """.trimMargin(),
            """ Cold Skin is a haunting tale set on a remote island where a weather observer discovers that he is not alone .
| -Rating: 6.0/10 
| -Publish Date: September 7, 2017  """
        )
        
        newArrayList = ArrayList()
        for (i in descripe.indices) {
            val film = Films(imgeid[i], descripe[i])
            newArrayList.add(film)
        }

        
        adapter = MyAdapter(newArrayList)
       newRecyclerView .adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_more -> {
                addMoreItems((newRecyclerView.adapter as MyAdapter))
                true
            }
            android.R.id.home -> {
                finishAffinity()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

   fun addMoreItems(adapter: MyAdapter) {
        val newItems = arrayListOf(
            Films(R.drawable.newimg1, "The Shawshank Redemption\nDescription: The story of a banker sentenced to life imprisonment and his relentless pursuit of hope and freedom\nPublish Date: (1994)\nIMDb Rating: 9.3/10"),
            Films(R.drawable.newimg2, "The Dark Knight\nPublish Date: (2008)\nIMDb Rating: 9.0/10\nDescription: Batman battles the chaotic Joker, who seeks to dismantle Gotham’s moral fabric"),
            Films(R.drawable.newimg3, "Schindler's List\nPublish Date: (1993)\nIMDb Rating: 8.9/10\nDescription: A historical drama about Oskar Schindler, who saves over 1,000 Jews during the Holocaust"),
            Films(R.drawable.newimg4, "The Godfather Part II\nPublish Date: (1974)\nIMDb Rating: 9.0/10\nDescription: Chronicles the rise of young Vito Corleone and Michael's consolidation of power"),
            Films(R.drawable.newimg5, "Casablanca\nPublish Date: (1942)\nIMDb Rating: 8.5/10\nDescription: A timeless romance set during World War II, revolving around love, sacrifice, and resistance")
        )

        newArrayList.addAll(0, newItems)

        
        adapter.notifyItemRangeInserted(0, newItems.size)

      
        newRecyclerView.scrollToPosition(0)
    }
}
