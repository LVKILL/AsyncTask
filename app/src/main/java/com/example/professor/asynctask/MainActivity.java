package com.example.professor.asynctask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnIniciar;
    private TextView txtCounter;
    private ProgressBar pgbProgresso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIniciar = findViewById(R.id.btnIniciar);
        txtCounter = findViewById(R.id.txtCounter);
        pgbProgresso = findViewById(R.id.pgbProgresso);

        btnIniciar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        CounterTask counterTask = new CounterTask(btnIniciar, txtCounter, pgbProgresso);
        pgbProgresso.setMax(10);
        counterTask.execute(10);
    }
}
