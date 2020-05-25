package com.example.visitas.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;

import com.example.visitas.R;
import com.example.visitas.models.ScheduleModel;

import java.util.ArrayList;

public class AgendaAdapter extends ArrayAdapter<ScheduleModel> {

    private Context context;
    private int resource;

    private ArrayList<ScheduleModel> agenda;

    public AgendaAdapter(@NonNull Context context, int resource, @NonNull ArrayList<ScheduleModel> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        agenda = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        TextView txtLastName, txtName, txtUsername;

        if (convertView == null) {
            LayoutInflater layoutInflater = ((Activity) context).getLayoutInflater();
            convertView = layoutInflater.inflate(resource, parent, false);
        }

        txtLastName = convertView.findViewById(R.id.userLastNameList);
        txtName = convertView.findViewById(R.id.userNameList);
        txtUsername = convertView.findViewById(R.id.usernameList);

        txtName.setText("" + agenda.get(position).getCompany());
        txtUsername.setText("" + agenda.get(position).getDescription());



        return convertView;
    }
}