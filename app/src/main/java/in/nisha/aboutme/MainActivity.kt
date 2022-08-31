package `in`.nisha.aboutme

import `in`.nisha.aboutme.databinding.ActivityMainBinding
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil

class MainActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityMainBinding
    private val myName : MyName = MyName("Zain")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.myName = myName

//        findViewById<Button>(R.id.button).setOnClickListener {
//            addNickName(it)
//        }

        binding.doneButton.setOnClickListener {
            addNickName(it)
        }
    }


    private fun addNickName(view: View)
    {
      binding.apply {
//          nickNameText.text = binding.nickNameEdit.text
          myName?.nickname = nickNameEdit.text.toString()
          invalidateAll()
          nickNameEdit.visibility = View.GONE
          doneButton.visibility = View.GONE
          nickNameText.visibility = View.VISIBLE
      }


        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken , 0)
    }
}