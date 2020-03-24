package com.example.visitas.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.visitas.R;
import com.example.visitas.adapters.GroupAdapter;
import com.example.visitas.models.GroupModel;


/**
 * A simple {@link Fragment} subclass.
 */

public class GroupFragment extends Fragment {

    ListView listView;
    GroupAdapter adapter;

    View theInflatedView;

    GroupModel[] group = {
            new GroupModel("Moviles I","15:00 16:00","Moviles"),
            new GroupModel("Moviles II","14:00 15:000","Moviles"),
            new GroupModel("Moviles III","13:00 14:000","Moviles"),
            new GroupModel("Base de Datos","12:00 13:000","Moviles")

    };


    public GroupFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        theInflatedView = inflater.inflate(R.layout.fragment_group, container, false);


        listView = theInflatedView.findViewById(R.id.listViewGroups);

        adapter = new GroupAdapter(theInflatedView.getContext(),R.layout.item_card_group, group);

        // Inflate the layout for this fragment
        listView.setAdapter(adapter);

        return theInflatedView;
    }

}


//public class GroupFragment extends Fragment{
//
//    ListView listView;
//    String[] sGropus = {"jose", "Sofia", "Sofia", "Sofia", "Sofia", "Sofia", "Sofia", "Sofia"};
//    String[] sGropu2s = {"jose", "Sofia"};
//    public GroupFragment() {
//        // Required empty public constructor
//    }
//
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_group, container, false);
//    }
//
//    @Override
//    public void onActivityCreated(Bundle state) {
//        super.onActivityCreated(state);
//        listView = (ListView)getView().findViewById(R.id.listViewGroups);
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(), android.R.layout.simple_expandable_list_item_1,sGropus);
//        listView.setAdapter(adapter);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(getActivity().getApplicationContext(),String.valueOf(position),Toast.LENGTH_SHORT).show();
//
//            }
//        });
//    }
//}
