package test.task.testtask2

import android.content.res.Configuration
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import test.task.testtask2.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    private var x2 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("SecondActivity", "onCreate() lifecycle")
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val count = intent.getStringExtra("1")!!.toInt()
        x2 = count * count
        binding.number.text = x2.toString()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
    }

    override fun onStart() {
        super.onStart()
        Log.i("SecondActivity", "onStart() lifecycle")
    }

    override fun onPause() {
        super.onPause()
        Log.i("SecondActivity", "onPause() lifecycle")
    }

    override fun onResume() {
        super.onResume()
        Log.i("SecondActivity", "onResume() lifecycle")
    }

    override fun onStop() {
        super.onStop()
        Log.i("SecondActivity", "onStop() lifecycle")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("SecondActivity", "onDestroy() lifecycle")
    }
}