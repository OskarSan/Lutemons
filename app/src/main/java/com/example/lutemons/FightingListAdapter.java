package com.example.lutemons;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;

public class FightingListAdapter extends RecyclerView.Adapter<FightingViewHolder>{

    private Context context;
    private ArrayList<String> story;

    public FightingListAdapter(Context context, ArrayList<String> story) {
        this.context = context;
        this.story = story;}

    @NonNull
    @Override
    public FightingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FightingViewHolder(LayoutInflater.from(context).inflate(R.layout.fight_story_view,parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull FightingViewHolder holder, int position) {
        holder.tvStoryLine.setText(story.get(position));
    }

    @Override
    public int getItemCount() {
        return story.size();
    }
}
