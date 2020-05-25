package com.example.visitas.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.visitas.LoginActivity;
import com.example.visitas.R;
import com.example.visitas.adapters.ProfileAdapter;
import com.example.visitas.models.ProfileModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Thread.sleep;


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

        listView = theInflatedView.findViewById(R.id.listViewProfile);

        validarUsuario();


//        adapter = new ProfileAdapter(theInflatedView.getContext(),R.layout.item_list_schedule, profile);

        // Inflate the layout for this fragment

        return theInflatedView;
    }


    private void validarUsuario() {
        //Todo: CAMBIAR EL LA URL POR LA URL DE LA API
        final String URL = "https://gist.githubusercontent.com/luisfayre/b8d7c468055b35088f5e7d7b5b306eca/raw/abe300c71d8c79c4a0074e603c1a22851e261fa8/gistfile1.txt";
        //Todo: CAMBIAR EL Request.Method.GET POR Request.Method.POST
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.wtf("onResponse", response);

                try {
                    JSONArray jsonArray = new JSONArray(response); //Guardamos la respuesta en un json array

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        int userId = jsonObject.getInt("id");
                        String userName = jsonObject.getString("nombre");
                        String userEmail = jsonObject.getString("email");

                        profile = new ArrayList<String>();

                        profile.add("Nombre: " + userName);
                        profile.add("Correo: " + userEmail);
                        profile.add("Telefono: (614) 0000-000");

                        ArrayAdapter<String> adapter = new ArrayAdapter<String>(theInflatedView.getContext(), android.R.layout.simple_list_item_1, profile);

                        listView.setAdapter(adapter);


                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), error.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(stringRequest);
    }
}

