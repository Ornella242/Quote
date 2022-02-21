package com.example.quote.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quote.Models.CategoryModel;
import com.example.quote.Models.QuoteModel;
import com.example.quote.QuotesActivity;
import com.example.quote.R;
import com.example.quote.SelectListener;
import com.example.quote.View.CategoryViewHolder;
import com.example.quote.View.QuotesViewHolder;

import java.util.List;

public class QuoteAdapter extends RecyclerView.Adapter<QuotesViewHolder> {
    private Context context;
    private List<QuoteModel> quotes;

    public QuoteAdapter(Context context, List<QuoteModel> quotes) {
        this.context = context;
        this.quotes = quotes;
    }

    @NonNull
    @Override
    public QuotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new QuotesViewHolder(LayoutInflater.from(context).inflate(R.layout.quote_card, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull QuotesViewHolder holder,  int position) {
        holder.content.setText(this.quotes.get(position).getContent());
        holder.author.setText(this.quotes.get(position).getAuthor());
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
