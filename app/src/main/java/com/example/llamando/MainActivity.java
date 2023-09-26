package com.example.llamando;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button google, alarma, llamar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        google = findViewById(R.id.Google);
        alarma = findViewById(R.id.Alarma);
        llamar = findViewById(R.id.Llamar);

        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 Intent goToGoogle = new Intent(Intent.ACTION_VIEW);
                 goToGoogle.setData(Uri.parse("http:/www.google.com"));
                 startActivity(goToGoogle);
            }
        });

        alarma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent alarma = new Intent(AlarmClock.ACTION_SET_ALARM);
                alarma.putExtra(AlarmClock.EXTRA_MESSAGE, "Gimnasio");
                alarma.putExtra(AlarmClock.EXTRA_HOUR, 10);
                alarma.putExtra(AlarmClock.EXTRA_MINUTES, 30);

                if (alarma.resolveActivity(getPackageManager())!=null) {
                    startActivity(alarma);
                }
            }
        });


        llamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNumber;
                Intent llamando = new Intent(Intent.ACTION_DIAL);
                llamando.setData(Uri.parse("tel:"+ "2125551212"));
                if (llamando.resolveActivity(getPackageManager())!=null) {
                    startActivity(llamando);
                }

            }
        });
    }
}