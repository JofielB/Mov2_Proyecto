package com.example.visitas.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.visitas.ListActivity;
import com.example.visitas.R;
import com.example.visitas.VisitActivity;
import com.example.visitas.models.ScheduleModel;

import java.util.ArrayList;

public class ScheduleAdapter extends ArrayAdapter<ScheduleModel> {

    private Context context;
    int resourse;

    private ArrayList<ScheduleModel> agenda;

    public ScheduleAdapter(Context context, int resource, ArrayList<ScheduleModel> objects) {
        super(context, R.layout.item_list_schedule, objects);
        this.context = context;
        this.resourse = resource;
        agenda = objects;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

//        ImageView ivGroup;
        TextView tvCompany, tvDescription;
//        Button btSchedule, btVisits;

        if (convertView == null) {

            LayoutInflater llInflator = ((Activity) context).getLayoutInflater();
            convertView = llInflator.inflate(R.layout.item_list_schedule, parent, false);
        }

        tvCompany = convertView.findViewById(R.id.textViewCompany);
        tvDescription = convertView.findViewById(R.id.textViewDescription);

        tvCompany.setText(agenda.get(position).getCompany());
        tvDescription.setText(agenda.get(position).getDescription());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(context, "visitId" + agenda.get(position).getId(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getContext(), VisitActivity.class);
                intent.putExtra("visitId", agenda.get(position).getId());
                context.startActivity(intent);
            }
        });

        return convertView;
    }
}