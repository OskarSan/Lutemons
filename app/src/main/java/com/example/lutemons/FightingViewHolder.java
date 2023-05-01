package com.example.lutemons;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FightingViewHolder extends RecyclerView.ViewHolder{

    TextView tvStoryLine;

    public FightingViewHolder(@NonNull View itemView) {
        super(itemView);

        tvStoryLine = itemView.findViewById(R.id.tvStoryLine);
    }


}
