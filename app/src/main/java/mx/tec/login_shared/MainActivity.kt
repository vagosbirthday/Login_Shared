package mx.tec.login_shared

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val correctUser = "admin"
    private val correctPassword = "12345"
    //Lateinit
    private lateinit var userText: EditText
    private lateinit var passwordText: EditText
    private lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        userText = findViewById(R.id.userText)
        passwordText = findViewById(R.id.passwordText)
        loginButton = findViewById(R.id.button2)

        loginButton.setOnClickListener {
            val inputUser = userText.text.toString()
            val inputPassword = passwordText.text.toString()
            if (inputUser == correctUser && inputPassword == correctPassword) {
                val intent = Intent(this, InicioActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}


