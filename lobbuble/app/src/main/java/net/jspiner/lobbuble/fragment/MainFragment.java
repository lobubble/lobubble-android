package net.jspiner.lobbuble.fragment;

import net.jspiner.lobbuble.contract.MainContract;
import net.jspiner.lobbuble.fragment.base.BaseFragment;
import net.jspiner.lobbuble.presenter.base.BasePresenter;

/**
 * Created by jspiner on 2017. 4. 29..
 */

public class MainFragment extends BaseFragment implements MainContract.View {

    public static MainFragment getInstance(){
        return new MainFragment();
    }

    @Override
    public void setPresenter(BasePresenter presenter) {

    }

    @Override
    public void showToast(String text) {

    }

}
