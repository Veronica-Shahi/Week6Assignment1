package com.example.week_6_assignment_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.week_6_assignment_1.model.UserData
import com.example.week_6_assignment_1.model.UserList

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var etusername : EditText
    private lateinit var etpassword : EditText
    private lateinit var btnlogin : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etusername = findViewById(R.id.etusername)
        etpassword = findViewById(R.id.etpassword)
        btnlogin = findViewById(R.id.btnlogin)
        students()
        btnlogin.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v?.id){
            R.id.btnlogin->{
                if (logincheck()){
                    Toast.makeText(this, "Login Sucessfull", Toast.LENGTH_SHORT).show()
                    val intent = Intent(
                        this,
                        DashboardActivity::class.java
                    )
                    startActivity(intent)
                }
                else{
                    Toast.makeText(this, "Invalid Login", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
    fun validateInput(): Boolean {
        if (etusername.text.toString() == "") {
            etusername.setError("Please enter username")
            return false
        }
        if (etpassword.text.toString() == "") {
            etpassword.setError("Please enter password")
            return false
        }
        return true
    }
    fun logincheck(): Boolean{
        if(validateInput()){
                if (etusername.text.toString() == "softwarica" &&  etpassword.text.toString() == "coventry"){
                    return true
                }
        }
        return false
    }
    private fun students() {
        UserList.addUser(UserData("yash", 15, "Male", "kalikot",
                "https://resize.indiatvnews.com/en/resize/newbucket/715_-/2019/06/yximgixc-1560324797.jpg"))
        UserList.addUser(UserData("Rajan", 19, "Male", "kalikot",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/4/49/%E0%AE%9A%E0%AF%82%E0%AE%AA%E0%AF%8D%E0%AE%AA%E0%AE%B0%E0%AF%8D%E0%AE%B8%E0%AF%8D%E0%AE%9F%E0%AE%BE%E0%AE%B0%E0%AF%8D_%E0%AE%B0%E0%AE%9C%E0%AE%BF%E0%AE%A9%E0%AE%BF%E0%AE%95%E0%AE%BE%E0%AE%A8%E0%AF%8D%E0%AE%A4%E0%AF%8D_-_Actor_Rajinikanth.jpg/150px-%E0%AE%9A%E0%AF%82%E0%AE%AA%E0%AF%8D%E0%AE%AA%E0%AE%B0%E0%AF%8D%E0%AE%B8%E0%AF%8D%E0%AE%9F%E0%AE%BE%E0%AE%B0%E0%AF%8D_%E0%AE%B0%E0%AE%9C%E0%AE%BF%E0%AE%A9%E0%AE%BF%E0%AE%95%E0%AE%BE%E0%AE%A8%E0%AF%8D%E0%AE%A4%E0%AF%8D_-_Actor_Rajinikanth.jpg"))
                //"data:image/jpeg;base64,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
    }
}