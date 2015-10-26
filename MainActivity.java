package com.example.vinib_000.ex2vinilucas;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import com.squareup.okhttp.OkHttpClient;
import android.net.ConnectivityManager;
import android.widget.Toast;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;



import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    Spinner cidade;
    Spinner destino;
    private Object url;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);


        final String[] cidades = new String[]{"Sao Paulo", "Rio de Janeiro"};
        final String[] cidadesdestino = new String[]{"Porto Alegre", "Salvador"};
        ArrayAdapter<String> adapterCidade = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, cidades);
        cidade = (Spinner) findViewById(R.id.spOrigem);
        cidade.setAdapter(adapterCidade);
        ArrayAdapter<String> adapterDestino = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, cidadesdestino);
        destino = (Spinner) findViewById(R.id.spDestino);
        destino.setAdapter(adapterDestino);
        cidade.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //origem = cidades[position];

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        destino.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //destinos = cidadesdestino[position];

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void getorigemdest(View view) {
            final VoosIntegracao vs = new VoosIntegracao();
            final String origem = (String)cidade.getSelectedItem();
            final String destinosss = (String)destino.getSelectedItem();


            if(vs.isConnected(this)) {
                final Intent intent = new Intent(this,VoolstActivity.class);
                final ArrayList<String> retornmo = new ArrayList<>();
                final Bundle params = new Bundle();
                new Thread(new Runnable() {
                    @Override
                    public void run() {


                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    try {
                                        params.putStringArrayList("cidadeorigem", vs.getDestinos());
                                        intent.putExtra("valores",params);
                                        //intent.putExtra("destino",destinosss);
                                        startActivity(intent);
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                            });


                }

                }).start();
            } else {
                Toast toast = Toast.makeText(this, "Rede indisponível!", Toast.LENGTH_LONG);
                toast.show();
            }
        }



    }

