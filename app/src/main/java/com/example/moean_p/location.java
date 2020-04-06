package com.example.moean_p;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class location extends AppCompatActivity {

    private DrawerLayout drawer;
    ActionBarDrawerToggle toggle;
    BottomNavigationView bottomNavigationView;
    NavigationView navigationView;
    Intent intent2;
    Button provide_map;

    private static final String TAG = "activity_location";
    private TextView calculated_heartrate;
    private TextView calculated_steps;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        Toolbar toolbar=findViewById(R.id.tool_bar2);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.location_layout);

        provide_map=findViewById(R.id.provide_map);


        toggle=new ActionBarDrawerToggle(this,drawer,toolbar,R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle);
        toggle.syncState();

        Log.d(TAG,"onCreate:started");

        navigationView=findViewById(R.id.nav_drawer2);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if(menuItem.getItemId()==R.id.nav_profile2){
                    profile();
                    return true;
                }else
                if(menuItem.getItemId()==R.id.nav_consult) {
                    consult();

                    return true;
                }
                else if(menuItem.getItemId()==R.id.nav_who_is_moean2){
                    Whoismoean();
                    return true;



                }else if (menuItem.getItemId()==R.id.nav_video2){
                    videos();
                    return true;
                }
                else if(menuItem.getItemId()==R.id.nav_advising){
                    consult();
                }
                else if (menuItem.getItemId() == R.id.nav_signout2){
                    signout();
                    return true;
                }




                return false;
            }
        });



        bottomNavigationView=findViewById(R.id.bottom2_nav);

        calculated_heartrate=findViewById(R.id.calculated_heartrate);
        calculated_steps=findViewById(R.id.calculated_steps);

        bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem menuItem) {
                if(menuItem.getItemId()==R.id.nav_location){
                    Locaion();
                }

            }
        });


        FirebaseDatabase.getInstance().getReference("measures")
                .child(FirebaseAuth.getInstance().getCurrentUser().getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Log.d(TAG, "onDataChange() called with: dataSnapshot = [" + dataSnapshot + "]");
                try {
                    Measure measure = dataSnapshot.getValue(Measure.class);
                    if (measure != null) {
                        calculated_heartrate.setText("" + measure.heartrate);
                        calculated_steps.setText("" + measure.steps);
                    }
                }catch (Exception ignored){}
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d(TAG, "onCancelled() called with: databaseError = [" + databaseError + "]");
            }
        });



        provide_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GoToMap();

            }
        });



    }

    private void GoToMap() {
        Intent intent=new Intent(this,MapsActivity.class);
        startActivity(intent);
    }

    public void profile(){
        intent2=new Intent(this,childprofile.class);
        startActivity(intent2);

    }

    public void videos(){
        intent2=new Intent(this,videoscare.class);
        startActivity(intent2);

    }



    public void consult(){
        intent2=new Intent(this,Convercation_for_caregiver.class);
        startActivity(intent2);

    }
    public void Whoismoean(){
        intent2=new Intent(this,WhoIsMoeanCaregiver.class);
        startActivity(intent2);

    }

    public void Locaion(){
        intent2=new Intent(this,location.class);
        startActivity(intent2);
    }
    public void signout(){
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(WhoIsMoeanCaregiver.this,Login_or_signin.class)
                .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));

    }

}
