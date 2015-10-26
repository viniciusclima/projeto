package com.example.vinib_000.ex2vinilucas;

import android.content.Context;
import android.net.ConnectivityManager;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by vinib_000 on 22/10/2015.
 */
public class VoosIntegracao {

    OkHttpClient client = new OkHttpClient();

    public ArrayList<String> getDestinos()throws IOException {
        ArrayList<String>destinoss = new ArrayList<>();
        try {
        String url = "http://localhost:8180/projeto_aeronave/VoosJson";
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = client.newCall(request).execute();
        String jsonStr = response.body().string();

            JSONArray root = new JSONArray(jsonStr);
            JSONObject item = null;
            for (int i = 0; i < root.length(); i++) {
                item = (JSONObject) root.get(i);
                destinoss.add(item.getString("destino"));



            }
        } catch (JSONException je) {
          je.printStackTrace();
        }
        return destinoss;
    }


    public boolean isConnected(Context context) {
        ConnectivityManager connectivityManager =
                (ConnectivityManager) context
                        .getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo() != null
                && connectivityManager.getActiveNetworkInfo().isConnected();
    }


}
