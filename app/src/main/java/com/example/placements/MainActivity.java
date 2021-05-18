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
        String url ="https://60a37c2c7c6e8b0017e270eb.mockapi.io/placements/api/Company";
//         url = "https://jsonplaceholder.typicode.com/posts/1";
        System.out.println("URL HIT::::" + url);

//        JsonObjectRequest request = new JsonObjectRequest(url,null, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//                try {
//                    System.out.println("DEBUNG:1");
//                    System.out.println(response.toString());
//                    ;
//
//                    //dreamart
////                    JSONObject spritesObject = response.getJSONObject("sprites");
////                    String front_default = spritesObject.getString("front_default");
////                    JSONObject otherObject = spritesObject.getJSONObject("other");
////                    JSONObject officialArtworkObject = otherObject.getJSONObject("official-artwork");
////                    String officialArtworkFrontDefault = officialArtworkObject.getString("front_default");
////                    Glide.with(ViewPokemon.this).load(officialArtworkFrontDefault).into(pDreamImage);
//
//
////                    // GET POKEMON TYPES
////                    JSONArray typesObjectArray = response.getJSONArray("types");
////                    JSONObject slot1Object = typesObjectArray.getJSONObject(0);
////                    JSONObject type1Object = slot1Object.getJSONObject("type");
////                    pType1 = type1Object.getString("name");
////                    System.out.println("1..."+pType1);
////
////                    if (typesObjectArray.length() >1 ){
////                        JSONObject slot2Object = typesObjectArray.getJSONObject(1);
////                        JSONObject type2Object = slot2Object.getJSONObject("type");
////                        pType2 = type2Object.getString("name");
////                        // TODO Set to TextView
////                        pType.setText(pType1.toUpperCase()+ " | " + pType2.toUpperCase());
////                    }
////                    else
////                        pType.setText(pType1.toUpperCase());
//
//
//
//                    // make it JSONException
//                } catch (Exception e) {
//
//                    e.printStackTrace();
//                }
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                System.out.println("DEBUNG:2");
//                error.printStackTrace();
//
//                Toast.makeText(MainActivity.this,"Error Occured", Toast.LENGTH_SHORT).show();
//            }
//        });

        //Request a string response from the provided URL.
        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                    System.out.println(response);






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



        recyler = findViewById(R.id.recycler);
        RecyclerviewAdapter recyclerviewAdapter = new RecyclerviewAdapter(this, companyList);
        recyler.setAdapter(recyclerviewAdapter);

        recyler.setLayoutManager(new LinearLayoutManager(this));



    }
}