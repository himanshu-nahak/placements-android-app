package com.example.placements;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.CompanyViewHolder> {

    String[] companyList ;

    Context context;

    public RecyclerviewAdapter (Context ct , String[] cl){
        companyList = cl;
        context = ct;

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
        holder.companyName.setText(companyList[position]);


    }

    @Override
    public int getItemCount() {

        return companyList.length;
    }

    public class CompanyViewHolder extends RecyclerView.ViewHolder{

        TextView companyName;

        public CompanyViewHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);
            companyName = itemView.findViewById(R.id.companyName);



        }
    }

}
