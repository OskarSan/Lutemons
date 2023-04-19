package com.example.lutemons;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.lutemons.fragments.CreateLutemonFragment;
import com.example.lutemons.fragments.FightLutemonFragment;
import com.example.lutemons.fragments.TrainLutemonFragment;

public class TabPagerAdapter extends FragmentStateAdapter {

    public TabPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position){
            case 0:
                return new CreateLutemonFragment();
            case 1:
                return new TrainLutemonFragment();
            case 2:
                return new FightLutemonFragment();
            default:
                return new CreateLutemonFragment();
        }

    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
