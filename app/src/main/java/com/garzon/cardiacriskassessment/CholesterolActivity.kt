package com.garzon.cardiacriskassessment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.garzon.cardiacriskassessment.databinding.ActivityAgeBinding
import com.garzon.cardiacriskassessment.databinding.ActivityCholesterolBinding

class CholesterolActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityCholesterolBinding
    var report: Report? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCholesterolBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.setOnClickListener(this)
        binding.button2.setOnClickListener(this)
        binding.button3.setOnClickListener(this)
        binding.button4.setOnClickListener(this)
        binding.button5.setOnClickListener(this)
        binding.button6.setOnClickListener(this)

        intent.let {
            report = intent.extras?.getParcelable(MainActivity.REPORT) as Report?
        }
    }

    override fun onClick(p0: View?) {
        var score = when (p0?.id) {
            R.id.button1 -> 1
            R.id.button2 -> 2
            R.id.button3 -> 3
            R.id.button4 -> 4
            R.id.button5 -> 5
            R.id.button6 -> 7
            else -> 0
        }
        val outdateScore = report?.score
        if (outdateScore != null) {
            val newReport = Report(score + outdateScore)
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra(MainActivity.REPORT, newReport)
            startActivity(intent)
        }
    }
}