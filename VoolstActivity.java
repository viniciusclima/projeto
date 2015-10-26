package com.example.vinib_000.ex2vinilucas;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.ListView;

import java.util.ArrayList;

public class VoolstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voolst);
        Intent intent = getIntent();
        if (intent != null) {
            //text.setText("intent diferente de nula");
            ArrayList<String> var1 = new ArrayList<String>();
            Bundle parametros = intent.getBundleExtra("valores");
             var1 = intent.getStringArrayListExtra("cidadeorigem");
            //text.setText(var1);
            if (parametros != null) {
                //text.setText("Parametros diferentes de nulo");
                String origem = parametros.getString("cidadeorigem");
                String destino = parametros.getString("cidadedestino");
                String[] voo = new String[2];
                if (origem.equals("Sao Paulo") && destino.equals("Porto Alegre")) {
                    voo[0] = "Voo 1 - Sao Paulo - Porto Alegre";
                    voo[1] = "Voo 2 - Sao Paulo - Porto Alegre";
                    // text.setText("Entrei no if 1");

                } else if (origem.equals("Sao Paulo") && destino.equals("Salvador")) {
                    voo[0] = "Voo 1 - Sao Paulo - Salvador";
                    voo[1] = "Voo 2 - Sao Paulo - Salvador";


                } else if (origem.equals("Rio de Janeiro") && destino.equals("Salvador")) {
                    voo[0] = "Voo 1 - Rio de Janeiro - Salvador";
                    voo[1] = "Voo 2 - Rio de Janeiro - Salvador";


                } else if (origem.equals("Rio de Janeiro") && destino.equals("Porto Alegre")) {
                    voo[0] = "Voo 1 - Rio de Janeiro - Porto Alegre";
                    voo[1] = "Voo 2 - Rio de Janeiro - Porto Alegre";


                }
                ArrayAdapter<String> adapterCidade = new ArrayAdapter(this, android.R.layout.simple_list_item_1, var1);
                ListView voos;
                voos = (ListView) findViewById(R.id.listView);
                voos.setAdapter(adapterCidade);
                voos.setOnItemClickListener(chamaVoo(this,voo));

            }

        }


    }

    public AdapterView.OnItemClickListener chamaVoo(final Context context, final String[] vooss) {
    return( new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
         String vooselecionado = "";
            if(position == 0 ) {
             vooselecionado = vooss[0].toString();
            }
            else if ( position == 1) {
            vooselecionado = vooss[1].toString();
            }
            Bundle params = new Bundle();
            Intent intent = new Intent(context,detalhesVooActivity.class);
            params.putString("vooselecionado",vooselecionado);
            intent.putExtra("valores",params);
            //intent.putExtra("destino",destinosss);
            startActivity(intent);
        }
    });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_voolst, menu);
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
}
