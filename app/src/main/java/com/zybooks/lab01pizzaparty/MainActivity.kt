package com.zybooks.lab01pizzaparty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import kotlin.math.ceil

const val SLICES_PER_PIZZA = 8


/**
 * This is the main class
 *
 * @author Ryan Yates
 * @since 1.0.0
 * @param no param
 * @constructor Default
 * @property Calculate and edit the pizza party app
 */
class MainActivity : AppCompatActivity()
{

    private lateinit var numAttendEditText: EditText
    private lateinit var numPizzasTextView: TextView
    private lateinit var howHungryRadioGroup: RadioGroup

    /**
     * Calls and recreates the activity and loads all data from savedInstanceState
     *
     * Also assigns the variables listed above with their widgets in the XML file
     */
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        numAttendEditText = findViewById(R.id.editTextNumber)
        numPizzasTextView = findViewById(R.id.totalPizzas)
        howHungryRadioGroup = findViewById(R.id.hungry_radio_group)
    }

    /**
     * Converts the string number for how many people into an int and calculates totalPizzas based on selections and input
     *
     *@return Total pizzas
     * @see [slicesPerPerson] for variables used in calculations
     */
    fun calculateOnClick(view: View)
    {
        //Grabs text from EditText
        val numAttendStr = numAttendEditText.text.toString()

        //Converts the text into an Int
        val numAttend = numAttendStr.toInt()

        //Assigns slicesPerPerson with 1, 2, or 3 based on chosen RadioButton
        val slicesPerPerson = when (howHungryRadioGroup.checkedRadioButtonId)
        {
            R.id.light_radio_button -> 2
            R.id.medium_radio_button -> 3
            else -> 4
        }

        //Calculates total pizzas and replaces text in totalPizzas TextView
        val totalPizzas = ceil(numAttend * slicesPerPerson / SLICES_PER_PIZZA.toDouble()).toInt()
        numPizzasTextView.text = "Total Pizzas: $totalPizzas"
    }

}