package id.ac.stmi.myapplication3sesi2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ImplicitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_implicit)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val buttonContact = findViewById<Button>(R.id.button_contact)
        buttonContact.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:*888%23")
            startActivity(intent)
        }

        val buttonBrowser = findViewById<Button>(R.id.button_browser)
        buttonBrowser.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("https://www.google.com")
            }
            startActivity(intent)
        }
        val buttonShare = findViewById<Button>(R.id.button_share)
        buttonShare.setOnClickListener {
            val sendIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "Halo, ini pesan yang dikirim.")
                type = "text/plain"
            }
            val shareIntent = Intent.createChooser(sendIntent, "Bagikan lewat")
            startActivity(shareIntent)
        }
    }
}