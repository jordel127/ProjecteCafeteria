package com.jordel.projectecafeteria.usuaris_I_Identificacio

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.jordel.projectecafeteria.Home.ActivityHome
import com.jordel.projectecafeteria.R
import com.jordel.projectecafeteria.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private val veiwModel: LoginVM by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread.sleep(1000)
        installSplashScreen()

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        enableEdgeToEdge()
       //setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



        binding.buttonLogIn.setOnClickListener {

            if (veiwModel.logIn(binding.editTextNombreUsuario.text.toString(), binding.editTextPasswordUsuario.text.toString()))
            {
                Toast.makeText(this, "Usuario y contraseña correctos", Toast.LENGTH_LONG).show()
                val intent = Intent(this, ActivityHome::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_LONG).show()
            }
        }

        binding.buttonRegistre.setOnClickListener {
            val intent = Intent(this, MainActivityRegistre::class.java)
            startActivity(intent)
        }
    }
}