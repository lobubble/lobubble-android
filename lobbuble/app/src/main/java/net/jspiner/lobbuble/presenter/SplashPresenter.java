package net.jspiner.lobbuble.presenter;

import net.jspiner.lobbuble.contract.SplashContract;

/**
 * Created by jspiner on 2017. 4. 29..
 */

public class SplashPresenter implements SplashContract.Presenter {

    SplashContract.View splashView;

    public SplashPresenter(SplashContract.View splashView){
        this.splashView = splashView;

        splashView.setPresenter(this);
    }

    @Override
    public void start() {

    }


}
