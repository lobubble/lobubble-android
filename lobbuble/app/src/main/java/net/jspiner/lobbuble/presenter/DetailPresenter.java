package net.jspiner.lobbuble.presenter;

import net.jspiner.lobbuble.contract.DetailContract;

/**
 * Created by jspiner on 2017. 4. 30..
 */

public class DetailPresenter implements DetailContract.Presenter{

    private DetailContract.View detailView;

    public DetailPresenter(DetailContract.View detailView){
        this.detailView = detailView;
    }

}
