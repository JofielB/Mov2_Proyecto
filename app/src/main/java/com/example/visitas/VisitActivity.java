package com.example.visitas;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.visitas.models.ScheduleModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VisitActivity extends AppCompatActivity {

    private SQLiteDatabase db;
    private ListView listView;
    private List<String> visitData;

    private ActionBar toolBar;

    private int visitId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visit);

        toolBar = getSupportActionBar();
        toolBar.setTitle("Visit");

        toolBar.setDisplayHomeAsUpEnabled(true); // Activamos boton atras

        //Extras
        Bundle bundle = getIntent().getExtras();
        visitId = bundle.getInt("visitId");

        try {
            db = this.openOrCreateDatabase("db", MODE_PRIVATE, null);
            // Retrieve the users from de DB
            retrieveData();

            db.close();

        } catch (SQLiteException e) {
            Toast.makeText(this, "ERROR " + e.getMessage(), Toast.LENGTH_LONG).show();
        }


        listView = findViewById(R.id.visit_data_list);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, visitData);

        // Inflate the layout for this fragment
        listView.setAdapter(adapter);
    }

    private void retrieveData() {
        visitData = new ArrayList<String>();

        String sql = "SELECT * FROM AGENDA WHERE id = '" + visitId + "'";
        Cursor c1 = db.rawQuery(sql, null);
        c1.moveToPosition(-1);
        while (c1.moveToNext()) {
            int id = c1.getInt(0);
            String groupId = c1.getString(1);
            String tittle = c1.getString(2);
            String description = c1.getString(3);
            String dateD = c1.getString(4);
            visitData.add("Empresa: " + tittle);
            visitData.add("Descripción: " + description);

            /**Cambio de formato de entrada * */
            SimpleDateFormat formatoEntrada = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); //Formato que recivimos de la API
            SimpleDateFormat formatoSalida = new SimpleDateFormat("dd MMM yyyy");  //Formato que salida

            try {
                Date date = formatoEntrada.parse(dateD); //Convertimos el String(fecha) a Date
                visitData.add("Fecha: " + formatoSalida.format(date));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
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
