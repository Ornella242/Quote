package com.example.quote.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quote.Models.CategoryModel;
import com.example.quote.R;
import com.example.quote.SelectListener;
import com.example.quote.View.CategoryViewHolder;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryViewHolder> {
    private Context context;
    private List<CategoryModel> category;
    private SelectListener selectListener;

    public CategoryAdapter(Context context, List<CategoryModel> category, SelectListener selectListener) {
        this.context = context;
        this.category = category;
        this.selectListener = selectListener;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CategoryViewHolder(LayoutInflater.from(context).inflate(R.layout.category_card, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.category_text.setText(category.get(position).getName());

        holder.category_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectListener.onCategoryClicked(category.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return category.size();
    }
}
