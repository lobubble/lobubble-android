package net.jspiner.lobbuble.presenter;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;

import com.facebook.FacebookException;
import com.facebook.login.LoginResult;

import net.jspiner.lobbuble.Prefer;
import net.jspiner.lobbuble.Util;
import net.jspiner.lobbuble.contract.SplashContract;
import net.jspiner.lobbuble.model.LoginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by jspiner on 2017. 4. 29..
 */

public class SplashPresenter implements SplashContract.Presenter {

    SplashContract.View splashView;

    public SplashPresenter(SplashContract.View splashView){
        this.splashView = splashView;

        splashView.setPresenter(this);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        splashView.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onFbLoginSuccess(LoginResult loginResult) {
        requestLogin(loginResult.getAccessToken().getToken());
    }

    @Override
    public void onFbLoginError(FacebookException error) {
        splashView.showToast("로그인 에러가 발생하였습니다.");

    }

    @Override
    public void onFbLoginCancel() {
        splashView.showToast("로그인이 취소되었습니다.");

    }

    void requestLogin(final String accessToken){
        splashView.changeLoadingState(true);
        Util.getService().login(accessToken).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                Prefer.set("accessToken", accessToken);

                delayHandler.sendEmptyMessageDelayed(0,1500);
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                splashView.showToast("네트워크 에러가 발생하였습니다.");
            }
        });
    }

    Handler delayHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {

            splashView.changeLoadingState(false);
            splashView.showToast("로그인을 성공하셨습니다.");
            splashView.startMainActivity();
        }
    };
}
