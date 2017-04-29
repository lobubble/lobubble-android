package net.jspiner.lobbuble.activity;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import com.google.gson.Gson;

import net.jspiner.lobbuble.R;
import net.jspiner.lobbuble.activity.base.BaseActivity;
import net.jspiner.lobbuble.fragment.DetailFragment;
import net.jspiner.lobbuble.fragment.MainFragment;
import net.jspiner.lobbuble.model.RecoResponse;
import net.jspiner.lobbuble.presenter.DetailPresenter;
import net.jspiner.lobbuble.presenter.MainPresenter;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by jspiner on 2017. 4. 30..
 */

public class DetailActivity extends BaseActivity{

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    DetailPresenter presenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

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

        final Drawable upArrow = getResources().getDrawable(R.drawable.ic_arrow_back_white_24dp);
        upArrow.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        DetailFragment detailFragment = DetailFragment.getInstance();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.frame_detail_container, detailFragment);
        transaction.commit();

        presenter = new DetailPresenter(
                detailFragment
        );

        RecoResponse.Data data = new Gson().fromJson(getIntent().getStringExtra("data"), RecoResponse.Data.class);

        Log.d(TAG, "data : " + new Gson().toJson(data));
        detailFragment.updateData(data);
    }
}
