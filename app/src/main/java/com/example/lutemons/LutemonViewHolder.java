package com.example.lutemons;

import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LutemonViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView tvName, tvHealth, tvWins, tvAttack;
    public LutemonViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageView);
        tvName = itemView.findViewById(R.id.tvName);
        tvHealth = itemView.findViewById(R.id.tvHealth);
       }
}
