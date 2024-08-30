package mx.tec.login_shared

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import mx.tec.login_shared.databinding.ActivityMainBinding

class InicioActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var logoutButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setContentView(R.layout.activity_inicio)
        logoutButton = findViewById(R.id.cerrarButton)

        logoutButton.setOnClickListener {
            val sharedPreferences = getSharedPreferences("LoginPrefs", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putBoolean("isLoggedIn", false)
            editor.apply()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}


