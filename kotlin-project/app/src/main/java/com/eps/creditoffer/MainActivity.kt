package com.eps.creditoffer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.app.NotificationCompat
import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Context
import androidx.core.app.NotificationManagerCompat
import android.app.AlarmManager
import android.os.SystemClock
import android.media.RingtoneManager
import android.graphics.drawable.BitmapDrawable
import android.app.Notification



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val user = UserLink()
        user.get(2)

        //criarNotificacaoSimples()

        scheduleNotification(criarNotificacaoSimples(), 10000)

        println("----MainActivity.onCreate----")
    }

    override fun onResume() {
        super.onResume()
        println("----MainActivity.onResume----")
    }

    fun overdraftScreen(view: View) {
        val overdraft = OverdraftLink()
        overdraft.get(1)
        if(overdraft.isActive) {
            val intent = Intent(this, TrackLimit::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
            startActivityIfNeeded(intent, 0)
        }
        else {
            Toast.makeText(this, "Overdraft Desativado!", Toast.LENGTH_LONG).show()
        }
    }

    fun activeOverdraft(view: View) {
        val overdraft = OverdraftLink()
        overdraft.get(1)
        if(overdraft.isActive) {
            Toast.makeText(this, "Overdraft Ativo!", Toast.LENGTH_LONG).show()
        }
        else {
            val intent = Intent(this, Eligibility::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
            startActivityIfNeeded(intent, 0)
        }
    }

    fun criarNotificacaoSimples() : Notification{
        val id = 1
        val titulo = "Título da Notificação"
        val texto = "Texto da notificação Simples"
        val icone = android.R.drawable.ic_dialog_info

        val intent = Intent(this, MainActivity::class.java)
        val p = getPendingIntent(id, intent, this)

        val notificacao = NotificationCompat.Builder(this)
        notificacao.setSmallIcon(icone)
        notificacao.setContentTitle(titulo)
        notificacao.setContentText(texto)
        notificacao.setContentIntent(p)

        //val nm = NotificationManagerCompat.from(this)
        //nm.notify(id, notificacao.build())

        return notificacao.build()
    }

    private fun getPendingIntent(id: Int, intent: Intent, context: Context): PendingIntent {
        val stackBuilder = TaskStackBuilder.create(context)
        stackBuilder.addParentStack(intent.component)
        stackBuilder.addNextIntent(intent)

        return stackBuilder.getPendingIntent(id, PendingIntent.FLAG_UPDATE_CURRENT)
    }


    private fun scheduleNotification(notification: Notification, delay: Int) {

        val notificationIntent = Intent(this, NotificationPublisher::class.java)
        notificationIntent.putExtra(NotificationPublisher.NOTIFICATION_ID, 1)
        notificationIntent.putExtra(NotificationPublisher.NOTIFICATION, notification)
        val pendingIntent = PendingIntent.getBroadcast(
            this,
            0,
            notificationIntent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )

        val futureInMillis = SystemClock.elapsedRealtime() + delay
        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, futureInMillis, pendingIntent)
    }

}

