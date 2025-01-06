package com.jordel.projectecafeteria.usuaris_I_Identificacio

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.jordel.projectecafeteria.R
import com.jordel.projectecafeteria.databinding.ActivityMainBinding
import com.jordel.projectecafeteria.databinding.ActivityMainRegistreBinding

class MainActivityRegistre : AppCompatActivity() {
    val veiwModel: RegistreVM by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainRegistreBinding = DataBindingUtil.setContentView(this, R.layout.activity_main_registre)


        enableEdgeToEdge()
        //setContentView(R.layout.activity_main_registre)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.buttonCrearUsuario.setOnClickListener {
            if (binding.editTextNomRegistre.text.toString().isEmpty() || binding.editTextConrasenaRegistre.text.toString().isEmpty()){
                Toast.makeText(this, "El nombre y la contraseña no pueden estar vacios", Toast.LENGTH_LONG).show()
            }else if (binding.editTextConrasenaRegistre.text.length != 4){
                Toast.makeText(this, "La contraseña debe tener 4 caracteres", Toast.LENGTH_LONG).show()
            }else{
                veiwModel.crearUsuario(binding.editTextNomRegistre.text.toString(), binding.editTextConrasenaRegistre.text.toString())
                Toast.makeText(this, "Usuario creado correctamente", Toast.LENGTH_LONG).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }

        binding.buttonGoLogin.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}