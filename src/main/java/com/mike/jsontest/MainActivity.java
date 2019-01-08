package com.mike.jsontest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private RecyclerView mRecyclerView;
    private ExampleAdapter mExampleAdapter;
    private ArrayList<ExampleItem> mExampleList;
    private RequestQueue mRequestQueue;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
// set recycler view
        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        mExampleList = new ArrayList<>();
        mRequestQueue = Volley.newRequestQueue(this);
// parse Json
        parseJson();
    }
// pulling json string  and adding to the object
    private void parseJson(){
        String url = "https://mantraapp.000webhostapp.com/wp-json/wp-api-menus/v2/menus/7?";
        // get method used
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
            new Response.Listener<JSONObject>(){
                @Override
                public void onResponse(JSONObject response) {

                    try {
                        JSONArray jsonArray = response.getJSONArray("items");

                        int i;
                        for (i = 0; i < jsonArray.length(); i++);{
                            JSONObject item = jsonArray.getJSONObject(i);

                            String tilte = item.getString(".title");
                            String url = item.getString(".url");


                            mExampleList.add(new ExampleItem(tilte,url));

                        }

                        mExampleAdapter = new ExampleAdapter(MainActivity.this, mExampleList);
                        mRecyclerView .setAdapter(mExampleAdapter);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }, new Response.ErrorListener(){

                @Override
                public void onErrorResponse(VolleyError error) {

                    error .printStackTrace();

                }
            });

        mRequestQueue .add(request);
    }
}
