package com.example.mobileconverter;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private TextView val_1;
    private TextView val_2;
    private Spinner spinner_1;
    private Spinner spinner_2;
    private Button but;
    private TextView val_3;
    float dol = 70;
    float eur = 80;
    float fun = 100;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        val_1 = (TextView) findViewById(R.id.val_1);
        val_2 = (TextView) findViewById(R.id.val_2);

        spinner_1 = (Spinner) findViewById(R.id.spinner_1);
        spinner_2 = (Spinner) findViewById(R.id.spinner_2);

        but = (Button) findViewById(R.id.button);

        val_3 = (TextView) findViewById(R.id.textView2);

        val_1.setVisibility(View.GONE);
        val_2.setVisibility(View.GONE);
        spinner_1.setVisibility(View.GONE);
        spinner_2.setVisibility(View.GONE);
        but.setVisibility(View.GONE);

        Thread catTask = new Thread();
        catTask.execute();


        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                float x = 0, y = 0;

                String tmpS = (String) spinner_1.getSelectedItem().toString();
                String tmpS2 = (String) spinner_2.getSelectedItem().toString();

                if (null != tmpS) switch (tmpS) {
                    case "USD":
                        x = dol;
                        break;
                    case "EUR":
                        x = eur;
                        break;
                    case "GBP":
                        x = fun;
                        break;
                    default:
                        x = 1;
                        break;
                }


                if (null != tmpS2) switch (tmpS2) {
                    case "USD":
                        y = dol;
                        break;
                    case "EUR":
                        y = eur;
                        break;
                    case "GBP":
                        y = fun;
                        break;
                    default:
                        y = 1;
                        break;
                }

                if (!val_1.getText().toString().equals("")) {

                    if (tmpS != tmpS2) {

                        val_2.setText(String.valueOf(Integer.parseInt(val_1.getText().toString()) / y * x));
                    } else val_2.setText(val_1.getText());

                } else val_2.setText("0");

            }
        });

    }

    @SuppressLint("StaticFieldLeak")
    class Thread extends AsyncTask<Void, Void, Void> {


        String tmp = "";


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            val_3.setText("Загрузка...");
        }

        @Override
        protected Void doInBackground(Void... voids) {

            dol = connect("https://www.vbr.ru/banki/kurs-valut/cbrf/usd/");
            eur = connect("https://www.vbr.ru/banki/kurs-valut/cbrf/eur/");
            fun = connect("https://www.vbr.ru/banki/kurs-valut/cbrf/gbp/");

            return null;
        }


        protected float connect(String link) {

            HttpURLConnection urlConnection = null;
            URL url = null;


            try {
                url = new URL(link);
                urlConnection = (HttpURLConnection) url.openConnection();
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                tmp = readStream(in);

            } catch (MalformedURLException e) {
                e.printStackTrace();
                tmp = e.toString();
            } catch (IOException e) {
                e.printStackTrace();
                tmp = e.toString();
            } finally {
                urlConnection.disconnect();
            }


            tmp = tmp.substring(tmp.indexOf("currencies_table_def") + "currencies_table_def".length());

            float usd = 1;

            try {
                usd = Float.parseFloat(tmp.substring(81, 83) + "." + tmp.substring(84, 88));
            } catch (NumberFormatException e) {
                try {
                    usd = Float.parseFloat(tmp.substring(81, 82) + "." + tmp.substring(83, 87));
                } catch (NumberFormatException ex) {
                    usd = Float.parseFloat(tmp.substring(81, 84) + "." + tmp.substring(85, 89));
                }
            }

            return usd;

        }


        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            val_3.setText("Загрузка...");
            val_1.setVisibility(View.VISIBLE);
            val_2.setVisibility(View.VISIBLE);
            spinner_1.setVisibility(View.VISIBLE);
            spinner_2.setVisibility(View.VISIBLE);
            but.setVisibility(View.VISIBLE);
            val_3.setVisibility(View.GONE);
        }

        private String readStream(InputStream is) {
            try {
                ByteArrayOutputStream bo = new ByteArrayOutputStream();
                int i = is.read();
                while (i != -1) {
                    bo.write(i);
                    i = is.read();
                }
                return bo.toString();
            } catch (IOException e) {
                return "";
            }
        }

    }

}




