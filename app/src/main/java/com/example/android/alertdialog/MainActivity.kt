package com.example.android.alertdialog

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private var ibSnakeBar: ImageButton? = null
    private var btnAlertDialog: Button? = null
    private var btnCustomDialog: Button? = null
    private var btnCustomProgressDialog: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ibSnakeBar = findViewById(R.id.ibSnakeBar)
        btnAlertDialog = findViewById(R.id.btnAlertDialog)
        btnCustomDialog = findViewById(R.id.btnCustomDialog)
        btnCustomProgressDialog = findViewById(R.id.btnCustomProgressDialog)

        ibSnakeBar?.setOnClickListener { view ->
            Snackbar.make(view, "You have clicked image button", Snackbar.LENGTH_LONG).show()
        }

        btnAlertDialog?.setOnClickListener { view ->
            alertDialogFunction()
        }

        btnCustomDialog?.setOnClickListener { view ->
            customDialogFunction()
        }

        btnCustomProgressDialog?.setOnClickListener {
            customProgressDialogFunction()
        }
    }

    //alertDialogFunction method
    private fun alertDialogFunction() {
        //Use the builder class for convenient AlertDialog construction
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Alert")
        builder.setMessage("This is alert Dialog. Which is used to show alert in our app.")
        builder.setIcon(android.R.drawable.ic_dialog_alert)

        builder.setPositiveButton("Yes") { dialogInterface, _ ->
            Toast.makeText(applicationContext, "clicked yes", Toast.LENGTH_LONG).show()
            dialogInterface.dismiss()
        }

        builder.setNeutralButton("Cancel") {dialogInterface, _ ->
            Toast.makeText(applicationContext, "clicked cancel", Toast.LENGTH_LONG).show()
            dialogInterface.dismiss()
        }

        builder.setNegativeButton("No") {dialogInterface, _ ->
            Toast.makeText(applicationContext, "clicked no", Toast.LENGTH_LONG).show()
            dialogInterface.dismiss()
        }

        val alertDialog: AlertDialog = builder.create()
        alertDialog.setCancelable(false)
        alertDialog.show()
    }


    //customDialogFunction method
    private fun customDialogFunction() {
        val customDialog = Dialog(this)
        customDialog.setContentView(R.layout.dialog_custom)

        val tvSubmit = customDialog.findViewById<TextView>(R.id.tvSubmit)
        tvSubmit.setOnClickListener {
            Toast.makeText(applicationContext, "clicked submit", Toast.LENGTH_LONG).show()
            customDialog.dismiss()
        }

        val tvCancel = customDialog.findViewById<TextView>(R.id.tvCancel)
        tvCancel.setOnClickListener {
            Toast.makeText(applicationContext, "clicked cancel", Toast.LENGTH_LONG).show()
            customDialog.dismiss()
        }

        //start the dialog and display it on the screen
        customDialog.show()
    }


    //customProgressDialogFunction method
    private fun customProgressDialogFunction() {
        val progressBarDialog = Dialog(this)
        progressBarDialog.setContentView(R.layout.dialog_custom_progress)

        //progressBarDialog.setCancelable(false)

        progressBarDialog.show()
    }
}




















