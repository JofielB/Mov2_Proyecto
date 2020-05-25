package com.example.visitas.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.visitas.ListActivity;
import com.example.visitas.R;
import com.example.visitas.models.ScheduleModel;

import java.util.ArrayList;

public class ScheduleAdapter extends ArrayAdapter<ScheduleModel> {

    private Context context;
    ScheduleModel[] dataSet;
    int resourse;

    public ScheduleAdapter(Context context, int resource, ScheduleModel[] dataSet) {
        super(context, R.layout.item_list_schedule, dataSet);
        this.context = context;
        this.resourse = resource;
        this.dataSet = dataSet;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

//        ImageView ivGroup;
        TextView tvCompany, tvDescription;
//        Button btSchedule, btVisits;

        if (convertView == null) {

            LayoutInflater llInflator = ((Activity) context).getLayoutInflater();
            convertView = llInflator.inflate(R.layout.item_list_schedule, parent, false);
        }

        tvCompany = convertView.findViewById(R.id.textViewCompany);
//        tvDescription = convertView.findViewById(R.id.textViewDescription);

        tvCompany.setText(dataSet[position].getCompany());
//        tvDescription.setText(dataSet[position].getDescription());

        return convertView;
    }
}