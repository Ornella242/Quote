package com.example.quote.View;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quote.R;

public class QuotesViewHolder extends RecyclerView.ViewHolder {
    public CardView quotes_card;
    public TextView content;
    public TextView author;

    public QuotesViewHolder(@NonNull View itemView) {
        super(itemView);
        this.quotes_card = itemView.findViewById(R.id.quotes_card);
        this.content = itemView.findViewById(R.id.content);
        this.author = itemView.findViewById(R.id.author);
    }
}
