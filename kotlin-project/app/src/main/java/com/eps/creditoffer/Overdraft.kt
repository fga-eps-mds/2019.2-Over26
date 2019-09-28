package com.eps.creditoffer

import java.lang.Boolean.FALSE
import java.lang.Boolean.TRUE
import java.util.*

class Overdraft(UserId: Int){

    var userId: Int = UserId        // alterar para objeto Usuário
    var firstUseDate: Date
    var isActive: Boolean
    var limit: Float
    var limitMax: Float
    var limitUsed: Float
    var isBlocked: Boolean


    init {
        //requisição ao back
        firstUseDate = Date(10)
        isActive = TRUE
        limit = 100F
        limitMax = 200F
        limitUsed = 50F
        isBlocked = TRUE

    }
}