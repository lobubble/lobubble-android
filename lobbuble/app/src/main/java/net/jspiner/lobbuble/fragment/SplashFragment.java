package net.jspiner.lobbuble.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import net.jspiner.lobbuble.activity.MainActivity;
import net.jspiner.lobbuble.R;
import net.jspiner.lobbuble.contract.SplashContract;
import net.jspiner.lobbuble.fragment.base.BaseFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by jspiner on 2017. 4. 29..
 */

public class SplashFragment extends BaseFragment implements SplashContract.View{

    @Bind(R.id.fblogin_splash)
    LoginButton loginButton;

    CallbackManager callbackManager;

    private SplashContract.Presenter presenter;

    public static SplashFragment getInstance(){
        return new SplashFragment();
    }

    @Override
    public void setPresenter(SplashContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_splash, container, false);

        ButterKnife.bind(this, view);

        init();
        return view;
    }

    void init(){
        callbackManager = CallbackManager.Factory.create();

        String[] permissions = {
                "email",
                "public_profile",
                "user_about_me",
                "user_friends",
                "read_custom_friendlists"
        };
        loginButton.setReadPermissions(permissions);
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.d(TAG, "onSuccess");

                String loginToken = loginResult.getAccessToken().getToken();
                Log.d(TAG, "token : " + loginToken);
            }

            @Override
            public void onCancel() {
                Log.d(TAG, "onCancel");


            }

            @Override
            public void onError(FacebookException error) {
                Log.d(TAG, "onError");
                Log.e(TAG, "error msg : " + error.getMessage());

            }
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void showToast(String text) {
        Toast.makeText(getContext(), text, Toast.LENGTH_LONG).show();
    }

    @Override
    public void startMainActivity() {
        Intent intent = new Intent(getActivity(), MainActivity.class);
        startActivity(intent);
    }
}
