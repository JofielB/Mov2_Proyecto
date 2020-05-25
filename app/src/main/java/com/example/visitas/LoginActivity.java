package com.example.visitas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Thread.sleep;

public class LoginActivity extends AppCompatActivity {

    //UI
    private EditText emailEditText;
    private EditText contrasenaEditText;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //UI
        emailEditText = findViewById(R.id.login_correo);
        contrasenaEditText = findViewById(R.id.login_contrasena);

        progressDialog = new ProgressDialog(this);
    }

    public void login(View view) {
        String email = emailEditText.getText().toString().trim();
        String password = contrasenaEditText.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Por favor ingrese su correo electrónico", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Por favor ingrese su contraseña", Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.setMessage("Iniciando sesión");
        progressDialog.show();
        validarUsuario(email, password); //Enviamos los datos
    }


    private void validarUsuario(final String email, final String password) {
        //Todo: CAMBIAR EL LA URL POR LA URL DE LA API
        final String URL = "https://gist.githubusercontent.com/luisfayre/b8d7c468055b35088f5e7d7b5b306eca/raw/abe300c71d8c79c4a0074e603c1a22851e261fa8/gistfile1.txt";
        //Todo: CAMBIAR EL Request.Method.GET POR Request.Method.POST
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.wtf("onResponse", response);

                if (!response.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Inicio de sesión correcto", Toast.LENGTH_SHORT).show();
                    try {
                        sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    progressDialog.dismiss(); //Ocultamos el progressDialog

                    try {
                        JSONArray jsonArray = new JSONArray(response); //Guardamos la respuesta en un json array

                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);

                            int userId = jsonObject.getInt("id");
                            String userName = jsonObject.getString("nombre");
                            String userEmail = jsonObject.getString("email");

                            principalScreen(userId, userName, userEmail);
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } else {
                    Toast.makeText(LoginActivity.this, "Usuario y contraseña incorrectos", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parametros = new HashMap<String, String>();
                parametros.put("nombre", email);
                parametros.put("contrasena", password);
                return parametros;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    /**
     * Función para abrir la pantalla principal y enviar parámetros de búsqueda del los datos del usuario
     *
     * @param userId    Id del usuario que inicia sesión
     * @param userName  nombre del usuario que se inicia sesión
     * @param userEmail correo del usuario que se inicia sesión
     */
    public void principalScreen(int userId, String userName, String userEmail) {
        Intent intent = new Intent(this, NavigationActivity.class);
        intent.putExtra("userId", userId);
        intent.putExtra("userName", userName);
        intent.putExtra("userEmail", userEmail);
        startActivity(intent);
    }

    //Funcion para mostrar el mensaje
    public void olvideConrasena(View view) {
        Toast.makeText(LoginActivity.this, "Contacte a su administrador para actualizar la contraseña", Toast.LENGTH_SHORT).show();
    }

}
