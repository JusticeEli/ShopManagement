package com.justice.shopmanagement.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "goods")
data class Goods (var name:String,var image:String ,var price:Int):Parcelable{

    @PrimaryKey(autoGenerate = true)
    var id:Int=0
}