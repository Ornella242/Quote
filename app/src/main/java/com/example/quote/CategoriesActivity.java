package com.example.quote;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.quote.Adapter.CategoryAdapter;
import com.example.quote.Models.CategoryModel;
import com.example.quote.Service.CategoryService;

import java.util.List;


public class CategoriesActivity extends AppCompatActivity implements SelectListener {
    RecyclerView recyclerView;
    CategoryAdapter categoryAdapter;
    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        dialog = new ProgressDialog(CategoriesActivity.this);
        dialog.setTitle("Fetching quotes Categories ...");
        dialog.show();

        CategoryService categoryService = new CategoryService(CategoriesActivity.this);
        categoryService.getCategory(listener);
    }

    private final OnFetchDataListener listener = new OnFetchDataListener<CategoryModel>() {
        @Override
        public void onFetchData(List<CategoryModel> list, String message) {

            showCategory(list);
            dialog.dismiss();
        }

        @Override
        public void onError(String message) {
            Toast.makeText(CategoriesActivity.this, "Error !!!", Toast.LENGTH_SHORT).show();
        }
    };

    private void showCategory(List<CategoryModel> list) {
        recyclerView = findViewById(R.id.recycler_main);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(CategoriesActivity.this, 1));
        categoryAdapter = new CategoryAdapter(CategoriesActivity.this, list, CategoriesActivity.this);
        recyclerView.setAdapter(categoryAdapter);
    }


    @Override
    public void onCategoryClicked(CategoryModel category) {
        startActivity(new Intent(CategoriesActivity.this, QuotesActivity.class).putExtra("category", category));
    }
}
