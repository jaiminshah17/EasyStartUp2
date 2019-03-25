package com.example.jaiminshah.easystartup;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class CompanyRecyclerViewHolder extends RecyclerView.ViewHolder {
    TextView txt_Cn, txt_Rp, txt_Cd;

    public CompanyRecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
        txt_Cn = (TextView)itemView.findViewById(R.id.txt_name);
        txt_Rp = (TextView)itemView.findViewById(R.id.txt_Rposition);
        txt_Cd = (TextView)itemView.findViewById(R.id.txt_Cdescription);
    }
}
