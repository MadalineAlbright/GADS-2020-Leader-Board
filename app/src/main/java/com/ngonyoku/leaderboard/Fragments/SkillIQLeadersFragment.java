package com.ngonyoku.leaderboard.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ngonyoku.leaderboard.Adapters.SkillIQLeadersAdapter;
import com.ngonyoku.leaderboard.HerokuAppAPI;
import com.ngonyoku.leaderboard.Models.SkillIQLeaders;
import com.ngonyoku.leaderboard.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SkillIQLeadersFragment extends Fragment {
    public static final String BASE_URL = "https://gadsapi.herokuapp.com/api/";
    private Context mContext;
    private RecyclerView mSkillIQLeaderList;
    private List<SkillIQLeaders> mSkillIQLeaders;
    private Retrofit mRetrofit;
    private SkillIQLeadersAdapter mAdapter;

    public SkillIQLeadersFragment(Context context) {
        this.mContext = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_skill_iq_learners, container, false);

        mSkillIQLeaderList = view.findViewById(R.id.skilliq__recyclerView);
        mSkillIQLeaders = new ArrayList<>();

        mSkillIQLeaderList.setLayoutManager(new LinearLayoutManager(getContext()));
        mSkillIQLeaderList.setHasFixedSize(true);
        mAdapter = new SkillIQLeadersAdapter(mSkillIQLeaders, mContext);

        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        ;

        fetchSkillIQLeaders();
        return view;
    }

    private void fetchSkillIQLeaders() {
        HerokuAppAPI herokuAppAPI = mRetrofit.create(HerokuAppAPI.class);

        Call<List<SkillIQLeaders>> call = herokuAppAPI.getSkillIQLeaders();
        call
                .enqueue(new Callback<List<SkillIQLeaders>>() {
                    @Override
                    public void onResponse(Call<List<SkillIQLeaders>> call, Response<List<SkillIQLeaders>> response) {
                        if (!response.isSuccessful()) {
                            new AlertDialog.Builder(mContext)
                                    .setTitle("Error")
                                    .setMessage(response.message() + "\n" + response.code())
                            ;
                        }

                        List<SkillIQLeaders> skillIQLeaders = response.body();
                        assert skillIQLeaders != null;
                        mSkillIQLeaders.addAll(skillIQLeaders);

                        mAdapter.notifyDataSetChanged();
                        mSkillIQLeaderList.setAdapter(mAdapter);
                    }

                    @Override
                    public void onFailure(Call<List<SkillIQLeaders>> call, Throwable t) {
                        new AlertDialog.Builder(mContext)
                                .setTitle("Error")
                                .setMessage(t.getMessage())
                        ;
                    }
                })
        ;
    }

}
