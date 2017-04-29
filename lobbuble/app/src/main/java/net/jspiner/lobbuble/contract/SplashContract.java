package net.jspiner.lobbuble.contract;

import android.content.Intent;

import com.facebook.FacebookException;
import com.facebook.login.LoginResult;

import net.jspiner.lobbuble.presenter.base.BasePresenter;
import net.jspiner.lobbuble.contract.base.BaseView;

/**
 * Created by jspiner on 2017. 4. 29..
 */

public class SplashContract {

    public interface View extends BaseView<Presenter>{
        void onActivityResult(int requestCode, int resultCode, Intent data);

        void startMainActivity();
    }

    public interface Presenter extends BasePresenter {
        void onActivityResult(int requestCode, int resultCode, Intent data);

        void onFbLoginSuccess(LoginResult loginResult);
        void onFbLoginError();
        void onFbLoginCancel(FacebookException error);
    }

}
