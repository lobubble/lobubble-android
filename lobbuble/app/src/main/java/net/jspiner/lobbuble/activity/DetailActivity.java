package net.jspiner.lobbuble.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;

import net.jspiner.lobbuble.R;
import net.jspiner.lobbuble.activity.base.BaseActivity;
import net.jspiner.lobbuble.fragment.DetailFragment;
import net.jspiner.lobbuble.fragment.MainFragment;
import net.jspiner.lobbuble.presenter.DetailPresenter;
import net.jspiner.lobbuble.presenter.MainPresenter;

/**
 * Created by jspiner on 2017. 4. 30..
 */

public class DetailActivity extends BaseActivity{

    DetailPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    void init(){

        DetailFragment detailFragment = DetailFragment.getInstance();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.frame_main_container, detailFragment);
        transaction.commit();

        presenter = new MainPresenter(
                detailFragment
        );
    }
}
