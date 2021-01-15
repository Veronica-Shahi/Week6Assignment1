package com.example.week_6_assignment_1.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.week_6_assignment_1.R
import com.example.week_6_assignment_1.model.UserData
import com.example.week_6_assignment_1.model.UserList


class AddstudentFragment : Fragment(), View.OnClickListener {
    private lateinit var etfullname : EditText
    private lateinit var etage : EditText
    private lateinit var etimage : EditText
    private lateinit var etaddress : EditText
    private lateinit var radiogroup : RadioGroup
    private lateinit var rbmale: RadioButton
    private lateinit var rbfemale: RadioButton
    private lateinit var rbother: RadioButton
    private lateinit var btnsave: Button
    var stdlst = ArrayList<UserData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_addstudent, container, false)

        etfullname = view.findViewById(R.id.etfullname)
        etage = view.findViewById(R.id.etage)
        etimage = view.findViewById(R.id.etimage)
        etaddress = view.findViewById(R.id.etaddress)
        radiogroup = view.findViewById(R.id.radiogroup)
        rbmale = view.findViewById(R.id.rbmale)
        rbfemale = view.findViewById(R.id.rbfemale)
        rbother = view.findViewById(R.id.rbother)
        btnsave = view.findViewById(R.id.btnsave)

        btnsave.setOnClickListener(this)

        return view
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnsave->{
                var name = etfullname.text.toString()
                var age = etage.text.toString().toInt()
                var gender = radiogroup.checkedRadioButtonId.toString()
                if(radiogroup.checkedRadioButtonId !=1){
                    if (rbmale.isChecked)
                    {
                        gender = "Male"
                    }
                    else if (rbfemale.isChecked)
                    {
                        gender = "Female"
                    }
                    else
                    {
                        gender = "Other"
                    }

                }
                var address = etaddress.text.toString()
                var image = etimage.text.toString()
                UserList.addUser(UserData(name,age,gender,address,image))


                etfullname.setText("")
                etage.setText("")
                rbmale.isChecked=false
                rbfemale.isChecked=false
                rbother.isChecked=false
                etaddress.setText("")
                etimage.setText("")

                Toast.makeText(context!!,"New Student Added", Toast.LENGTH_SHORT).show()
            }
        }
    }

}