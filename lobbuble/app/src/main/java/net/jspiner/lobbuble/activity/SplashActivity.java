package net.jspiner.lobbuble.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;

import net.jspiner.lobbuble.R;
import net.jspiner.lobbuble.activity.base.BaseActivity;
import net.jspiner.lobbuble.fragment.SplashFragment;
import net.jspiner.lobbuble.presenter.SplashPresenter;

/**
 * Created by jspiner on 2017. 4. 29..
 */

public class SplashActivity extends BaseActivity {

    private SplashPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        init();
    }

    void init(){

        SplashFragment splashFragment = SplashFragment.getInstance();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.frame_splash_container, splashFragment);
        transaction.commit();

        presenter = new SplashPresenter(
                splashFragment
        );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        presenter.onActivityResult(requestCode, resultCode, data);
    }
}
