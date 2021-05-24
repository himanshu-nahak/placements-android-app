package com.example.placements;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.fonts.FontFamily;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class ViewCompany extends AppCompatActivity {

    TextView TVcompanyName , TVRoleOffered, TVPackage, TVOffer, TVLocation,TVCGPA, TVDescription ;
    String cName, cProfile, cPackage, cOffer , cLocation, cInfo, cUrl, cLogo,cCGPA;
    ImageView IVLogo;
    Button btnLinkedIn;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_company);
        getSupportActionBar().setTitle("Placement Drive Details");


        TVcompanyName = findViewById(R.id.TVcompanyName);
        TVRoleOffered = findViewById(R.id.TVRoleOffered);
        TVPackage = findViewById(R.id.TVPackage);
        TVOffer = findViewById(R.id.TVOffer);
        TVLocation = findViewById(R.id.TVLocation);
        TVCGPA = findViewById(R.id.TVCGPA);
        TVDescription = findViewById(R.id.TVDescription);
        btnLinkedIn = findViewById(R.id.btnLinkedIn);
        IVLogo = findViewById(R.id.IVLogo);

        getData();
        setData();

        btnLinkedIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(cUrl); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });



    }

    private void getData(){

        if(getIntent().hasExtra("name") && getIntent().hasExtra("profile")) {
            cName = getIntent().getStringExtra("name");
            cProfile = getIntent().getStringExtra("profile");
            cPackage = getIntent().getStringExtra("package");
            cOffer = getIntent().getStringExtra("offer");
            cLocation = getIntent().getStringExtra("location");
            cInfo = getIntent().getStringExtra("description");
            cLogo = getIntent().getStringExtra("logo");
            cCGPA = getIntent().getStringExtra("cgpa");
            cUrl = getIntent().getStringExtra("url");

        }else{
            Toast.makeText(getApplicationContext(),"Couldn't fetch company details", Toast.LENGTH_SHORT).show();
        }
    }

    private void setData(){
        TVcompanyName.setText(cName);
        TVRoleOffered.setText(cProfile);
        TVPackage.setText(cPackage + " LPA");
        TVOffer.setText(cOffer);
        TVLocation.setText(cLocation);
        TVCGPA.setText(cCGPA+ " CGPA");
        Glide.with(ViewCompany.this).load(cLogo).into(IVLogo);
        Bundle bundle = getIntent().getExtras();
        String description = bundle.getString("description", "Default");
        TVDescription.setText(description);

        //        tvInfo.setText("Lorem Ipsum");

//        Toast.makeText(getApplicationContext(),cInfo,Toast.LENGTH_SHORT).show();

//        System.out.println(cInfo);

    }

}