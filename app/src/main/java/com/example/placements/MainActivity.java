package com.example.placements;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

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

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String[] companyList = new String[10];
    RecyclerView recyler;
    Company company;
    ArrayList<Company> companies = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        companyList[0] = "Infosys";
        companyList[1] =("JP Morgan Chase & Co. ");
        companyList[2] = ("Wipro");
        companyList[3] = "TCS";
        companyList[4] = "Deloitte";

        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        String url ="https://60a37c2c7c6e8b0017e270eb.mockapi.io/placements/api/company";
        System.out.println("URL HIT::::" + url);

        //Request a string response from the provided URL.
        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                    System.out.println(response);
                        try {
                            JSONArray companyObjectArray = new JSONArray(response);
                            for(int i=0; i< companyObjectArray.length(); i++){
                                JSONObject jo = companyObjectArray.getJSONObject(i);
                                Company c = new Company();
                                c.company_id = jo.getInt("id");
                                c.company_name = jo.getString("name");
                                c.profile = jo.getString("profile");
                                c.offer = jo.getString("offer");
                                c.location = jo.getString("location");
                                c.company_package = jo.getString("package");
                                c.description = jo.getString("description");
                                c.cgpa = jo.getString("cgpa");
                                c.logo = jo.getString("logo");
                                c.url = jo.getString("url");


                                companies.add(c);
//                                System.out.println(c.toString());

                            }
                            recyler = findViewById(R.id.recycler);
                            RecyclerviewAdapter recyclerviewAdapter = new RecyclerviewAdapter(MainActivity.this, companies);
                            recyler.setAdapter(recyclerviewAdapter);

                            recyler.setLayoutManager(new LinearLayoutManager(MainActivity.this));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                error.printStackTrace();
//
//                Toast.makeText(MainActivity.this,"Error Occured", Toast.LENGTH_SHORT).show();
            }
        });


        queue.add(request);






    }
}