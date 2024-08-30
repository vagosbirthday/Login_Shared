package mx.tec.login_shared

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import mx.tec.login_shared.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val correctUser = "admin"
    private val correctPassword = "12345"
    private lateinit var binding: ActivityMainBinding
    private lateinit var userText: EditText
    private lateinit var passwordText: EditText
    private lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val sharedPreferences = getSharedPreferences("LoginPrefs", Context.MODE_PRIVATE)
        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false)

        if (isLoggedIn) {
            val intent = Intent(this, InicioActivity::class.java)
            startActivity(intent)
            finish()
            return
        }
        setContentView(R.layout.activity_main)
        userText = findViewById(R.id.userText)
        passwordText = findViewById(R.id.passwordText)
        loginButton = findViewById(R.id.button2)

        loginButton.setOnClickListener {
            val inputUser = userText.text.toString()
            val inputPassword = passwordText.text.toString()

            if (inputUser == correctUser && inputPassword == correctPassword) {
                val editor = sharedPreferences.edit()
                editor.putBoolean("isLoggedIn", true)
                editor.apply()
                val intent = Intent(this, InicioActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Usuario y/o contraseña incorrectos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}


