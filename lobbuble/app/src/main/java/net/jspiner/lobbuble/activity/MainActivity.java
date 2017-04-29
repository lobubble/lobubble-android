package net.jspiner.lobbuble.activity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

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

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ButterKnife.bind(this);

        init();
    }

    void init(){

        //set toolbar
        toolbar.setTitle("나의 친구");
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return false;
            }
        });

        setSupportActionBar(toolbar);

/*        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(Color.WHITE);
        }*/

        final Drawable upArrow = getResources().getDrawable(R.drawable.ic_arrow_back_white_24dp);
        upArrow.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        MainFragment mainFragment = MainFragment.getInstance();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.frame_main_container, mainFragment);
        transaction.commit();

        presenter = new MainPresenter(
                mainFragment
        );
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
