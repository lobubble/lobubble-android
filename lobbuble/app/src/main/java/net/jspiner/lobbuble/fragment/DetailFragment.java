package net.jspiner.lobbuble.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;

import net.jspiner.lobbuble.R;
import net.jspiner.lobbuble.Util;
import net.jspiner.lobbuble.adapter.DetailPagerAdapter;
import net.jspiner.lobbuble.contract.DetailContract;
import net.jspiner.lobbuble.fragment.base.BaseFragment;
import net.jspiner.lobbuble.model.ImageResponse;
import net.jspiner.lobbuble.model.RecoResponse;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by jspiner on 2017. 4. 30..
 */

public class DetailFragment extends BaseFragment implements DetailContract.View {

    @Bind(R.id.pager_detail_profile)
    ViewPager pagerDetailProfile;

    @Bind(R.id.tv_detail_name)
    TextView tvName;

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


        Util.getService().getCustomImage(data.target_id).enqueue(new Callback<ImageResponse.Data[]>() {
            @Override
            public void onResponse(Call<ImageResponse.Data[]> call, Response<ImageResponse.Data[]> response) {
                ImageResponse.Data[] datas = response.body();

                Log.d(TAG, "datas : " + new Gson().toJson(datas));

                tvName.setText(data.name);

                pagerAdapter = new DetailPagerAdapter(getContext(), LayoutInflater.from(getContext()), data.picture, datas);

                pagerDetailProfile.setAdapter(pagerAdapter);

                pagerDetailProfile.setClipToPadding(false);
                pagerDetailProfile.setPageMargin(120);
                pagerDetailProfile.setPadding(160,0,160,0);


            }

            @Override
            public void onFailure(Call<ImageResponse.Data[]> call, Throwable t) {

            }
        });
    }

    RecoResponse.Data data;
    @Override
    public void updateData(RecoResponse.Data data) {

        this.data = data;
    }
}
