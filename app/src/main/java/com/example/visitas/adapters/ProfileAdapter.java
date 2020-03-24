package com.example.visitas.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.visitas.R;
import com.example.visitas.models.ProfileModel;

public class ProfileAdapter extends ArrayAdapter<ProfileModel> {

    private Context context;
    ProfileModel[] dataSet;
    int resourse;

    public ProfileAdapter(Context context, int resource, ProfileModel[] dataSet) {
        super(context, R.layout.item_list_schedule, dataSet);
        this.context = context;
        this.resourse = resource;
        this.dataSet = dataSet;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

//        ImageView ivGroup;
        TextView name, tvDescription;
//        Button btSchedule, btVisits;

        if (convertView == null) {

            LayoutInflater llInflator = ((Activity) context).getLayoutInflater();
            convertView = llInflator.inflate(R.layout.item_list_schedule, parent, false);
        }

        name = convertView.findViewById(R.id.textViewCompany);
//        tvDescription = convertView.findViewById(R.id.textViewDescription);

        name.setText(dataSet[position].getName());
//        tvDescription.setText(dataSet[position].getDescription());

        return convertView;
    }
}