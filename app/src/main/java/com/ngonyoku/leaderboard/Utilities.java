package com.ngonyoku.leaderboard;

import android.widget.ImageView;

import com.ngonyoku.leaderboard.Models.LearningLeaders;
import com.ngonyoku.leaderboard.Models.SkillIQLeaders;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Utilities {
    public static class GadsApiUtility {
        public static final String BASE_URL = "https://gadsapi.herokuapp.com/api/";
        public static Retrofit mRetrofit = new Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        public static HerokuAppAPI mLeadersAPI = mRetrofit.create(HerokuAppAPI.class);

        public static Call<List<LearningLeaders>> fetchLearningLeaders() {
            return mLeadersAPI.getLearningLeader();
        }

        public static Call<List<SkillIQLeaders>> fetchSkillIQLeaders() {
            return mLeadersAPI.getSkillIQLeaders();
        }
    }

    public static class ImagesUtility {
        public static void loadImage(ImageView imageView, String imageUrl) {
            Picasso
                    .get()
                    .load(imageUrl)
                    .fit()
                    .placeholder(R.color.colorAccent)
                    .into(imageView)
            ;
        }
    }
}
