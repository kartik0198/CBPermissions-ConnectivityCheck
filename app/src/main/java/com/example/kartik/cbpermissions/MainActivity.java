package com.example.kartik.cbpermissions;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button1, buttonDialer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConnectivityManager cm = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = cm.getActiveNetworkInfo();
                boolean isconnected = networkInfo!= null && networkInfo.isConnected();
                Toast.makeText(MainActivity.this,
                        (isconnected ? "Yes, you're connected to the world wide web!" : "No, you're offline!"),
                        Toast.LENGTH_SHORT).show();
            }
        });
        buttonDialer = findViewById(R.id.buttonDialer);
        buttonDialer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, dialerActivity.class );
                startActivity(i);
            }
        });
    }
}
