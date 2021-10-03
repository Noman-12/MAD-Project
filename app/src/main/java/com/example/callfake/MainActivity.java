package com.example.callfake;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    /*getting id of image button and editText*/
    ImageButton btn_call;
    EditText et_num;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_call = findViewById(R.id.buttoncallid);
        et_num = findViewById(R.id.numid);

    /*applying Clicklistener method on Button(btn_call)*/
        btn_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                call_the_number();
            }
        });
    }

    private void call_the_number()
    {
        /*setting permission for phone call*/
        String number = et_num.getText().toString().trim();
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) !=
                PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE},1234);
        }
        else

            /*checking that user have entered number or not, if user entered the num then if condition will be applied
            * if not then else condition will be applied*/
            {
            if (number.length() > 0)
            {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + number));
                startActivity(intent);
        }
             else
        {
            et_num.setError("THIS IS MENDATORY FIELD");
        }
    }
}
}