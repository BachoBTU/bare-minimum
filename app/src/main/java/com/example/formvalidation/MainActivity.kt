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
        val nameValid = validName() == null
        val surnameValid = validSurname() == null
        val emailValid = validEmailAddress() == null
        val passwordValid = validPassword() == null
        val checkBoxValid = validCheckBox() == null

        if (nameValid && surnameValid && emailValid && passwordValid && checkBoxValid) {
            Toast.makeText(this, "You are registered", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Houston, we have a problem", Toast.LENGTH_SHORT).show()
        }
    }
    private fun validName(): String?
    {
        val name = personName.text.toString()
        if(name.length < 3) {
            return "Name must be longer than 2 characters"
        }
        return null
    }

    private fun validSurname(): String? {
        val surname = personSurname.text.toString()
        if(surname.length < 5) {
            return "Surname must be longer than 4 characters"
        }
        return null
    }

    private fun validEmailAddress(): String? {
        val emailAddress = emailAddress.text.toString()
        if (!Patterns.EMAIL_ADDRESS.matcher(emailAddress).matches()){
            return "Invalid Email Address"
        }
        return null
    }

    private fun validPassword(): String? {
        val password = password.text.toString()

        if(password.length < 8){
            return "Password must be longer than 8 characters"
        }
        if (!password.matches(".*[0-9].*".toRegex())){
            return "Password must contain at least one number"
        }
        return null
    }

    private  fun validCheckBox(): String? {
        if(!checkBox.isChecked){
            return "You must check checkbox"
        }
        return null
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

