package com.example.researchaplication

import android.app.Dialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.example.researchaplication.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val age = resources.getStringArray(R.array.age)
        val adapter = ArrayAdapter(this, R.layout.item_spinner, age)
        val spinner = findViewById<Spinner>(R.id.spinner)
        val button = findViewById<Button>(R.id.button)
        val editText1 = findViewById<EditText>(R.id.editText1)
        val editText2 = findViewById<EditText>(R.id.editText2)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val checkBox  = findViewById<CheckBox>(R.id.checkBox)
        val checkBox2 = findViewById<CheckBox>(R.id.checkBox2)
        val checkBox3 = findViewById<CheckBox>(R.id.checkBox3)
        var radioChecked:String = "예"
        var checkChecked:String = ""
        var selected:String = ""

        radioGroup.setOnCheckedChangeListener{
            group,checkedId ->
            when(checkedId){
                R.id.radioButton -> radioChecked = "예"
                R.id.radioButton2 -> radioChecked = "아니오"
                R.id.radioButton3 -> radioChecked = "잘 모르겠습니다"
            }
        }

        CompoundButton.OnCheckedChangeListener { view, ischecked ->
            if (ischecked) {
                when (view.id) {
                    R.id.checkBox -> {
                        checkChecked = "중국어"
                    }
                    R.id.checkBox2 -> {
                        checkChecked = "일본어"
                    }
                    R.id.checkBox3 -> {
                        checkChecked = "그 외"
                    }
                }
            }
        }

        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, view: View?, pos: Int, id: Long) {
                selected = spinner.getItemAtPosition(pos) as String
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }


        button.setOnClickListener {
            AlertDialog.Builder(this@MainActivity)
                .setTitle("설문내용")
                .setMessage("이름 :"+ editText1.text + "   질문 1 :" + radioChecked + "   질문 2 :" + checkChecked + "   질문 3 :" + editText2.text + "   질문 4 :" + selected)
                .setCancelable(false)
                .setNeutralButton("닫기", DialogInterface.OnClickListener{Dialog,which -> })
                .show()
        }

    }

}