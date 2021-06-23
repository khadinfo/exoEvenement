package be.bxl.formation.evenement

import android.content.DialogInterface
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.format.DateFormat
import android.widget.Button
import android.widget.CalendarView
import android.widget.EditText
import android.widget.ImageButton
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class activity_addEvent : AppCompatActivity() {
    lateinit var date: EditText
    lateinit var description: EditText
    lateinit var lieu: EditText
    lateinit var calendar: ImageButton
    lateinit var valider: Button
    lateinit var annuler: Button

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_event)
        date = findViewById(R.id.date)
        date.setText(LocalDate.now().toString())
        description = findViewById(R.id.description)
        lieu = findViewById(R.id.lieu)
        calendar = findViewById(R.id.btn_calendar)
        valider = findViewById(R.id.valider)
        annuler = findViewById(R.id.annuler)

        calendar.setOnClickListener { openDialogCalendar() }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun openDialogCalendar() {

        val dialogBuilder = AlertDialog.Builder(this)
        val calendar: CalendarView = CalendarView(this)
        calendar.setOnDateChangeListener { view, year, month, dayOfMonth ->
            val dateChoice: LocalDate = LocalDate.of(year, month + 1, dayOfMonth)
            val formatDate: DateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yy")
            date.setText(dateChoice.format(formatDate).toString())
        }
        // change la vue pour ajouter le calendrier
        dialogBuilder.setView(calendar)
            // ajouter la croix pour fermer la boite de dialog
            .setCancelable(true)
            // positive button text and action
            .setPositiveButton("Valider", DialogInterface.OnClickListener { dialog, id ->

            })
            // negative button text and action
            .setNegativeButton("Annuler", DialogInterface.OnClickListener { dialog, id ->
                dialog.cancel()
            })

        val alert = dialogBuilder.create()
        alert.setTitle("Calendrier")
        alert.show()
    }


    fun takDate() {
        this.finish()
    }
}