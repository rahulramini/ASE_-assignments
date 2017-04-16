package com.example.hp.mywikipediasearch;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;




public class SearchScreen extends AppCompatActivity {


    TextView outputTextView;
    Context mContext;
    EditText etsearchtext;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getBaseContext();
        setContentView(R.layout.activity_search_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        etsearchtext = (EditText) findViewById(R.id.etsearchtext);
        outputTextView = (TextView) findViewById(R.id.tvResult);
        Button btlogout = (Button) findViewById(R.id.btlogout);
        Button btsearch = (Button) findViewById(R.id.btsearch);

        btlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent redirect = new Intent(SearchScreen.this, HomeScreen.class);
                startActivity(redirect);
            }
        });

        btsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ExtractWikiData().execute();
            }
        });
    }

    private void hideKeyboard(View editableView) {
        InputMethodManager keyboard = (InputMethodManager)mContext
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        keyboard.hideSoftInputFromWindow(editableView.getWindowToken(), 0);
    }



class ExtractWikiData extends AsyncTask<Void, Void, String> {
    String sourceText = etsearchtext.getText().toString();
    private Exception exception;
    protected void onPreExecute() {
        outputTextView.setText("");
    }

    protected String doInBackground(Void... urls) {
        try {
            URL url = new URL("https://en.wikipedia.org/w/api.php?format=json&action=query&prop=extracts" +
                    "&exintro=&explaintext=&titles="+sourceText);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                StringBuilder stringBuilder = new StringBuilder();
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line).append("\n");
                }
                bufferedReader.close();
                return stringBuilder.toString();
            } finally {
                urlConnection.disconnect();
            }
        } catch (Exception error) {
            Log.e("ERROR", error.getMessage(), error);
            return null;
        }
    }

    protected void onPostExecute(String response) {
        if (response == null) {
            response = "Give a text to search";
        }

        Log.i("INFO", response);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                hideKeyboard(outputTextView);
            }});
              try {
                 JSONObject object = new JSONObject(response);

                  JSONObject jarray = object.getJSONObject("query");
                  JSONObject jarray2 = jarray.getJSONObject("pages");
                  String extract = jarray.getString("pages");
                  int i=2;
                  String result ="";
                  while(extract.charAt(i)!='"'){
                      result = result+extract.charAt(i);
                      i++;
                  }
                  String newExtract = result;
                  JSONObject jarray3 = jarray2.getJSONObject(newExtract);
                  String finalExtract = jarray3.getString("extract");

                  outputTextView.setText(finalExtract);

            } catch (JSONException e) {
                  e.printStackTrace();
             }
    }
}
}


