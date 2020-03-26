package com.example.visitas.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.visitas.R;
import com.example.visitas.models.GroupModel;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class GroupAdapter extends ArrayAdapter<GroupModel> {

    private Context context;
    GroupModel[] dataSet;
    int resourse;

    public GroupAdapter(Context context,  int resource, GroupModel[] dataSet) {
        super(context, R.layout.item_card_group, dataSet);
        this.context = context;
        this.resourse = resource;
        this.dataSet = dataSet;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

//        ImageView ivGroup;
        TextView tvTittle, tvSchedule;
//        Button btSchedule, btVisits;

        if (convertView == null) {
            LayoutInflater llInflator = ((Activity) context).getLayoutInflater();
            convertView = llInflator.inflate(R.layout.item_card_group, parent, false);
        }

//        ivGroup = convertView.findViewById(R.id.ivGroup);
        tvTittle = convertView.findViewById(R.id.tvTittle);
        tvSchedule = convertView.findViewById(R.id.tvSchedule);
//        btSchedule = convertView.findViewById(R.id.btSchedule);
//        btVisits = convertView.findViewById(R.id.btVisits);

//        ivGroup.setText(dataSet.get(position).getImage());
        tvTittle.setText(dataSet[position].getGroup());
        tvSchedule.setText(dataSet[position].getSchedule());

        return convertView;
    }
}