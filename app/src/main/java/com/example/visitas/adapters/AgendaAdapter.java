package com.example.visitas.adapters;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.visitas.R;
import com.example.visitas.models.ScheduleModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
        TextView txtTittle, txtDescription, txtDate;


        if (convertView == null) {
            LayoutInflater layoutInflater = ((Activity) context).getLayoutInflater();
            convertView = layoutInflater.inflate(resource, parent, false);
        }

        txtTittle = convertView.findViewById(R.id.tittle);
        txtDescription = convertView.findViewById(R.id.description);
        txtDate = convertView.findViewById(R.id.date);

        txtTittle.setText("" + agenda.get(position).getCompany());
        txtDescription.setText("" + agenda.get(position).getDescription());

        String fecha = "" + agenda.get(position).getDate();

        /**Cambio de formato de entrada * */
        SimpleDateFormat formatoEntrada = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); //Formato que recivimos de la API
        SimpleDateFormat formatoSalida = new SimpleDateFormat("dd MMM yyyy");  //Formato que salida

        try {
            Date date = formatoEntrada.parse(fecha); //Convertimos el String(fecha) a Date
//            Log.wtf("date", formatoSalida.format(date));
            txtDate.setText("" + formatoSalida.format(date)); //Cambiamos el formato de Date(date) a el formatato salida
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return convertView;
    }
}