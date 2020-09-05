package com.ngonyoku.leaderboard;

import com.ngonyoku.leaderboard.Models.LearningLeaders;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LearningLeadersAPI {

    @GET("hours")
    Call<List<LearningLeaders>> getLearningLeader();
}
