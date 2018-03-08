package com.zxyw.mqdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.zxyw.mqtt.MQTTService;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;
import de.greenrobot.event.ThreadMode;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        EventBus.getDefault().register(this);
        startService(new Intent(this, MQTTService.class));
        findViewById(R.id.publishBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MQTTService.publish("111111111111111111");
            }
        });
    }

//    @Subscribe(threadMode = ThreadMode.MAIN)
//    public void getMqttMessage(MQTTMessage mqttMessage){
//        Log.i(MQTTService.TAG,"get message:"+mqttMessage.getMessage());
//        Toast.makeText(this,mqttMessage.getMessage(),Toast.LENGTH_SHORT).show();
//    }

    @Override
    protected void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }
}
