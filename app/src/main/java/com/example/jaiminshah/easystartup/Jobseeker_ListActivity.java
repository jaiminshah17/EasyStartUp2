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

public class Jobseeker_ListActivity extends AppCompatActivity implements View.OnClickListener{
//    private Button Toprofile;

    RecyclerView recyclerView;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    FirebaseRecyclerAdapter<UserProfile, ProfileRecyclerViewHolder> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jobseeker_listpage);
//        Toprofile = (Button)findViewById(R.id.toprofile);
        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("JobSeeker");
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
        FirebaseRecyclerOptions<UserProfile> options =
                new FirebaseRecyclerOptions.Builder<UserProfile>().setQuery(databaseReference, UserProfile.class)
                .build();

         adapter =
                new FirebaseRecyclerAdapter<UserProfile, ProfileRecyclerViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull ProfileRecyclerViewHolder holder, int position, @NonNull UserProfile model) {

                holder.txt_Fn.setText(model.getFirstname());
                holder.txt_Ln.setText(model.getLastname());

                holder.Email.setText(model.getEmail());
                holder.Phone.setText(model.getPhone());
                holder.Address.setText(model.getAddress());

                holder.College.setText(model.getCollege());
                holder.Major.setText(model.getMajor());
                holder.Job.setText(model.getJob());

                holder.Company.setText(model.getCompany());
                holder.Description.setText(model.getDescription());
            }

            @NonNull
            @Override
            public ProfileRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
                View itemView = LayoutInflater.from(getBaseContext()).inflate(R.layout.jobseeker_list_model,viewGroup,false);
                return new ProfileRecyclerViewHolder(itemView);
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
