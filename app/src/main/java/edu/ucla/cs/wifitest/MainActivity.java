package edu.ucla.cs.wifitest;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button ssid = (Button) findViewById(R.id.ssid);
        ssid.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                WifiManager wManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
                WifiInfo info = wManager.getConnectionInfo();
                TextView txt = (TextView)findViewById(R.id.textView);
                txt.setText(info.getSSID());
                // TODO Auto-generated method stub
            }
        });
        Button ip = (Button) findViewById(R.id.ip);
        ip.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                WifiManager wManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
                WifiInfo info = wManager.getConnectionInfo();
                int ip  = info.getIpAddress();
                String ipStr =
                        String.format("%d.%d.%d.%d",
                                (ip & 0xff),
                                (ip >> 8 & 0xff),
                                (ip >> 16 & 0xff),
                                (ip >> 24 & 0xff));
                TextView txt = (TextView)findViewById(R.id.textView);
                txt.setText(ipStr);
                // TODO Auto-generated method stub
            }
        });
        Button link_speed = (Button) findViewById(R.id.link_spd);
        link_speed.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                WifiManager wManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
                WifiInfo info = wManager.getConnectionInfo();
                TextView txt = (TextView)findViewById(R.id.textView);
                txt.setText(Integer.toString(info.getLinkSpeed()));
                // TODO Auto-generated method stub
            }
        });
//        Button freq = (Button) findViewById(R.id.freq);
//        freq.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                WifiManager wManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
//                WifiInfo info = wManager.getConnectionInfo();
//                TextView txt = (TextView)findViewById(R.id.textView);
//                txt.setText(Integer.toString(info.getFrequency()));
//                // TODO Auto-generated method stub
//            }
//        });
    }
}
