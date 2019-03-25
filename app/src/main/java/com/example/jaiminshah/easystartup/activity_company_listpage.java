package com.example.jaiminshah.easystartup;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class activity_company_listpage extends AppCompatActivity implements View.OnClickListener {

    RecyclerView recyclerView;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    FirebaseRecyclerAdapter<CompanyProfile, CompanyRecyclerViewHolder> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_listpage);

        //        Toprofile = (Button)findViewById(R.id.toprofile);
        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Enterprise");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                displayList();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        displayList();
    }

    @Override
    protected void onStop(){
        if(adapter!= null)
            adapter.stopListening();
        super.onStop();
    }

    private void displayList(){
        FirebaseRecyclerOptions<CompanyProfile> options =
                new FirebaseRecyclerOptions.Builder<CompanyProfile>().setQuery(databaseReference, CompanyProfile.class)
                        .build();

        adapter =
                new FirebaseRecyclerAdapter<CompanyProfile, CompanyRecyclerViewHolder>(options) {
                    @Override
                    protected void onBindViewHolder(@NonNull CompanyRecyclerViewHolder holder, int position, @NonNull CompanyProfile model) {

                        holder.txt_Cn.setText(model.getCompanyName());
                        holder.txt_Rp.setText(model.getPosition());
                        holder.txt_Cd.setText(model.getComDescription());

                    }

                    @NonNull
                    @Override
                    public CompanyRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
                        View itemView = LayoutInflater.from(getBaseContext()).inflate(R.layout.company_list_model,viewGroup,false);
                        return new CompanyRecyclerViewHolder(itemView);
                    }
                };
        adapter.startListening();
        recyclerView.setAdapter(adapter);
    }










    @Override
    public void onClick(View v) {
//        if(v == Toprofile){
//            startActivity(new Intent(this, Jobseeker_ProfileActivity.class));
//        }

    }
}
