package com.example.researchaplication

import android.app.Dialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.example.researchaplication.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)


        val button = findViewById<Button>(R.id.button)
        val editText1 = findViewById<EditText>(R.id.editText1)
        val editText2 = findViewById<EditText>(R.id.editText2)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val checkGroup = findViewById<LinearLayout>(R.id.checkGroup)
        val checkBox  = findViewById<CheckBox>(R.id.checkBox)
        val checkBox2 = findViewById<CheckBox>(R.id.checkBox2)
        val checkBox3 = findViewById<CheckBox>(R.id.checkBox3)
        var radioChecked:String = ""
        var checkChecked:String = ""

        radioGroup.setOnCheckedChangeListener{
            group,checkedId ->
            when(checkedId){
                R.id.radioButton -> radioChecked = "예"
                R.id.radioButton2 -> radioChecked = "아니오"
                R.id.radioButton3 -> radioChecked = "잘 모르겠습니다"
            }
        }



        button.setOnClickListener {
            AlertDialog.Builder(this@MainActivity)
                .setTitle("설문내용")
                .setMessage("이름 :"+ editText1.text + "  질문 1 :" + checked + "  질문 3 :" + editText2.text)
                .setCancelable(false)
                .setNeutralButton("닫기", DialogInterface.OnClickListener{Dialog,which -> })
                .show()
        }

    }

    private fun checked(checkBox){
        checkBox.setOnCheckedChangeListener{ _, isChecked ->
            if(isChecked){

            }else{

            }
        }
    }



}