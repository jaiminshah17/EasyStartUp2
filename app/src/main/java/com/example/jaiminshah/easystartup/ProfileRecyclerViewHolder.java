package com.example.jaiminshah.easystartup;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class ProfileRecyclerViewHolder extends RecyclerView.ViewHolder {
    TextView txt_Fn, txt_Ln, Email, Phone, Address, College, Major, Job, Company, Description;

    public ProfileRecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
        txt_Fn = (TextView)itemView.findViewById(R.id.txt_fn);
        txt_Ln = (TextView)itemView.findViewById(R.id.txt_ln);

        Email = (TextView)itemView.findViewById(R.id.email);
        Phone = (TextView)itemView.findViewById(R.id.phone);
        Address = (TextView)itemView.findViewById(R.id.address);

        College = (TextView)itemView.findViewById(R.id.education);
        Major = (TextView)itemView.findViewById(R.id.major);
        Job = (TextView)itemView.findViewById(R.id.job);

        Company = (TextView)itemView.findViewById(R.id.company);
        Description = (TextView)itemView.findViewById(R.id.description);
    }

}
