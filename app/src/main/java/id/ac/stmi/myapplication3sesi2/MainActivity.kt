package id.ac.stmi.myapplication3sesi2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private val TAG = "LifeCycleTest"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 1. Dipanggil saat Activity pertama kali dibuat
        Toast.makeText(this, "onCreate: Activity dibuat", Toast.LENGTH_SHORT).show()
        Log.d(TAG, "1. onCreate: Activity Dibuat")

        val buttonNavigate = findViewById<Button>(R.id.button_navigate)
        buttonNavigate.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        val buttonExplicit = findViewById<Button>(R.id.button_explicit_intent)
        buttonExplicit.setOnClickListener {
            val intent = Intent(this, ExplicitActivity::class.java)
            intent.putExtra("EXTRA_MESSAGE", "Ini adalah message dari Explicit Activity")
            startActivity(intent)
        }

        val buttonImplicit = findViewById<Button>(R.id.button_implicit_intent)
        buttonImplicit.setOnClickListener {
            val intent = Intent(this, ImplicitActivity::class.java)
            startActivity(intent)
        }

    }
    override fun onStart() {
        super.onStart()
        // 2. Dipanggil saat Activity mulai terlihat di layar
        Toast.makeText(this, "onStart: Activity Terlihat", Toast.LENGTH_SHORT).show()
        Log.d(TAG, "2. onStart: Activity Terlihat")
    }
    override fun onResume() {
        super.onResume()
        // 3. Dipanggil saat Activity mendapat fokus dan siap berinteraksi
        Toast.makeText(this, "onResume: Activity Siap Berinteraksi", Toast.LENGTH_SHORT).show()
        Log.d(TAG, "3. onResume: Activity Siap Berinteraksi")
    }
    override fun onPause() {
        super.onPause()
        // 4. Dipanggil saat Activity mulai kehilangan fokus (misal ada dialog atau mau pindah)
        Toast.makeText(this, "onPause: Activity Kehilangan Fokus", Toast.LENGTH_SHORT).show()
        Log.d(TAG, "4. onPause: Activity Kehilangan Fokus")
    }
    override fun onStop() {
        super.onStop()
        // 5. Dipanggil saat Activity sudah tidak terlihat lagi di layar
        Toast.makeText(this, "onStop: Activity Tidak Terlihat", Toast.LENGTH_SHORT).show()
        Log.d(TAG, "5. onStop: Activity Tidak Terlihat")
    }
    override fun onRestart() {
        super.onRestart()
        // 6. Dipanggil saat Activity dibuka kembali setelah berada dalam kondisi Stopped
        Toast.makeText(this, "onRestart: Activity Dibuka Kembali", Toast.LENGTH_SHORT).show()
        Log.d(TAG, "6. onRestart: Activity Dibuka Kembali")
    }

    override fun onDestroy() {
        super.onDestroy()
        // 7. Dipanggil sebelum Activity benar-benar dihancurkan oleh sistem atau ditutup (finish)
        Toast.makeText(this, "onDestroy: Activity Dihancurkan", Toast.LENGTH_SHORT).show()
        Log.d(TAG, "7. onDestroy: Activity Dihancurkan")
    }
}