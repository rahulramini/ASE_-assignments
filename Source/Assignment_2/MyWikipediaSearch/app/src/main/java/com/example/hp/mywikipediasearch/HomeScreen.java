package com.example.hp.mywikipediasearch;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HomeScreen extends AppCompatActivity implements View.OnClickListener {

    Button btlogin;
    EditText etusername;
    EditText etpassword;
    TextView tvloginfail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btlogin = (Button) findViewById(R.id.btlogin);
        etusername = (EditText) findViewById(R.id.etusername);
        etpassword = (EditText) findViewById(R.id.etpassword);
        tvloginfail = (TextView) findViewById(R.id.tvloginfail);

        btlogin.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        String username = etusername.getText().toString();
        String password = etpassword.getText().toString();


        if (!username.isEmpty() && !password.isEmpty()) {
            if (username.equals("admin") && password.equals("admin")) {
                Intent redirect = new Intent(HomeScreen.this, SearchScreen.class);
                startActivity(redirect);
            }
            else{
                tvloginfail.setVisibility(View.VISIBLE);
                tvloginfail.setText("Username or Password must be incorrect");
            }
        }
    }
}
