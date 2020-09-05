package com.ngonyoku.leaderboard.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ngonyoku.leaderboard.Models.LearningLeaders;
import com.ngonyoku.leaderboard.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class LeaningLeadersAdapter extends RecyclerView.Adapter<LeaningLeadersAdapter.HoursViewHolder> {
    private List<LearningLeaders> mLearningLeadersList;
    private Context mContext;

    public LeaningLeadersAdapter(List<LearningLeaders> learningLeadersList, Context context) {
        mLearningLeadersList = learningLeadersList;
        mContext = context;
    }

    @NonNull
    @Override
    public HoursViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HoursViewHolder(
                LayoutInflater
                        .from(mContext)
                        .inflate(R.layout.item_leader_per_hour, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull HoursViewHolder holder, int position) {
        LearningLeaders currentLeaderPerHour = mLearningLeadersList.get(position);
        holder.bind(currentLeaderPerHour);
    }

    @Override
    public int getItemCount() {
        return mLearningLeadersList.size();
    }

    static class HoursViewHolder extends RecyclerView.ViewHolder {
        ImageView mLeaderBadge;
        TextView mLeaderName, mLeaderDetails;

        public HoursViewHolder(@NonNull View itemView) {
            super(itemView);

            mLeaderBadge = itemView.findViewById(R.id.hours_badge_image);
            mLeaderName = itemView.findViewById(R.id.hours_leader_name);
            mLeaderDetails = itemView.findViewById(R.id.hours_leader_details);
        }

        void bind(LearningLeaders learningLeaders) {
            String details = learningLeaders.getHours() + " Hours, " + learningLeaders.getCountry();
            mLeaderName.setText(learningLeaders.getName());
            mLeaderDetails.setText(details);

            loadBadgeImage(mLeaderBadge, learningLeaders.getBadgeUrl());
        }

        void loadBadgeImage(ImageView imageView, String imageUrl) {
            Picasso
                    .get()
                    .load(imageUrl)
                    .fit()
                    .placeholder(R.color.colorAccent)
                    .centerCrop()
                    .into(imageView)
            ;
        }
    }
}
