package net.jspiner.lobbuble.fragment;

import net.jspiner.lobbuble.contract.DetailContract;

/**
 * Created by jspiner on 2017. 4. 30..
 */

public class DetailFragment implements DetailContract.View {

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
}
