package net.jspiner.lobbuble.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
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

    @Bind(R.id.imv_splash_logo)
    ImageView imvLogo;

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

        splashDelayHandler.sendEmptyMessageDelayed(0, 1500);

    }

    Handler splashDelayHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            TranslateAnimation animation = new TranslateAnimation(
                    Animation.RELATIVE_TO_SELF, 0f,
                    Animation.RELATIVE_TO_SELF, 0f,
                    Animation.RELATIVE_TO_SELF, 0f,
                    Animation.RELATIVE_TO_SELF, -1.2f
            );
            animation.setDuration(800);
            animation.setFillAfter(true);
            imvLogo.startAnimation(animation);

            loginButton.setVisibility(View.VISIBLE);
            AlphaAnimation fadeOut = new AlphaAnimation(0f, 1f);
            fadeOut.setStartOffset(200);
            fadeOut.setDuration(600);

            loginButton.startAnimation(fadeOut);

        }
    };

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

        getActivity().overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);
    }
}
