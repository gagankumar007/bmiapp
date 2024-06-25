package com.example.gagan1919

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.demoapp.R
import com.example.demoapp.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity(), View.OnClickListener {
    private  val binding by lazy {
        ActivityHomeBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.buttonCalculate.setOnClickListener(this)
    }
    private fun calculateBMI() {
        val heightStr = binding.editTextHeight.text.toString()
        val weightStr = binding.editTextWeight.text.toString()

        if (heightStr.isNotEmpty() && weightStr.isNotEmpty()) {
            val height = heightStr.toFloat()
            val weight = weightStr.toFloat()
            val bmi = weight / (height * height)

            binding.textViewResult.text = String.format("Your BMI: %.2f", bmi)
        } else {
            Toast.makeText(this, "Please enter valid height and weight", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.buttonCalculate -> calculateBMI()

        }
    }
}