package com.example.visitas;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.security.keystore.StrongBoxUnavailableException;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AgendaActivity extends AppCompatActivity {

    private SQLiteDatabase db;
    private int groupId;
    private EditText tittleEditText, descriptionEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);

        tittleEditText = findViewById(R.id.et_tittle);
        descriptionEditText = findViewById(R.id.et_description);

        groupId = getIntent().getIntExtra("groupId", 0); //Obtenemos el ID del grupo

    }

    public void btnagendar(View view) {
        String tittle = tittleEditText.getText().toString().trim();
        String description = descriptionEditText.getText().toString().trim();

        if (TextUtils.isEmpty(tittle)) {
            Toast.makeText(this, "Por favor ingrese el titulo", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(description)) {
            Toast.makeText(this, "Por favor ingrese la descripcioón", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            db = this.openOrCreateDatabase("db", MODE_PRIVATE, null);
            agendar(tittle, description);
            db.close();
            Toast.makeText(this, "DB created", Toast.LENGTH_SHORT).show();
        } catch (
                SQLiteException e) {
            Toast.makeText(this, "ERROR " + e.getMessage(), Toast.LENGTH_LONG).show();
        }

        tittleEditText.setText("");
        descriptionEditText.setText("");
    }

    private void agendar(String tittle, String description) {
        String msg = "AGENDA SUCCESSFULLY CREATED";
        db.beginTransaction();
        try {
            //perform your database operations here ...
            db.execSQL("CREATE TABLE IF NOT EXISTS AGENDA ("
                    + " id integer PRIMARY KEY autoincrement, "
                    + " groupId integer, "
                    + " tittle text, "
                    + " description text); ");
            db.execSQL("insert into AGENDA(groupId, tittle, description) values ( '" + groupId + "', '" + tittle + "' ,'" + description + "');");
            db.setTransactionSuccessful(); //commit your changes
        } catch (SQLiteException e) {
            //report problem
            msg = "ERROR: " + e.getMessage();
        } finally {
            db.endTransaction();
            Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
        }

    }
}
