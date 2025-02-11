package lk.iot.loadmanagement.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import lk.iot.loadmanagement.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.zoom_in, R.anim.zoom_out);
    }
}
