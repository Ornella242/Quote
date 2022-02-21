package com.example.quote;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.example.quote.Adapter.CategoryAdapter;
import com.example.quote.Adapter.QuoteAdapter;
import com.example.quote.Models.CategoryModel;
import com.example.quote.Models.QuoteModel;
import com.example.quote.Service.CategoryService;

import java.util.List;

public class QuotesActivity extends AppCompatActivity {
    CategoryModel category;
    RecyclerView recyclerView;
    QuoteAdapter quoteAdapter ;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotes);

        dialog = new ProgressDialog(QuotesActivity.this);
        dialog.setTitle("Fetching quotes  ...");
        dialog.show();

        category = (CategoryModel) getIntent().getSerializableExtra("category");

        CategoryService categoryService = new CategoryService(QuotesActivity.this);
        categoryService.getQuotes(listener, "1");
    }


    private final OnFetchDataListener<QuoteModel> listener = new OnFetchDataListener<QuoteModel>() {
        @Override
        public void onFetchData(List<QuoteModel> list, String message) {

            showQuotes(list);
            Toast.makeText(QuotesActivity.this, "We got the that", Toast.LENGTH_SHORT).show();
            dialog.dismiss();
        }

        @Override
        public void onError(String message) {
            Toast.makeText(QuotesActivity.this, "Error !!!", Toast.LENGTH_SHORT).show();
        }
    };

    private void showQuotes(List<QuoteModel> list) {
        recyclerView = findViewById(R.id.recycler_quotes);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(QuotesActivity.this, 1));
        quoteAdapter = new QuoteAdapter(QuotesActivity.this, list);
        recyclerView.setAdapter(quoteAdapter);
    }
}