package com.example.week_6_assignment_1.model

import android.os.Parcel
import android.os.Parcelable

data class UserData(
        var etfullname : String? = null,
        var etage : Int? = null,
        var gender : String? = null,
        var etaddress : String? = null,
        var etimage : String? = null
):Parcelable{
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readValue(Int::class.java.classLoader) as? Int,
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(etfullname)
        parcel.writeValue(etage)
        parcel.writeString(gender)
        parcel.writeString(etaddress)
        parcel.writeString(etimage)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UserData> {
        override fun createFromParcel(parcel: Parcel): UserData {
            return UserData(parcel)
        }

        override fun newArray(size: Int): Array<UserData?> {
            return arrayOfNulls(size)
        }
    }
}