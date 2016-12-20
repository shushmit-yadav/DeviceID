package com.eqtribe.getimeiorandroidid;

import android.content.Context;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        String deviceId = getDeviceId(getApplicationContext());
        textView.setText(deviceId);
    }
    private String getDeviceId(Context context) {
        String deviceId = null;
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(context.TELEPHONY_SERVICE);
        if(telephonyManager != null){
            deviceId = telephonyManager.getDeviceId();
        }
        if(deviceId == null || deviceId.length() == 0){
            deviceId = Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);
        }
        return deviceId;
    }
}
