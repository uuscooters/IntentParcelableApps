package com.resmana.myintentapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var tvResult: TextView

    companion object {
        private const val REQUEST_CODE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//      Pindah Activity tanpa membawa data / Explicit
        val btnMoveActivity:Button = findViewById(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener(this)

//      Pindah Activity dengan membawa data
        val btnMoveDataActivity: Button = findViewById(R.id.btn_move_activity_data)
        btnMoveDataActivity.setOnClickListener(this)

//      Pindah Activity dengan membawa Object data class Parcelable
        val btnMoveWithObject:Button = findViewById(R.id.btn_move_activity_object)
        btnMoveWithObject.setOnClickListener(this)

//      Pindah Activity dengan metode Implicit
        val dialNumber: Button = findViewById(R.id.btn_dial_number)
        dialNumber.setOnClickListener(this)

//      Pindah Activity dengan StartActivityForResult
        val btnMoveForResult:Button = findViewById(R.id.btn_move_for_result)
        btnMoveForResult.setOnClickListener(this)

        tvResult = findViewById(R.id.tv_result)

    }

    override fun onClick(v: View?){
        when (v?.id) {
            R.id.btn_move_activity -> {
                val moveActivity = Intent(this@MainActivity, MoveActivity::class.java)
                startActivity(moveActivity)
            }

            R.id.btn_move_activity_data -> {
                val moveWithDataIntent =  Intent(this@MainActivity, MoveWithDataActivity::class.java)
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "Uus Resmana")
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 29)
                startActivity(moveWithDataIntent)
            }

            R.id.btn_move_activity_object -> {
                val person = Person(
                    "Uus Resmana",
                    29,
                    "resmana91@gmail.com",
                    "Depok"
                )

                val moveWithObjectIntent = Intent(this@MainActivity, MoveWithObjectActivity::class.java)
                moveWithObjectIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON, person)
                startActivity(moveWithObjectIntent)
            }

            R.id.btn_dial_number -> {
                val phoneNumber = "08998345930"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }

            R.id.btn_move_for_result -> {
                val moveForResultIntent = Intent(this@MainActivity, MoveForResultActivity::class.java)
                startActivityForResult(moveForResultIntent, REQUEST_CODE)
            }

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE) {
            if (resultCode == MoveForResultActivity.RESULT_CODE) {
                val selectedValue = data?.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE, 0)
                tvResult.text = "Hasil : $selectedValue"
            }
        }
    }
}