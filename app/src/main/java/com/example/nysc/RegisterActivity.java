package com.example.nysc;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    TextView login;
    EditText name, userEmail, phone, nysc, course, school, lga, state, address,  password;
    AppCompatButton submit;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        login = findViewById(R.id.login);
        name = findViewById(R.id.name);
        userEmail = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        nysc = findViewById(R.id.nysc_id);
        course = findViewById(R.id.course);
        school = findViewById(R.id.school);
        address = findViewById(R.id.address);
        lga = findViewById(R.id.lga);
        state = findViewById(R.id.state);
        password = findViewById(R.id.password);
        submit = (AppCompatButton) findViewById(R.id.register);
        progressDialog = new ProgressDialog(this);

        login.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        });


        submit.setOnClickListener(view -> {
            createUser();
        });
    }

    private void createUser(){
        String mail = userEmail.getText().toString().trim();
        String fname = name.getText().toString();
        String mobile = phone.getText().toString().trim();
        String study = course.getText().toString().trim();
        String inst = school.getText().toString().trim();
        String local = lga.getText().toString().trim();
        String id = nysc.getText().toString().trim();
        String region = state.getText().toString().trim();
        String home = address.getText().toString().trim();
        String pass = password.getText().toString().trim();

        progressDialog.setMessage("Registration in progress ...");
        progressDialog.show();

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Constants.Url_Register,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            if(!jsonObject.getBoolean("error")){
                                SharedPrefManager.getInstance(getApplicationContext())
                                        .userLogin(mail);
                                Toast.makeText(getApplicationContext(), "Logining in"+mail, Toast.LENGTH_SHORT);
                                startActivity(new Intent(RegisterActivity.this, HomeActivity.class));

                            }else {
                                Toast.makeText(getApplicationContext(), jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                            }
                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.hide();
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("name", fname);
                params.put("email", mail);
                params.put("phone", mobile);
                params.put("course", study);
                params.put("school", inst);
                params.put("lga", local);
                params.put("nysc_id", id);
                params.put("state", region);
                params.put("address",home);
                params.put("password", pass);
                return params;
            }
        };
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);

        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }
}