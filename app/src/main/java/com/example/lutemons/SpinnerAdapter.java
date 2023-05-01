package com.example.lutemons;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class SpinnerAdapter extends ArrayAdapter<Lutemon> {

    public SpinnerAdapter(Context context, ArrayList<Lutemon> lutemons)  {
        super(context, 0, lutemons);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }
    private View initView(int position, View convertView, ViewGroup parent){
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.spinner_row, parent, false
            );
        }
        TextView tvSpinnerName = convertView.findViewById(R.id.lutemonNameSpinner);
        ImageView ivFighterImage = convertView.findViewById(R.id.ivFighterImage);
        Lutemon currentLutemon = getItem(position);
        tvSpinnerName.setText(currentLutemon.getName());
        ivFighterImage.setImageResource(currentLutemon.getImage());
        return convertView;
    }
}
