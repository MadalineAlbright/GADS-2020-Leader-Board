package com.ngonyoku.leaderboard;

import com.ngonyoku.leaderboard.Models.LearningLeaders;
import com.ngonyoku.leaderboard.Models.SkillIQLeaders;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface HerokuAppAPI {

    @GET("hours")
    Call<List<LearningLeaders>> getLearningLeader();

    @GET("skilliq")
    Call<List<SkillIQLeaders>> getSkillIQLeaders();
}
