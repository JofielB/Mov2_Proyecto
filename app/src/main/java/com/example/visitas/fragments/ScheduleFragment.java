package com.example.visitas.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.visitas.R;
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
            new ScheduleModel("Bimbo","Visita a Bimbo","Moviles"),
            new ScheduleModel("Bimbo 2","Visita a Bimbo","Moviles"),
            new ScheduleModel("Bimbo 3","Visita a Bimbo","Moviles"),
            new ScheduleModel("Bimbo 4","Visita a Bimbo","Moviles"),
            new ScheduleModel("Bimbo 5","Visita a Bimbo","Moviles"),
            new ScheduleModel("Bimbo 6","Visita a Bimbo","Moviles"),
            new ScheduleModel("Bimbo 7","Visita a Bimbo","Moviles"),
            new ScheduleModel("Bimbo 8","Visita a Bimbo","Moviles"),
            new ScheduleModel("Bimbo 9","Visita a Bimbo","Moviles"),
            new ScheduleModel("Bimbo 10","Visita a Bimbo","Moviles")



    };


    public ScheduleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        theInflatedView = inflater.inflate(R.layout.fragment_group, container, false);


        listView = theInflatedView.findViewById(R.id.listViewGroups);

        adapter = new ScheduleAdapter(theInflatedView.getContext(),R.layout.item_list_schedule, schedule);

        // Inflate the layout for this fragment
        listView.setAdapter(adapter);

        return theInflatedView;
    }

}
