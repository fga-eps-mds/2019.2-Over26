package com.eps.creditoffer

import java.lang.Boolean.TRUE
import java.util.*

class OverdraftDebtLink() {

    var entryDate: Date
    var amount: Float
    var rate: Float
    var isDivided: Boolean
    //var installment: <InstallmentsLink>
    var dueDate: Int
    var quantityInstallment: Int

    init {
        // requisição ao back
        entryDate = Date()
        amount = 11.1111F
        rate = 0.05F
        isDivided = TRUE
        dueDate = 0
        quantityInstallment = 1
    }
}