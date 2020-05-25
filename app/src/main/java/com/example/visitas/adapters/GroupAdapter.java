package com.example.visitas.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.example.visitas.AgendaActivity;
import com.example.visitas.ListActivity;
import com.example.visitas.R;
import com.example.visitas.models.GroupModel;

import java.util.ArrayList;
import java.util.List;

public class GroupAdapter extends ArrayAdapter<GroupModel> {

    private Context context;
    GroupModel[] dataSet;
    int resourse;
    private List<GroupModel> groups;

    public GroupAdapter(Context context, int item_card_group, ArrayList<GroupModel> groups) {
        super(context, R.layout.item_card_group, groups);
        this.context = context;
        this.resourse = item_card_group;
        this.groups = groups;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final GroupModel group = groups.get(position);
//        ImageView ivGroup;
        TextView tvTittle, tvSchedule;
        Button btSchedule, btVisits;

        if (convertView == null) {
            LayoutInflater llInflator = ((Activity) context).getLayoutInflater();
            convertView = llInflator.inflate(R.layout.item_card_group, parent, false);
        }

//        ivGroup = convertView.findViewById(R.id.ivGroup);
        tvTittle = convertView.findViewById(R.id.tvTittle);
        tvSchedule = convertView.findViewById(R.id.tvSchedule);
        btSchedule = convertView.findViewById(R.id.btSchedule);
        btVisits = convertView.findViewById(R.id.btVisits);

//        ivGroup.setText(dataSet.get(position).getImage());
        tvTittle.setText(group.getGroup());
        tvSchedule.setText(group.getSchedule());

        btSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Button Pulsado: " + group.getId(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context.getApplicationContext(), AgendaActivity.class);
                intent.putExtra("groupId", group.getId());
                context.startActivity(intent);
            }
        });

        btVisits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Button Pulsado: " + group.getId(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context.getApplicationContext(), ListActivity.class);
                intent.putExtra("groupId", group.getId());
                context.startActivity(intent);
            }
        });

        return convertView;
    }


}