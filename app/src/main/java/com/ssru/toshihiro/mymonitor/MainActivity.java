package com.ssru.toshihiro.mymonitor;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindWidGet();

        SynJson synJson = new SynJson();
        synJson.execute();

    }

    private void bindWidGet() {
        listView = (ListView) findViewById(R.id.listView);
    }

    private class SynJson extends AsyncTask<Void, Void, String> {


        @Override
        protected String doInBackground(Void... voids) {

            try {
                String strURL = "http://csclub.ssru.ac.th/s56122201044/csc4202/monitor/php_get_monitor.php";
                OkHttpClient okHttpClient = new OkHttpClient();
                Request.Builder builder = new Request.Builder();
                Request request = builder.url(strURL).build();
                Response response = okHttpClient.newCall(request).execute();
                Log.d("Doin ==> ", "Sucress");
                return response.body().string();

            } catch (Exception e) {
                Log.d("AsyncTask ==> ", e.toString());
            }

            return null;
        }// doInBack

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                Log.d("01/12/59 ==> ", "SucessOnPost"+ s);
                final JSONArray jsonArray = new JSONArray(s);

                final String[] iconString = new String[jsonArray.length()];
                final String[] titleString = new String[jsonArray.length()];
                final String[] priceString = new String[jsonArray.length()];
                final String[] brandString = new String[jsonArray.length()];
                final String[] sizeStrings = new String[jsonArray.length()];
                final String[] curveStrings = new String[jsonArray.length()];
                final String[] typeStrings = new String[jsonArray.length()];
                final String[] detailStrings = new String[jsonArray.length()];


                for (int i = 0 ; i < jsonArray.length() ; i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    iconString[i] = jsonObject.getString("image");
                    titleString[i] = jsonObject.getString("product_name");
                    priceString[i] = jsonObject.getString("price");
                    brandString[i] = jsonObject.getString("brand_name");
                    sizeStrings[i] = jsonObject.getString("size");
                    curveStrings[i] = jsonObject.getString("curve");
                    typeStrings[i] = jsonObject.getString("type_name");
                    detailStrings[i] = jsonObject.getString("product_detail");

                }
                MyAdapter myAdapter = new MyAdapter(MainActivity.this, titleString, priceString, iconString);
                listView.setAdapter(myAdapter);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent intent = new Intent(MainActivity.this, MonitorDetail.class);
                        intent.putExtra("img", iconString[i]);
                        intent.putExtra("title", titleString[i]);
                        intent.putExtra("price", priceString[i]);
                        intent.putExtra("brand", brandString[i]);
                        intent.putExtra("size", sizeStrings[i]);
                        intent.putExtra("curve", curveStrings[i]);
                        intent.putExtra("type", typeStrings[i]);
                        intent.putExtra("detail", detailStrings[i]);
                        startActivity(intent);

                    }
                });

            } catch (Exception e) {
                Log.d("01/12/59 ==> ", e.toString());

            }


        }
    }//SynJSon
}//Main
