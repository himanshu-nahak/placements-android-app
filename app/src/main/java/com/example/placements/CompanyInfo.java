package com.example.placements;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class CompanyInfo extends AppCompatActivity {

    TextView ccName , tvProfile, tvPackage, tvOffer, tvLocation, tvInfo;
    String cName, cProfile, cPackage, cOffer , cLocation, cInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_info);

        ccName = findViewById(R.id.ccName);
        tvProfile = findViewById(R.id.tvProfile);
        tvPackage = findViewById(R.id.packageTextView);
        tvOffer = findViewById(R.id.tvOffer);
        tvLocation = findViewById(R.id.tvLocation);
        tvInfo = findViewById(R.id.tvInfo);
        getData();
        setData();

    }

    private void getData(){
        if(getIntent().hasExtra("name") && getIntent().hasExtra("profile")) {
            cName = getIntent().getStringExtra("name");
            cProfile = getIntent().getStringExtra("profile");
            cPackage = getIntent().getStringExtra("package");
            cOffer = getIntent().getStringExtra("offer");
            cLocation = getIntent().getStringExtra("location");
            cInfo = getIntent().getStringExtra("description");

        }else{
            Toast.makeText(getApplicationContext(),"Couldn't fetch company details", Toast.LENGTH_SHORT).show();
        }
    }

    private void setData(){
        ccName.setText(cName);
        tvProfile.setText(cProfile);
        tvPackage.setText(cPackage + " LPA");
        tvOffer.setText(cOffer);
        tvLocation.setText(cLocation);
        tvInfo.setText(cInfo);
        System.out.println(cInfo);

    }

}