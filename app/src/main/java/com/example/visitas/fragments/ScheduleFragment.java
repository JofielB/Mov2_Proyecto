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

    ScheduleModel[] scheduleModels = {
            new ScheduleModel("Bimbo","Visita a vimbo","Moviles"),
            new ScheduleModel("Bimbo","Visita a vimbo","Moviles"),
            new ScheduleModel("Bimbo","Visita a vimbo","Moviles"),
            new ScheduleModel("Bimbo","Visita a vimbo","Moviles")

    };


    public ScheduleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        theInflatedView = inflater.inflate(R.layout.fragment_schedule, container, false);


        listView = theInflatedView.findViewById(R.id.listViewSchedule);

//        adapter = new ScheduleModel(theInflatedView.getContext(),R.layout.item_list_schedule, scheduleModels);

        // Inflate the layout for this fragment
//        listView.setAdapter(adapter);

        return theInflatedView;
    }

}
