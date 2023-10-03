package com.example.llamando;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button google, alarma, llamar, calendario, temporizador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        google = findViewById(R.id.Google);
        alarma = findViewById(R.id.Alarma);
        llamar = findViewById(R.id.Llamar);
        calendario = findViewById(R.id.calendario);
        temporizador = findViewById(R.id.temporizador);

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
        calendario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addEvent("Estudiar", "Medellin", 10, 11);
            }
            public void addEvent(String title, String location, long begin, long end) {
                Intent intent = new Intent(Intent.ACTION_INSERT)
                        .setData(CalendarContract.Events.CONTENT_URI)
                        .putExtra(CalendarContract.Events.TITLE, title)
                        .putExtra(CalendarContract.Events.EVENT_LOCATION, location)
                        .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, begin)
                        .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, end);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }

        });

        temporizador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startTimer("Ejercicio", 20);
            }

            public void startTimer(String message, int seconds) {
                Intent intent = new Intent(AlarmClock.ACTION_SET_TIMER)
                        .putExtra(AlarmClock.EXTRA_MESSAGE, message)
                        .putExtra(AlarmClock.EXTRA_LENGTH, seconds)
                        .putExtra(AlarmClock.EXTRA_SKIP_UI, true);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }

        });

    }
}