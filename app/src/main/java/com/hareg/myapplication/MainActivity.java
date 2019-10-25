package com.hareg.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends PermissionsActivity {
    private static final String TAG="MainActivity";
    private Button startBtn;
    private Button stopBtn;

    @RequiresApi(api = Build.VERSION_CODES.O)
    MyOreoWifiManager mMyOreoWifiManager;


    @Override
    void onPermissionsOkay() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startBtn = (Button)findViewById(R.id.start_btn);
        stopBtn = (Button)findViewById(R.id.stop_btn);

        mMyOreoWifiManager = new MyOreoWifiManager(this);

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"startBtn onClick" );

                MyOnStartTetheringCallback callback = new MyOnStartTetheringCallback() {
                    @Override
                    public void onTetheringStarted() {

                    }

                    @Override
                    public void onTetheringFailed() {

                    }
                };
                mMyOreoWifiManager.startTethering(callback);

            }
        });

        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"stopBtn onClick" );
                mMyOreoWifiManager.stopTethering();
            }
        });



    }
}
