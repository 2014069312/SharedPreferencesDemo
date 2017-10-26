package com.example.sharedpreferencesdemo;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etUsername;
    EditText etPassword;
    Button btnSave, btnDisplay;
    TextView tvDisplay;
    SharedPreferences preferences;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = (EditText) findViewById(R.id.et_username);
        etPassword = (EditText) findViewById(R.id.et_password);
        btnSave = (Button) findViewById(R.id.bt_saveinfo);
        btnDisplay = (Button) findViewById(R.id.bt_displayinfo);
        tvDisplay = (TextView) findViewById(R.id.tv_display);
        preferences = getPreferences(Context.MODE_PRIVATE);

    }

    public void saveInfo (View view) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("user", etUsername.getText().toString());
        editor.putString("pwd", etPassword.getText().toString());
        editor.commit();
        Toast.makeText(this, "Saved in Shared Preferences!",Toast.LENGTH_LONG).show();
    }

    public void loadInfo (View view) {
        String user = preferences.getString("user", "");
        String pwd = preferences.getString("pwd", "");
        tvDisplay.setText("User is " + user + " and the password is " + pwd);
    }

}
