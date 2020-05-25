package com.example.visitas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


import com.example.visitas.adapters.AgendaAdapter;
import com.example.visitas.adapters.ScheduleAdapter;
import com.example.visitas.models.ScheduleModel;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    private SQLiteDatabase db;
    private ArrayList<ScheduleModel> agenda = new ArrayList<>();
    private ListView agendaList;

    private int groupId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        //Extras
        Bundle bundle = getIntent().getExtras();
        groupId = bundle.getInt("groupId");

        try {
            db = this.openOrCreateDatabase("db", MODE_PRIVATE, null);
            // Retrieve the users from de DB
            retrieveData();

            db.close();

        } catch (SQLiteException e) {
            Toast.makeText(this, "ERROR " + e.getMessage(), Toast.LENGTH_LONG).show();
        }

        //ui
        agendaList = findViewById(R.id.agenda);
        agendaList.setAdapter(new AgendaAdapter(this, R.layout.layout_agenda, agenda));
        agendaList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), "Id: " + agenda.get(i).getId(), Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(ListOfUsers.this, Usuarios.class);
//                intent.putExtra("id", users.get(i).getId());
//                intent.putExtra("lastname", users.get(i).getLastName());
//                intent.putExtra("name", users.get(i).getName());
//                intent.putExtra("username", users.get(i).getUsername());
//                intent.putExtra("pass", users.get(i).getPassword());
//                startActivity(intent);
//                finish();
            }
        });
    }

    private void retrieveData() {
        String sql = "SELECT * FROM AGENDA WHERE groupId = '" + groupId + "'";
        Cursor c1 = db.rawQuery(sql, null);
        c1.moveToPosition(-1);
        while (c1.moveToNext()) {
            int id = c1.getInt(0);
            String groupId = c1.getString(1);
            String tittle = c1.getString(2);
            String description = c1.getString(3);

            agenda.add(new ScheduleModel(id, tittle, description));
        }
    }
}
