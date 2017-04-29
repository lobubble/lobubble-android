package net.jspiner.lobbuble.contract;

import net.jspiner.lobbuble.contract.base.BaseView;
import net.jspiner.lobbuble.model.RecoResponse;
import net.jspiner.lobbuble.presenter.base.BasePresenter;

/**
 * Created by jspiner on 2017. 4. 30..
 */

public class DetailContract {

    public interface View extends BaseView<Presenter>{
        void updateData(RecoResponse.Data data);
    }

    public interface Presenter extends BasePresenter{

    }
}
