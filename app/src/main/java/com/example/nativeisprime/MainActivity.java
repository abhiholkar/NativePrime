/*
 * Created by Abhinav Holkar 18/03/19 22:53.
 * Copyright (c) 2019.
 */

package com.example.nativeisprime;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editText = findViewById(R.id.edit_field);
        final TextView isPrimeResult = findViewById(R.id.prime_result);
        final Button isPrimeCheck = findViewById(R.id.isprime);
        isPrimeCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(editText.getText().toString())) {
                    Toast.makeText(MainActivity.this, R.string.info_text, Toast.LENGTH_SHORT).show();

                } else {
                    int num = Integer.valueOf(Integer.parseInt(editText.getText().toString()));
                    isPrimeResult.setText(String.format(getString(R.string.result), String.valueOf(isPrime(num))));
                }

            }
        });


    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    //public native String stringFromJNI();

    public native boolean isPrime(int num);
}
