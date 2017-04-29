package net.jspiner.lobbuble;

import net.jspiner.lobbuble.model.FriendResponse;
import net.jspiner.lobbuble.model.LoginResponse;
import net.jspiner.lobbuble.model.RecoResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by jspiner on 2017. 4. 29..
 */

public interface HttpService {

    @GET("/api/v1/login")
    Call<LoginResponse> login(
        @Query("access_token") String accessToken
    );

    @GET("/api/v1/getFriendList")
    Call<FriendResponse> getFriendList(
            @Query("access_token") String accessToken
    );

    @GET("/api/v1/getMyRecommend")
    Call<RecoResponse.Data[]> getMyRecommend(
            @Query("access_token") String accessToken,
            @Query("gender") String gender,
            @Query("id") String id
    );
}
