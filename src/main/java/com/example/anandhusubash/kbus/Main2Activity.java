package com.example.anandhusubash.kbus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    Spinner spin;
    ArrayAdapter<CharSequence>adapter;
    Button b;
    String place;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        b=(Button)findViewById(R.id.button);
      spin=(Spinner)findViewById(R.id.spinner);
adapter=ArrayAdapter.createFromResource(this,R.array.Destination,android.R.layout.simple_spinner_item);
adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
spin.setAdapter(adapter);
b.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent main3=new Intent(Main2Activity.this,MainActivity3.class);
        main3.putExtra("place",place);
        startActivity(main3);
    }
});
spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getBaseContext(),parent.getSelectedItem()+" is selected",Toast.LENGTH_LONG).show();
        place=parent.getSelectedItem().toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
});


    }
}
