package net.jspiner.lobbuble.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.jspiner.lobbuble.R;
import net.jspiner.lobbuble.contract.SplashContract;
import net.jspiner.lobbuble.fragment.base.BaseFragment;

/**
 * Created by jspiner on 2017. 4. 29..
 */

public class SplashFragment extends BaseFragment implements SplashContract.View{

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

        return view;
    }
}
