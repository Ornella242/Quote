package com.example.quote.Service;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.quote.Models.CategoryModel;
import com.example.quote.MySingleton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class QuoteDataService {

    public static final String QUOTES_API = "https://jsonplaceholder.typicode.com/users";
    String usersName = "" ;
    Context context;

    public QuoteDataService(Context context) {
        this.context = context;
    }

    public interface VolleyResponseListener {
        public void onError(String message);
        public void onResponse(String userName);
    }

    public void getCategory(VolleyResponseListener volleyResponseListener) {
        // Instantiate the RequestQueue.
//        RequestQueue queue = Volley.newRequestQueue(CategoriesActivity.this);
        String url = QUOTES_API;


        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null , new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {
                try {
                        JSONObject usersDetails = response.getJSONObject(0);
                        usersName = usersDetails.getString("name");
                        volleyResponseListener.onResponse(usersName);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                volleyResponseListener.onError("Something went wrong");
            }
        });

        // Add a request (in this example, called stringRequest) to your RequestQueue.
        MySingleton.getInstance(context).addToRequestQueue(request);
    }

    public void getCategories(){
        List<CategoryModel> category = new ArrayList<CategoryModel>();
        // TODO: get the JSONObject
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, QUOTES_API , null, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {
                Toast.makeText(context, response.toString(), Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });



        // Add a request (in this example, called stringRequest) to your RequestQueue.
        MySingleton.getInstance(context).addToRequestQueue(request);
    }
}
