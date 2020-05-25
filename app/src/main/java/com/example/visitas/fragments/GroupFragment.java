package com.example.visitas.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.visitas.R;
import com.example.visitas.adapters.GroupAdapter;
import com.example.visitas.models.GroupModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */

public class GroupFragment extends Fragment {

    ListView listView;
    GroupAdapter adapter;

    View theInflatedView;

    private RequestQueue queue;

    ArrayList<GroupModel> groups;

    public GroupFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        theInflatedView = inflater.inflate(R.layout.fragment_group, container, false);


        listView = theInflatedView.findViewById(R.id.listViewGroups);

        groups = new ArrayList<>();

        obterDatos();

        return theInflatedView;

    }

    public void obterDatos() {
        queue = Volley.newRequestQueue(getActivity().getApplicationContext());

        final String url = "https://gist.githubusercontent.com/luisfayre/fc44c5285b272553c565aecb615a9e5b/raw/3049b5e84002699a2082deb05d7a0dce22a1f9e1/test.json";

        // prepare the Request
        JsonArrayRequest getRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        //Log.wtf("Response", "" + response);

                        try {
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject groupJ = response.getJSONObject(i);
                                groups.add(new GroupModel(
                                        groupJ.getInt("id"),
                                        groupJ.getString("group"),
                                        groupJ.getString("schedule"),
                                        groupJ.getString("image")
                                ));
                            }

                            adapter = new GroupAdapter(theInflatedView.getContext(),R.layout.item_card_group, groups); //creating adapter object and setting it to recyclerview
                            listView.setAdapter(adapter); // Inflate the layout for this fragment
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.wtf("Error.Response", String.valueOf(error));
                    }
                }
        );

        // add it to the RequestQueue
        queue.add(getRequest);
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
