package com.example.placements;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.CompanyViewHolder> {

    ArrayList<Company> companyList ;

    Context context;

    public RecyclerviewAdapter (Context ct , ArrayList<Company> cl){
        companyList = cl;
        context = ct;
        System.out.println("DEBUNG1"+ companyList.toString());
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public CompanyViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.companyrow, parent, false);


        return new CompanyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull RecyclerviewAdapter.CompanyViewHolder holder, int position) {
//        holder.companyName.setText((CharSequence) companyList.get(position));
        holder.companyName.setText(companyList.get(position).company_name);
        holder.packageTextView.setText(companyList.get(position).company_package+ " LPA");

        holder.companyCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CompanyInfo.class);
                intent.putExtra("name", companyList.get(position).company_name);
                intent.putExtra("profile", companyList.get(position).profile);
                intent.putExtra("package", companyList.get(position).company_package);
                intent.putExtra("offer", companyList.get(position).offer);
                intent.putExtra("location", companyList.get(position).location);
                intent.putExtra("info", companyList.get(position).description);



                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {

        return companyList.size();
    }

    public class CompanyViewHolder extends RecyclerView.ViewHolder{

        TextView companyName, packageTextView;
        LinearLayout companyCard;


        public CompanyViewHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);
            companyName = itemView.findViewById(R.id.companyName);
            packageTextView = itemView.findViewById(R.id.packageTextView);
            companyCard = itemView.findViewById(R.id.companyCard);



        }
    }

}
