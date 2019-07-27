package com.junhwa.doitmission09;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RegistrationFragment registrationFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registrationFragment = (RegistrationFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);
    }

    public void onSaveButtonClicked(String name, int age, String birthDate) {
        Toast.makeText(getApplicationContext(), "Name = " + name + "\nAge = " + age + "\nBirth Date = " + birthDate, Toast.LENGTH_LONG).show();
    }
}
