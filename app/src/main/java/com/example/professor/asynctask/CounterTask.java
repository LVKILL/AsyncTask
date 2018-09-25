package com.example.professor.asynctask;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class CounterTask extends AsyncTask<Integer, Integer, Void> {

    private Button btnIniciar;
    private TextView txtCounter;
    private ProgressBar pgbProgresso;

    public CounterTask(Button btnIniciar, TextView txtCounter, ProgressBar pgbProgresso) {
        this.btnIniciar = btnIniciar;
        this.txtCounter = txtCounter;
        this.pgbProgresso = pgbProgresso;
    }

    @Override
    protected void onPreExecute() {
        btnIniciar.setEnabled(false);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        btnIniciar.setEnabled(true);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        int c = values[0];
        txtCounter.setText(String.valueOf(c));
        pgbProgresso.setProgress(c);
    }

    @Override
    protected Void doInBackground(Integer... integers) {
        int max = integers[0];

        for(int i = 0; i <= max; i++){
            SystemClock.sleep(500);
            publishProgress(i);
        }
        return null;
    }
}
