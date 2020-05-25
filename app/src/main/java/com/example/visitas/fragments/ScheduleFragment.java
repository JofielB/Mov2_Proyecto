package com.example.visitas.fragments;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;

import com.example.visitas.R;
import com.example.visitas.VisitActivity;
import com.example.visitas.adapters.AgendaAdapter;
import com.example.visitas.adapters.ScheduleAdapter;
import com.example.visitas.models.ScheduleModel;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */

public class ScheduleFragment extends Fragment {

    ListView listView;
    ScheduleAdapter adapter;

    View theInflatedView;

//    ScheduleModel[] schedule;
//    ScheduleModel[] schedule = {
//            new ScheduleModel(1, "Bimbo", "Visita a Bimbo", "Moviles"),
//            new ScheduleModel(2, "Bimbo 2", "Visita a Bimbo", "Moviles"),
//            new ScheduleModel(3, "Bimbo 3", "Visita a Bimbo", "Moviles"),
//            new ScheduleModel(4, "Bimbo 4", "Visita a Bimbo", "Moviles"),
//            new ScheduleModel(5, "Bimbo 5", "Visita a Bimbo", "Moviles"),
//            new ScheduleModel(6, "Bimbo 6", "Visita a Bimbo", "Moviles"),
//            new ScheduleModel(7, "Bimbo 7", "Visita a Bimbo", "Moviles"),
//            new ScheduleModel(8, "Bimbo 8", "Visita a Bimbo", "Moviles"),
//            new ScheduleModel(9, "Bimbo 9", "Visita a Bimbo", "Moviles"),
//            new ScheduleModel(10, "Bimbo 10", "Visita a Bimbo", "Moviles")
//
//
//    };

    private SQLiteDatabase db;
    private ArrayList<ScheduleModel> agenda = new ArrayList<>();

    ImageView visitImage;

    public ScheduleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        theInflatedView = inflater.inflate(R.layout.fragment_group, container, false);

        try {
            db = theInflatedView.getContext().openOrCreateDatabase("db", Context.MODE_PRIVATE, null);
            // Retrieve the users from de DB
            retrieveData();

            db.close();

        } catch (SQLiteException e) {
            Toast.makeText(getContext(), "ERROR " + e.getMessage(), Toast.LENGTH_LONG).show();
        }


        listView = theInflatedView.findViewById(R.id.listViewGroups);
//        listView.setAdapter(new ScheduleAdapter(theInflatedView.getContext(), R.layout.layout_agenda, agenda));
//
        adapter = new ScheduleAdapter(theInflatedView.getContext(), R.layout.item_list_schedule, agenda);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                visitImage = view.findViewById(R.id.imageView2);
                Intent intent = new Intent(theInflatedView.getContext(), VisitActivity.class);
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation((Activity) adapter.getContext(),
                        visitImage,
                        ViewCompat.getTransitionName(visitImage));
                startActivity(intent, options.toBundle());
            }
        });

        // Inflate the layout for this fragment
        listView.setAdapter(adapter);


        return theInflatedView;
    }

    private void retrieveData() {
        String sql = "SELECT * FROM AGENDA ORDER BY id DESC";
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
