package com.example.vinib_000.ex2vinilucas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class detalhesVooActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_voo);
        Intent intent = getIntent();
        if (intent != null) {
            //text.setText("intent diferente de nula");
            Bundle parametros = intent.getBundleExtra("valores");
            String vooselecao = parametros.getString("vooselecionado");
            TextView txtOrigemdestino = (TextView) findViewById(R.id.txtorigensdestinos);
            TextView txtAeroporto = (TextView) findViewById(R.id.txtAeroporto);
            TextView txtHorario = (TextView) findViewById(R.id.txtHorario);
            TextView txtQuantidade = (TextView) findViewById(R.id.txtQuantidade);
            ImageView ivvoo = (ImageView) findViewById(R.id.imageView);
            if(vooselecao.equals("Voo 1 - Sao Paulo - Porto Alegre")) {
              txtOrigemdestino.setText("São Paulo - Porto Alegre");
              txtAeroporto.setText("Aeroporto de Cumbica");
              txtHorario.setText("Saida as 09:00 a.m ");
              txtQuantidade.setText("40 passageiros");
                ivvoo.setImageResource(R.drawable.voogol);
           }
           else if(vooselecao.equals("Voo 2 - Sao Paulo - Porto Alegre")){
                txtOrigemdestino.setText("São Paulo - Porto Alegre");
                txtAeroporto.setText("Aeroporto de Cumbica");
                txtHorario.setText("Saida as 11:00 a.m ");
                txtQuantidade.setText("45 passageiros");
                ivvoo.setImageResource(R.drawable.vootam);

            //txtvoo.setText(var1);
        }
            else if (vooselecao.equals("Voo 1 - Sao Paulo - Salvador") ){
                txtOrigemdestino.setText("São Paulo - Salvador");
                txtAeroporto.setText("Aeroporto de Cumbica");
                txtHorario.setText("Saida as 09:00 a.m ");
                txtQuantidade.setText("40 passageiros");
                ivvoo.setImageResource(R.drawable.voogol);
           }
           else if (vooselecao.equals("Voo 2 - Sao Paulo - Salvador") ){
                txtOrigemdestino.setText("São Paulo - Salvador");
                txtAeroporto.setText("Aeroporto de Cumbica");
                txtHorario.setText("Saida as 11:00 a.m ");
                txtQuantidade.setText("40 passageiros");
                ivvoo.setImageResource(R.drawable.vootam);
           }
            else if(vooselecao.equals("Voo 1 - Rio de Janeiro - Salvador")  ) {
                txtOrigemdestino.setText("Rio de Janeiro - Salvador");
                txtAeroporto.setText("Aeroporto de Galeao");
                txtHorario.setText("Saida as 09:00 a.m ");
                txtQuantidade.setText("40 passageiros");
                ivvoo.setImageResource(R.drawable.voogol);
           }
           else if(vooselecao.equals("Voo 2 - Rio de Janeiro - Salvador")  ) {
                txtOrigemdestino.setText("Rio de Janeiro - Salvador");
                txtAeroporto.setText("Aeroporto de Galeao");
                txtHorario.setText("Saida as 11:00 a.m ");
                txtQuantidade.setText("40 passageiros");
                ivvoo.setImageResource(R.drawable.vootam);

           }
           else if(vooselecao.equals("Voo 1 - Rio de Janeiro - Porto Alegre")  ) {
                txtOrigemdestino.setText("Rio de Janeiro - Porto Alegre");
                txtAeroporto.setText("Aeroporto de Galeao");
                txtHorario.setText("Saida as 09:00 a.m ");
                txtQuantidade.setText("40 passageiros");
                ivvoo.setImageResource(R.drawable.voogol);

           }
           else if(vooselecao.equals("Voo 2 - Rio de Janeiro - Porto Alegre")  ) {
                txtOrigemdestino.setText("Rio de Janeiro - Porto Alegre");
                txtAeroporto.setText("Aeroporto de Galeao");
                txtHorario.setText("Saida as 11:00 a.m ");
                txtQuantidade.setText("40 passageiros");
                ivvoo.setImageResource(R.drawable.vootam);
           }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detalhes_voo, menu);
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
