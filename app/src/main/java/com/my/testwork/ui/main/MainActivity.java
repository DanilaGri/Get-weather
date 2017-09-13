package com.my.testwork.ui.main;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.my.testwork.R;
import com.my.testwork.ui.base.BaseActivity;
import com.my.testwork.ui.login.LoginActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityComponent().inject(this);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    private void startAuth() {
        try {
            Intent intent = new Intent(this, LoginActivity.class);
            this.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @OnClick(R.id.main_auth_button)
    public void onAuth() {
        startAuth();
    }

}
