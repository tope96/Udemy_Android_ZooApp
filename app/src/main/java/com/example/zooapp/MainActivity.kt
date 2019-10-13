package com.example.zooapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.core.content.getSystemService
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.animal_ticket.view.*

class MainActivity : AppCompatActivity() {

    var listOfAnimals = ArrayList<Animal>()
    var adapter:AnimalAdapter ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listOfAnimals.add(Animal("Baboon", "Baboon is living in the newset zoo", R.drawable.baboon, false))
        listOfAnimals.add(Animal("Bulldog", "Bulldog is ugly", R.drawable.bulldog, true))
        listOfAnimals.add(Animal("Panda", "Panda is so nice!", R.drawable.panda, false))
        listOfAnimals.add(Animal("Swallow Bird", "It is just a bird wich swallows", R.drawable.swallow_bird, false))
        listOfAnimals.add(Animal("White Tiger", "Tiger which is soo racist", R.drawable.white_tiger, true))
        listOfAnimals.add(Animal("Zebra","Zebra is like a horse but wich stripes", R.drawable.zebra)    )

        adapter = AnimalAdapter(this, listOfAnimals)
        tvListAnimal.adapter = adapter
    }


    class AnimalAdapter:BaseAdapter{

        var listOfAnimals = ArrayList<Animal>()
        var context:Context ?= null

        constructor(context: Context, listOfAnimals:ArrayList<Animal>):super(){
            this.context = context
            this.listOfAnimals = listOfAnimals
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val animal = listOfAnimals[position]
            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var myView = inflator.inflate(R.layout.animal_ticket, null)
            myView.tvName.text = animal.name!!
            myView.tbDes.text = animal.des!!
            myView.ivAnmalImage.setImageResource(animal.image!!)
            return myView
        }

        override fun getItem(position: Int): Any {
            return listOfAnimals[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return listOfAnimals.size
        }

    }
}
