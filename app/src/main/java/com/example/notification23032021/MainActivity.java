package com.example.notification23032021;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationManager;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button mBtnSendNotification;
    String channelId = "CHANNEL_APP";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnSendNotification = findViewById(R.id.buttonSendNotification);

        mBtnSendNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(MainActivity.this, "CHANNEL_APP" );
                notificationBuilder.setSmallIcon(android.R.drawable.ic_dialog_email);
                notificationBuilder.setShowWhen(true);
                notificationBuilder.setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher));
                notificationBuilder.setContentTitle("Ứng dụng có bản cập nhật mới");
                notificationBuilder.setContentText("Phiên bản ra mắt vào ngày 27/05/2021");
                notificationBuilder.setPriority(NotificationCompat.PRIORITY_HIGH);
                notificationBuilder.setVibrate(new long[] { 1000, 1000, 1000, 1000, 1000 });
                notificationBuilder.setLights(Color.RED, 3000, 3000);
                notificationBuilder.setSound(Settings.System.DEFAULT_NOTIFICATION_URI);

                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

                notificationManager.notify(1,notificationBuilder.build());
            }
        });
    }
}