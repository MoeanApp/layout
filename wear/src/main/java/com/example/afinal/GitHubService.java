package com.example.afinal;

import com.google.firebase.database.core.Repo;

import java.util.List;

import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubService {
  @GET("https://api.github.com/")
  Call<ResponseBody> listRepos();
}