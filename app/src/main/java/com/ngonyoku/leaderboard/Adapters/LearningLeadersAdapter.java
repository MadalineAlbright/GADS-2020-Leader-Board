package com.ngonyoku.leaderboard.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ngonyoku.leaderboard.LeadersViewHolder;
import com.ngonyoku.leaderboard.Models.LearningLeaders;
import com.ngonyoku.leaderboard.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class LearningLeadersAdapter extends RecyclerView.Adapter<LeadersViewHolder> {
    private List<LearningLeaders> mLearningLeadersList;
    private Context mContext;

    public LearningLeadersAdapter(List<LearningLeaders> learningLeadersList, Context context) {
        mLearningLeadersList = learningLeadersList;
        mContext = context;
    }

    @NonNull
    @Override
    public LeadersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LeadersViewHolder(
                LayoutInflater
                        .from(mContext)
                        .inflate(R.layout.item_leaders_list, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull LeadersViewHolder holder, int position) {
        LearningLeaders currentLeaderPerHour = mLearningLeadersList.get(position);
        holder.bind(currentLeaderPerHour);
    }

    @Override
    public int getItemCount() {
        return mLearningLeadersList.size();
    }
}
