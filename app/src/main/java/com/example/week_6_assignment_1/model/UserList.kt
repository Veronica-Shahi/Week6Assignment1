package com.example.week_6_assignment_1.model

object UserList {
    var lstUser = ArrayList<UserData>()
    fun addUser(userdata : UserData){
        lstUser.add(userdata)
    }
    fun fetchUser() : ArrayList<UserData>{
        return lstUser
    }
}