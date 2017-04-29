package net.jspiner.lobbuble.presenter;

import net.jspiner.lobbuble.contract.MainContract;
import net.jspiner.lobbuble.contract.SplashContract;

/**
 * Created by jspiner on 2017. 4. 29..
 */

public class MainPresenter implements MainContract.Presenter{

    MainContract.View mainView;

    public MainPresenter(MainContract.View splashView){
        this.mainView = mainView;

        splashView.setPresenter(this);
    }
}
