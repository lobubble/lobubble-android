package net.jspiner.lobbuble;

import net.jspiner.lobbuble.model.LoginResponse;

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
        @Query("access_token") String access_token
    );
}
