package com.example.kartik.cbpermissions;

import android.Manifest;
import android.app.ActivityManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class dialerActivity extends AppCompatActivity {

    EditText etPhNum; Button buttonDial, buttonCall;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialer);


        etPhNum = findViewById(R.id.etPhNum);
        buttonDial = findViewById(R.id.buttonDial);
        buttonCall = findViewById(R.id.buttonCall);

        buttonCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //checking for permission to call directly.
                int permissionStatus = ContextCompat.checkSelfPermission(dialerActivity.this, Manifest.permission.CALL_PHONE);
                if (permissionStatus == PackageManager.PERMISSION_GRANTED){
                    Uri uri = Uri.parse("tel:"+etPhNum.getText().toString());
                    Intent i = new Intent(Intent.ACTION_CALL, uri);
                    startActivity(i);
                }
                else{
                    ActivityCompat.requestPermissions(dialerActivity.this,
                            new String[]{ Manifest.permission.CALL_PHONE },
                            01);
                }


            }
        });
        buttonDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("tel:" + etPhNum.getText().toString());
                Intent i = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(i);
            }
        });
    }
}
