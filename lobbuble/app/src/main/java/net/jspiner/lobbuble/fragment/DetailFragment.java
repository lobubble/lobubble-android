package net.jspiner.lobbuble.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.jspiner.lobbuble.R;
import net.jspiner.lobbuble.adapter.DetailPagerAdapter;
import net.jspiner.lobbuble.contract.DetailContract;
import net.jspiner.lobbuble.fragment.base.BaseFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by jspiner on 2017. 4. 30..
 */

public class DetailFragment extends BaseFragment implements DetailContract.View {

    @Bind(R.id.pager_detail_profile)
    ViewPager pagerDetailProfile;

    DetailPagerAdapter pagerAdapter;

    DetailContract.Presenter presenter;

    public static DetailFragment getInstance(){
        return new DetailFragment();
    }

    @Override
    public void setPresenter(DetailContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showToast(String text) {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        ButterKnife.bind(this, view);

        init();
        return view;
    }

    void init(){

        pagerAdapter = new DetailPagerAdapter(getContext(), LayoutInflater.from(getContext()));

        pagerDetailProfile.setAdapter(pagerAdapter);

        pagerDetailProfile.setClipToPadding(false);
        pagerDetailProfile.setPageMargin(120);
        pagerDetailProfile.setPadding(160,0,160,0);
    }
}
