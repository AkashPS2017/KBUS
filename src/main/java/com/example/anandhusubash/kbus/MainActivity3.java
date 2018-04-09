package com.example.anandhusubash.kbus;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {
    Matcheslist matches;
    RecyclerviewAdapter adapter;
    RecyclerviewAdapter1 adapter1;
    RecyclerView recyclerView;
    List<Matcheslist> list = new ArrayList<Matcheslist>();
    List<Matcheslistoffline> item=new ArrayList<>();
    DatabaseHandler db;
    String place;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        db=new DatabaseHandler(MainActivity3.this);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        place=getIntent().getStringExtra("place");

        /*SharedPreferences preferences=getSharedPreferences("offline",MODE_PRIVATE);
        if (preferences.contains("offline")){
            Toast.makeText(this, "App is working in offline mode.", Toast.LENGTH_SHORT).show();
        }else {

            final ProgressDialog progress=new ProgressDialog(MainActivity3.this);
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
                            *//*Toast.makeText(MainActivity.this, obj.getString("message"), Toast.LENGTH_SHORT).show();

                            JSONArray jsonArray = obj.getJSONArray("pdfs");*//*

                                for (int i = 0; i < obj.length(); i++) {

                                    JSONObject person = obj.getJSONObject(i);
                                    db.insertdata(person.getString("id"), person.getString("time"), person.getString("bus"), person.getString("destination"), person.getString("number"), person.getString("via"));


                                matches=new Matcheslist(person.getString("id"),person.getString("time"),person.getString("bus"),person.getString("destination"),person.getString("number"),person.getString("via"));
                                list.add(matches);

                                }
                                SharedPreferences.Editor edit = getSharedPreferences("offline", MODE_PRIVATE).edit();
                                edit.putString("offline", "true");

                                edit.apply();
                                adapter1 = new RecyclerviewAdapter1(MainActivity3.this,list,recyclerView);
                                final LinearLayoutManager manager = new LinearLayoutManager(MainActivity3.this,LinearLayoutManager.VERTICAL,false);
                                recyclerView.setLayoutManager(manager);
                                recyclerView.setAdapter(adapter1);
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

            RequestQueue request = Volley.newRequestQueue(this);
            request.add(stringRequest);

        }*/

        adapter = new RecyclerviewAdapter(MainActivity3.this, db.selectall(place),recyclerView);
        final LinearLayoutManager manager = new LinearLayoutManager(MainActivity3.this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
       /* item=db.selectall("Kottayam");*/
        adapter.notifyDataSetChanged();
        //list=


/*

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                "https://conserving-gravel.000webhostapp.com/misc/anandhu/kbusfinal.php", null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                //Intent i = new Intent(getActivity(), SearchView.class);
                String strName = response.toString();

                try {
                    JSONArray responseArray = response.getJSONArray("articles");
                    for (int i = 0; i < responseArray.length(); i++) {
                        JSONObject person = (JSONObject) responseArray.get(i);
                        //String mobile = person.getString("contact");
                        db.insertdata(person.getString("id"),person.getString("time"),person.getString("bus"),person.getString("destination"),person.getString("number"),person.getString("via"));
                        adapter.notifyDataSetChanged();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    System.out.println("errorjson=="+e.getMessage());
                }
                finally {
                }
                //i.putExtra("response", String.valueOf(response));
                        */
/*try {
                            // Parsing json object response
                            // response will be a json object

                            String result ="";

                            if(response.has("status")) {
                                result = response.getString("status");

                                String status = response.getString("status");
                                if (status.equalsIgnoreCase("sucess")){

                                }else if (status.equalsIgnoreCase("fail")){

                                }

                            }

                            //txtResponse.setText(jsonResponse);

                        } catch (JSONException e) {

                        }*//*


            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

            }

        });
        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(jsonObjReq);

*/

    }
}
