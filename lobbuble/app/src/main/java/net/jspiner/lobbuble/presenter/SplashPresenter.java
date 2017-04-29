package net.jspiner.lobbuble.presenter;

import android.content.Intent;

import com.facebook.FacebookException;
import com.facebook.login.LoginResult;

import net.jspiner.lobbuble.contract.SplashContract;

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
    public void start() {

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        splashView.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onFbLoginSuccess(LoginResult loginResult) {
        splashView.showToast("로그인을 성공하였습니다.");
    }

    @Override
    public void onFbLoginError() {
        splashView.showToast("로그인 에러가 발생하였습니다.");

    }

    @Override
    public void onFbLoginCancel(FacebookException error) {
        splashView.showToast("로그인이 취소되었습니다.");

    }
}
