package com.example.anandhusubash.kbus;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    DatabaseHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int SPLASH_DISPLAY_LENGTH = 4000;
        db=new DatabaseHandler(this);

        SharedPreferences preferences=getSharedPreferences("offline",MODE_PRIVATE);
        if (preferences.contains("offline")){
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent one=new Intent(MainActivity.this,Main2Activity.class);
                    startActivity(one);
                    finish();

                }
            }, SPLASH_DISPLAY_LENGTH);

        }else {
            final ProgressDialog progress=new ProgressDialog(MainActivity.this);
            progress.setMessage("Loading databases for first time");
            progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progress.setCancelable(false);
            progress.show();
            StringRequest stringRequest = new StringRequest(Request.Method.GET, "https://conserving-gravel.000webhostapp.com/misc/anandhu/kbusfinal.php",

                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {


                            try {
                                JSONArray obj = new JSONArray(response);
                            /*Toast.makeText(MainActivity.this, obj.getString("message"), Toast.LENGTH_SHORT).show();

                            JSONArray jsonArray = obj.getJSONArray("pdfs");*/

                                for (int i = 0; i < obj.length(); i++) {

                                    JSONObject person = obj.getJSONObject(i);
                                    db.insertdata(person.getString("id"), person.getString("time"), person.getString("bus"), person.getString("destination"), person.getString("number"), person.getString("via"));


                                }
                                SharedPreferences.Editor edit = getSharedPreferences("offline", MODE_PRIVATE).edit();
                                edit.putString("offline", "true");

                                edit.apply();

                                progress.dismiss();

                            } catch (JSONException e) {
                                progress.dismiss();
                                e.printStackTrace();
                            }


                        }
                    },

                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                             progress.dismiss();

                        }
                    }


            );

            RequestQueue request = Volley.newRequestQueue(MainActivity.this);
            request.add(stringRequest);
            Intent one=new Intent(MainActivity.this,Main2Activity.class);
            startActivity(one);
            finish();
        }



    }
}
