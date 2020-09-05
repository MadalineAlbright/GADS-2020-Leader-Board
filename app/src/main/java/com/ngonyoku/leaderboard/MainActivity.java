package com.ngonyoku.leaderboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.ngonyoku.leaderboard.Adapters.ViewPagerAdapter;
import com.ngonyoku.leaderboard.Fragments.LearningLeadersFragment;
import com.ngonyoku.leaderboard.Fragments.SkillIQLeaders;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setSupportActionBar(findViewById(R.id.main_toolbar));

        ViewPager viewPager = findViewById(R.id.main_viewpager);
        TabLayout tabLayout = findViewById(R.id.main_tabLayout);

        tabLayout.setupWithViewPager(viewPager);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), 0);
        viewPagerAdapter.addFragments(new LearningLeadersFragment(this), "Learning Leaders");
        viewPagerAdapter.addFragments(new SkillIQLeaders(), "Skill IQ Leaders");

        viewPager.setAdapter(viewPagerAdapter);
    }
}