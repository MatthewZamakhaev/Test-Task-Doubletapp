package test.task.testtask2

import android.content.Intent
import android.content.SharedPreferences
import android.content.res.Configuration
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import test.task.testtask2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var i = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("MainActivity", "onCreate() lifecycle")
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        checkData()
        binding.text.text = i.toString()

        binding.button.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("1", i.toString())
            startActivity(intent)
            finish()
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        i += 1
        binding.text.text = i.toString()
        val preferences: SharedPreferences =
            getSharedPreferences("Data", MODE_PRIVATE)
        val editor = preferences.edit()
        editor.putInt("number", i).apply()
    }

    private fun checkData(){
        val preferences: SharedPreferences =
            getSharedPreferences("Data", MODE_PRIVATE)
        i = preferences.getInt("number", i)
    }

    override fun onStart() {
        super.onStart()
        Log.i("MainActivity", "onStart() lifecycle")
    }

    override fun onPause() {
        super.onPause()
        Log.i("MainActivity", "onPause() lifecycle")
    }

    override fun onResume() {
        super.onResume()
        Log.i("MainActivity", "onResume() lifecycle")
    }

    override fun onStop() {
        super.onStop()
        Log.i("MainActivity", "onStop() lifecycle")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("MainActivity", "onDestroy() lifecycle")
    }
}