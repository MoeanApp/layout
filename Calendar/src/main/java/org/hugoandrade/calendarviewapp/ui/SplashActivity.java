package org.hugoandrade.calendarviewapp.ui;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

import org.hugoandrade.calendarviewapp.MainActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (FirebaseAuth.getInstance().getCurrentUser() == null) {
            startActivity(new Intent(this, Login.class));
        } else {
            startActivity(new Intent(this, MainActivity.class));
        }

        finish();
    }
}
