package com.gl4.pizza_delivery

import android.content.ContentValues.TAG
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var firstNameEditText: EditText
    private lateinit var lastNameEditText: EditText
    private lateinit var addressEditText: EditText
    private lateinit var sizeRadioGroup: RadioGroup
    private lateinit var linearLayout: LinearLayout
    private lateinit var orderButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firstNameEditText =
            findViewById(R.id.first_name_input_edit_text)
        lastNameEditText =
            findViewById(R.id.last_name_input_edit_text)
        addressEditText =
            findViewById(R.id.address_input_edit_text)

        sizeRadioGroup = findViewById(R.id.size_radio_group)

        linearLayout = findViewById(R.id.ingredients_linear_layout)

        orderButton = findViewById(R.id.order_button)

        orderButton.setOnClickListener {
            val order: String = getOrder()
            sendEmail()
            Log.d(TAG, order)
        }
    }

    private fun getUpdatedSize(): String {
        val selectedSizeId = findViewById<RadioButton>(sizeRadioGroup.checkedRadioButtonId)
        return selectedSizeId.text.toString()
    }

    private fun getUpdatedIngredients(): String {
        val ingredientsList: MutableList<String> = mutableListOf()

        for (i in 0 until linearLayout.childCount) {
            val childView: View = linearLayout.getChildAt(i)

            if (childView is CheckBox && childView.isChecked) {
                ingredientsList.add(childView.text.toString())
            }
        }

        return if (ingredientsList.joinToString() != "") {
            ingredientsList.joinToString(", ")
        } else "no additional toppings"
    }

    private fun getOrder(): String {
        val firstName: String = firstNameEditText.text.toString()
        val lastName: String = lastNameEditText.text.toString()
        val address: String = addressEditText.text.toString()
        val size: String = getUpdatedSize()
        val ingredients: String = getUpdatedIngredients()

        return "$firstName $lastName at $address ordered a $size Pizza with $ingredients."
    }

    private fun sendEmail() {
        val order: String = getOrder()
        val intentEmail = Intent(
            Intent.ACTION_SEND,
            Uri.parse("mailto:")
        )
        intentEmail.putExtra(Intent.EXTRA_EMAIL, arrayOf("mohamedaziz.bellaaj@insat.ucar.tn"))
        intentEmail.putExtra(Intent.EXTRA_SUBJECT, "Pizza Delivery")
        intentEmail.putExtra(Intent.EXTRA_TEXT, order)

        intentEmail.type = "text/plain"
        startActivity(Intent.createChooser(intentEmail, "Choose an email app"))
    }
}