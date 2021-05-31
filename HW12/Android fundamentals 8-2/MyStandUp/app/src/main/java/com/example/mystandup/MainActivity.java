package com.example.mystandup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private NotificationManager nManager;
    private static final int NOTIFICATION_ID = 0;
    private static final String PRIMARY_CHANNEL_ID = "primary_notification_channel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        ToggleButton mButton = findViewById(R.id.alarmToggle);
        Intent notifyIntent = new Intent(this, AlarmReceiver.class);
        boolean alarmUp = (PendingIntent.getBroadcast(this, NOTIFICATION_ID,
                notifyIntent, PendingIntent.FLAG_NO_CREATE) != null);
        mButton.setChecked(alarmUp);
        final PendingIntent notifyPendingIntent = PendingIntent.getBroadcast(this, NOTIFICATION_ID, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        final AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        mButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    String TMessage;
                    if(isChecked){
                        Calendar cal_alarm = Calendar.getInstance();
                        cal_alarm.setTimeInMillis(System.currentTimeMillis());
                        cal_alarm.set(Calendar.HOUR_OF_DAY,11);//set the alarm time
                        cal_alarm.set(Calendar.MINUTE, 11);
                        cal_alarm.set(Calendar.SECOND, 00);
                        cal_alarm.set(Calendar.MILLISECOND, 00);
                        if (cal_alarm.getTimeInMillis() <= System.currentTimeMillis()) {
                            cal_alarm.set(Calendar.DAY_OF_MONTH, cal_alarm.get(Calendar.DAY_OF_MONTH) + 1);
                        }
                        final long DAILY = 24 * 60 * 60 * 1000;
                        if (alarmManager != null) {
                            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, cal_alarm.getTimeInMillis(), DAILY, notifyPendingIntent);
                        }
                        TMessage = getString(R.string.toast_alarm_on);

                    }
                    else {
                        if (alarmManager != null){
                            alarmManager.cancel(notifyPendingIntent);
                        }
                        nManager.cancelAll();
                        TMessage = getString(R.string.toast_alarm_off);
                    }
                        Toast.makeText(MainActivity.this, TMessage, Toast.LENGTH_SHORT).show();
                    }
                });
        createNotificationChannel();

    }

    public void createNotificationChannel(){
        nManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel nChannel = new NotificationChannel(PRIMARY_CHANNEL_ID,
                    "11:11 am am notification.", NotificationManager.IMPORTANCE_HIGH);
            nChannel.enableLights(true);
            nChannel.setLightColor(Color.RED);
            nChannel.enableVibration(true);
            nChannel.setDescription("Notifies when it is 11:11 am");
            nManager.createNotificationChannel(nChannel);
        }
    }


}