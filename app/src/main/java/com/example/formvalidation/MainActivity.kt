package com.example.formvalidation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var personName: EditText
    private lateinit var personSurname: EditText
    private lateinit var emailAddress: EditText
    private lateinit var password: EditText
    private lateinit var checkBox: CheckBox
    private lateinit var submitBtn: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()

        submitBtn.setOnClickListener { submitForm() }
    }

    private fun submitForm() {

        if (validName() && validSurname() && validEmailAddress() && validPassword() && validCheckBox()) {
            Toast.makeText(this, "You are registered", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Houston, we have a problem", Toast.LENGTH_SHORT).show()
        }
    }
    private fun validName(): Boolean {
        val name = personName.text.toString()
        if(name.length < 3) {
            return false
        }
        return true
    }

    private fun validSurname(): Boolean {
        val surname = personSurname.text.toString()
        if(surname.length < 5) {
            return false
        }
        return true
    }

    private fun validEmailAddress(): Boolean {
        val emailAddress = emailAddress.text.toString()
        if (!Patterns.EMAIL_ADDRESS.matcher(emailAddress).matches()){
            return false
        }
        return true
    }

    private fun validPassword(): Boolean {
        val password = password.text.toString()

        if(password.length < 8){
            return false
        }
        if (!password.matches(".*[0-9].*".toRegex())){
            return false
        }
        return true
    }

    private  fun validCheckBox(): Boolean {
        if(!checkBox.isChecked){
            return false
        }
        return true
    }

    private fun init() {
        personName = findViewById(R.id.personName)
        personSurname = findViewById(R.id.personSurname)
        emailAddress = findViewById(R.id.emailAddress)
        password = findViewById(R.id.password)
        checkBox = findViewById(R.id.checkBox)
        submitBtn = findViewById(R.id.submitBtn)
    }

}

