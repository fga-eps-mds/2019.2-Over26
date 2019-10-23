package com.eps.creditoffer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.os.StrictMode
import android.view.View
import android.widget.*
import com.eps.creditoffer.R.id.textValue
import kotlinx.android.synthetic.main.activity_cash_out.*
import java.text.NumberFormat


class CashOut : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cash_out)


        var transaction = TransactionLink()
        transaction.type="out"



        var textValue= findViewById(R.id.textValue) as EditText


        val optionsString= arrayOf("Compra com cartão", "Pagamento de boleto", "Transferência");
        cash_out_Spinner.adapter=ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,optionsString)

        cash_out_Spinner.onItemSelectedListener= object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

                transaction.description=optionsString[position]
            }
        }






        val retirarButton = findViewById(R.id.retirarButton) as Button

        retirarButton.setOnClickListener{

            var stringOfValue = textValue.text.toString()

            transaction.value = stringOfValue.toFloat()


            if (transaction.value <= 0F  || transaction.description == null) {

                if(transaction.description == null){
                    Toast.makeText(this, "Escolher forma de retirada.", Toast.LENGTH_LONG).show()
                }

                if(transaction.value <= 0F){
                    Toast.makeText(this, "Valor da retirada precisa ser positivo.", Toast.LENGTH_LONG).show()
                }


            }
            else {
                if(transaction.create()){

                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)

                }else{

                }

            }

        }

    }

    /* fun makeTransaction(view: View){

         var transaction = TransactionLink()
         transaction.type="in"

         if (transaction.value <= 0F  || transaction.description == null) {

             if(transaction.description == null){
                 Toast.makeText(this, "Escolher forma de retirada.", Toast.LENGTH_LONG).show()
             }

             if(transaction.value <= 0F){
             Toast.makeText(this, "Valor da retirada precisa ser positivo.", Toast.LENGTH_LONG).show()
             }




         } else {
             transaction.create()
         }

     }*/

}
