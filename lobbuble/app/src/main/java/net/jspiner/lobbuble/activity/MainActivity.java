package net.jspiner.lobbuble.activity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import net.jspiner.lobbuble.R;
import net.jspiner.lobbuble.activity.base.BaseActivity;
import net.jspiner.lobbuble.fragment.MainFragment;
import net.jspiner.lobbuble.fragment.SplashFragment;
import net.jspiner.lobbuble.presenter.MainPresenter;
import net.jspiner.lobbuble.presenter.SplashPresenter;


import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    void init(){

        MainFragment mainFragment = MainFragment.getInstance();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.frame_splash_container, mainFragment);
        transaction.commit();

        presenter = new MainPresenter(
                mainFragment
        );
    }
}
