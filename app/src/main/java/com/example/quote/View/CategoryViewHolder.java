package com.example.quote.View;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quote.R;

import java.text.CollationElementIterator;

public class CategoryViewHolder extends RecyclerView.ViewHolder {
    public CardView category_card;
    public TextView category_text;

//    public int id;
    public CategoryViewHolder(@NonNull View itemView) {
        super(itemView);

        category_card = itemView.findViewById(R.id.category_card);
        category_text = itemView.findViewById(R.id.category_text);
    }
}
