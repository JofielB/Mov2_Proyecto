package com.example.visitas.fragments;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;

import com.example.visitas.R;
import com.example.visitas.VisitActivity;
import com.example.visitas.adapters.ScheduleAdapter;
import com.example.visitas.models.ScheduleModel;


/**
 * A simple {@link Fragment} subclass.
 */

public class ScheduleFragment extends Fragment {

    ListView listView;
    ScheduleAdapter adapter;

    View theInflatedView;

    ScheduleModel[] schedule = {
            new ScheduleModel(1, "Bimbo", "Visita a Bimbo", "Moviles"),
            new ScheduleModel(2, "Bimbo 2", "Visita a Bimbo", "Moviles"),
            new ScheduleModel(3, "Bimbo 3", "Visita a Bimbo", "Moviles"),
            new ScheduleModel(4, "Bimbo 4", "Visita a Bimbo", "Moviles"),
            new ScheduleModel(5, "Bimbo 5", "Visita a Bimbo", "Moviles"),
            new ScheduleModel(6, "Bimbo 6", "Visita a Bimbo", "Moviles"),
            new ScheduleModel(7, "Bimbo 7", "Visita a Bimbo", "Moviles"),
            new ScheduleModel(8, "Bimbo 8", "Visita a Bimbo", "Moviles"),
            new ScheduleModel(9, "Bimbo 9", "Visita a Bimbo", "Moviles"),
            new ScheduleModel(10, "Bimbo 10", "Visita a Bimbo", "Moviles")


    };

    ImageView visitImage;

    public ScheduleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        theInflatedView = inflater.inflate(R.layout.fragment_group, container, false);


        listView = theInflatedView.findViewById(R.id.listViewGroups);

        adapter = new ScheduleAdapter(theInflatedView.getContext(), R.layout.item_list_schedule, schedule);

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

}
