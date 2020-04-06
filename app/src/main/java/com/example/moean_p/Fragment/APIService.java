package com.example.moean_p.Fragment;

import com.example.moean_p.Notifications.MyResponse;
import com.example.moean_p.Notifications.Sender;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIService {

    @Headers(
            {
                    "Content-Type:application/json",
                    "Authorization:key=AAAAudtTV8U:APA91bH5OT68RFBJhnkK3-0XABRi5SAATn2503zxFpG6JnOUimgzJLm1MwK1pUoy9DP2Ya_4yWIBWkHD7DelzlUMf9FE_mve1hpX_6n_Df8iTPV1d_f4YJlnim3JJ_FI-LnnvZVimBtH"
            }
    )

    @POST("fcm/send")
    Call<MyResponse> sendNotification(@Body Sender body);
}
