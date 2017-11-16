package com.baosight.broadcastbestpractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        MyLisener lisener=(a,b)->{
            String result=a+b;
            return result;
        };
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button offbtn=(Button)findViewById(R.id.force_offline);
        assert(offbtn!=null);
        offbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent("com.baosight.broadcastbestpractice.FROCE_OFFLINE");
                sendBroadcast(intent);
            }
        });

    }

}
