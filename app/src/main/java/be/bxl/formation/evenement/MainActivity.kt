package be.bxl.formation.evenement

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var ajouter: Button
    lateinit var rvEvenement: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ajouter = findViewById(R.id.ajouter_event)
        rvEvenement = findViewById(R.id.recyclerview)
        ajouter.setOnClickListener { openActivityAddEvent() }

    }

    fun openActivityAddEvent() {
        val intent: Intent = Intent(applicationContext, activity_addEvent::class.java)
        startActivity(intent)

    }
}
