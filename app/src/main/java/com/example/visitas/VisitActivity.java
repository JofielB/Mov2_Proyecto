package com.example.visitas;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class VisitActivity extends AppCompatActivity {
    ListView listView;
    List<String> visitData;

    private ActionBar toolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visit);

        toolBar = getSupportActionBar();
        toolBar.setTitle("Visit");

        toolBar.setDisplayHomeAsUpEnabled(true); // Activamos boton atras

        visitData = new ArrayList<String>();
        visitData.add("Empresa: Bimbo");
        visitData.add("Profesor: Pepe");
        visitData.add("Grupo: ADSE");
        visitData.add("Fecha: 24/09/2020");
        visitData.add("Hora: 10:00am");


        listView = findViewById(R.id.visit_data_list);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, visitData);

        // Inflate the layout for this fragment
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
