package com.garzon.cardiacriskassessment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.garzon.cardiacriskassessment.databinding.ActivityPressureBinding
import com.garzon.cardiacriskassessment.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        intent.let {
            val report = intent.extras?.getParcelable(MainActivity.REPORT) as Report?
            val message = getMessage(report?.score)
            binding.tvMessage.text = message
            binding.tvScore.text = "${getString(R.string.score)} ${report?.score}"
        }

    }

    fun getMessage(score: Int?): String{
        return when (score) {
            in 6..11 -> getString(R.string.result1)
            in 12..17 -> getString(R.string.result2)
            in 18..24 -> getString(R.string.result3)
            in 25..31 -> getString(R.string.result4)
            in 32..40 -> getString(R.string.result5)
            in 41..62 -> getString(R.string.result6)
            else -> getString(R.string.result7)
        }
    }
}