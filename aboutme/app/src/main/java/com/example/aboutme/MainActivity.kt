package com.example.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.Main2Binding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: Main2Binding

    private val myName: MyName = MyName("123098", " 123123")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.main2)
        binding = DataBindingUtil.setContentView( this, R.layout.main2 )
        binding.myName = myName

//        findViewById<Button>(R.id.button).setOnClickListener {
//            addNickname(it)
//        }
        binding.button.setOnClickListener{
            addNickname(it)
        }

    }

    private fun addNickname(view: View) {
        val editText = findViewById<EditText>(R.id.nameedit)
        val nicknameTextView = findViewById<TextView>(R.id.nametext)

//        nicknameTextView.text = editText.text
//        editText.visibility = View.GONE
//        view.visibility = View.GONE
//        nicknameTextView.visibility = View.VISIBLE

        binding.apply {
//            binding.nametext.text = binding.nameedit.text
            myName?.nickname = nameedit.text.toString()
            invalidateAll()
            binding.nameedit.visibility = View.GONE
            binding.button.visibility = View.GONE
            binding.nametext.visibility = View.VISIBLE
        }

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
