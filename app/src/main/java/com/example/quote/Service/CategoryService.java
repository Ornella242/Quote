package com.example.quote.Service;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.quote.Models.CategoryModel;
import com.example.quote.Models.QuoteModel;
import com.example.quote.OnFetchDataListener;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public class CategoryService {
    Context context;

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8000/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public CategoryService(Context context) {
        this.context = context;
    }



    public void getCategory(OnFetchDataListener listener) {
        CallCategoryApi callCategoryApi = retrofit.create(CallCategoryApi.class);
        Call <List<CategoryModel>> call = callCategoryApi.getCategory();

        try {
            call.enqueue(new Callback<List<CategoryModel>>() {
                @Override
                public void onResponse(@NonNull Call<List<CategoryModel>> call, @NonNull Response<List<CategoryModel>> response) {
                    Toast.makeText(context, "", Toast.LENGTH_SHORT).show();
                    if(!response.isSuccessful()){
                        Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
                    }
                    listener.onFetchData(response.body(), response.message());
                }

                @Override
                public void onFailure(@NonNull Call<List<CategoryModel>> call, @NonNull Throwable t) {
                    listener.onError("Request Failed!");
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getQuotes(OnFetchDataListener listener, int id) {
        CallCategoryApi callCategoryApi = retrofit.create(CallCategoryApi.class);
        Call <List<QuoteModel>> call = callCategoryApi.getQuotes(id);

        try {
            call.enqueue(new Callback<List<QuoteModel>>() {
                @Override
                public void onResponse(@NonNull Call<List<QuoteModel>> call, @NonNull Response<List<QuoteModel>> response) {
                    Toast.makeText(context, "", Toast.LENGTH_SHORT).show();
                    if(!response.isSuccessful()){
                        Toast.makeText(context, response.message(), Toast.LENGTH_SHORT).show();
                    }
                    listener.onFetchData(response.body(), response.message());
                }

                @Override
                public void onFailure(@NonNull Call<List<QuoteModel>> call, @NonNull Throwable t) {
                    listener.onError("Request Failed!");
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public interface CallCategoryApi {
        @Headers("Accept: application/json")
        @GET("category")
        Call<List<CategoryModel>> getCategory();

        @Headers("Accept: application/json")
        @GET("category/{id}/quotes")
        Call<List<QuoteModel>> getQuotes(@Path("id") int id);
    }
}
