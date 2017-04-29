package net.jspiner.lobbuble.contract;

import net.jspiner.lobbuble.contract.base.BaseView;
import net.jspiner.lobbuble.model.FriendResponse;
import net.jspiner.lobbuble.presenter.base.BasePresenter;

/**
 * Created by jspiner on 2017. 4. 29..
 */

public class MainContract {


    public interface View extends BaseView<Presenter>{

        void updateList(FriendResponse response);
    }

    public interface Presenter extends BasePresenter{
        void loadData();
    }
}
