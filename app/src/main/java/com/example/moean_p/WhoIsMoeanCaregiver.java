package com.example.moean_p;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import org.hugoandrade.calendarviewapp.CreateEventActivity;
import org.hugoandrade.calendarviewapp.ui.SplashActivity;

public class WhoIsMoeanCaregiver extends AppCompatActivity {

    private DrawerLayout drawer;
    ActionBarDrawerToggle toggle;
    BottomNavigationView bottomNavigationView;
    NavigationView navigationView;
    FirebaseAuth firebaseAuth;
    Intent intent2;
    Button b1;
    private static final String TAG = "WhoIsMoeanCaregiver";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_who_is_moean_caregiver2);


        Toolbar toolbar = findViewById(R.id.tool_bar2);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.caregiver_layout);

        toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle);
        toggle.syncState();
        Log.d(TAG, "onCreate:started");


        navigationView = findViewById(R.id.nav_drawer2);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.nav_profile2) {
                    profile();
                    return true;
                } else if (menuItem.getItemId() == R.id.nav_who_is_moean2) {
                    Whoismoean();
                    return true;
                } else if (menuItem.getItemId() == R.id.nav_video2) {
                    videos();
                    return true;
                } else if (menuItem.getItemId() == R.id.nav_advising) {
                    consult();
                } else if (menuItem.getItemId() == R.id.nav_signout2){
                    signout();
return true;
                }


                return false;
            }
        });

        bottomNavigationView = findViewById(R.id.bottom2_nav);
        bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.nav_location) {
                    Locaion();
                }else if(menuItem.getItemId() == R.id.nav_calender){
                    calendar();
                }

            }
        });


    }

    public void twitter(View view) {
        Intent twitterintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/MoeanApp"));
        startActivity(twitterintent);
    }

    public void profile() {
        intent2 = new Intent(this, childprofile.class);
        startActivity(intent2);

    }

    public void consult() {
        intent2 = new Intent(this, Convercation_for_caregiver.class);
        startActivity(intent2);

    }

    public void Whoismoean() {
        intent2 = new Intent(this, WhoIsMoeanCaregiver.class);
        startActivity(intent2);

    }

    public void Locaion() {
        intent2 = new Intent(this, location.class);
        startActivity(intent2);
    }

    public void calendar() {
        intent2 = new Intent(this, SplashActivity.class);
        startActivity(intent2);
    }

    public void videos() {
        intent2 = new Intent(this, videoscare.class);
        startActivity(intent2);

    }

    public void signout(){
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(WhoIsMoeanCaregiver.this,Login_or_signin.class)
        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));

    }


}
