package com.example.progressbar;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ProgressBar pasekPostepu=findViewById(R.id.progressbar2);
        pasekPostepu.setMax(10);
        TextView text=findViewById(R.id.czas);
        new CountDownTimer(10000,1000){



            @Override
            public void onTick(long czasDoKonca) {
                pasekPostepu.setProgress((int)(czasDoKonca/1000));

                String t=" "+ czasDoKonca/1000;
                int sekundy= (int) (czasDoKonca/1000);
                text.setText(t);
            }
            @Override
            public void onFinish() {
                pasekPostepu.setVisibility(View.GONE);
                TextView text=findViewById(R.id.Koniec);
                text.setText("Koniec!");
            }
        }.start();
    }
}