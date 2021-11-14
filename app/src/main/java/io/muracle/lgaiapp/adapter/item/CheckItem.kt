package io.muracle.lgaiapp.adapter.item

import java.util.*

class CheckItem{
    val id:Int
    val name:String
    var isCheck:Boolean

    constructor(id:Int, name:String, isCheck:Boolean){
        this.id = id
        this.name = name
        this.isCheck = isCheck
    }

    fun check(isCheck: Boolean){
        this.isCheck = isCheck
    }
}