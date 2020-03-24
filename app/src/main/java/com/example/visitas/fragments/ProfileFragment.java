package com.example.visitas.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.visitas.R;
import com.example.visitas.adapters.ProfileAdapter;
import com.example.visitas.models.ProfileModel;

import java.util.ArrayList;
import java.util.List;


public class ProfileFragment extends Fragment {

    ListView listView;
    List<String> profile;
    View theInflatedView;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        theInflatedView = inflater.inflate(R.layout.fragment_profile, container, false);

        profile =  new ArrayList<String>();
        profile.add("Nombre: Juan Perez");
        profile.add("Correo: juanperez@tecii.com");
        profile.add("Telefono: (614) 0000-000");

        listView = theInflatedView.findViewById(R.id.listViewProfile);

//        adapter = new ProfileAdapter(theInflatedView.getContext(),R.layout.item_list_schedule, profile);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(theInflatedView.getContext(),android.R.layout.simple_list_item_1, profile);

        // Inflate the layout for this fragment
        listView.setAdapter(adapter);

        return theInflatedView;
    }

}

/**
 * Fragmento con modelos
 * A simple {@link Fragment} subclass.
 */
//public class ProfileFragment extends Fragment {
//
//    ListView listView;
//    ProfileAdapter adapter;
//
//    View theInflatedView;
//
//    ProfileModel[] profile = {
//            new ProfileModel("Profesor","proferos@gmail.com","Moviles"),
//    };
//
//
//    public ProfileFragment() {
//        // Required empty public constructor
//    }
//
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        theInflatedView = inflater.inflate(R.layout.fragment_profile, container, false);
//
//
//        listView = theInflatedView.findViewById(R.id.listViewProfile);
//
//        adapter = new ProfileAdapter(theInflatedView.getContext(),R.layout.item_list_schedule, profile);
//
//        // Inflate the layout for this fragment
//        listView.setAdapter(adapter);
//
//        return theInflatedView;
//    }
//
//}
