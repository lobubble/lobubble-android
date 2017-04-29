package net.jspiner.lobbuble.presenter;

import net.jspiner.lobbuble.Prefer;
import net.jspiner.lobbuble.Util;
import net.jspiner.lobbuble.contract.MainContract;
import net.jspiner.lobbuble.contract.SplashContract;
import net.jspiner.lobbuble.model.FriendResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by jspiner on 2017. 4. 29..
 */

public class MainPresenter implements MainContract.Presenter{

    private MainContract.View mainView;

    public MainPresenter(MainContract.View mainView){
        this.mainView = mainView;

        mainView.setPresenter(this);
    }

    @Override
    public void loadData() {
        Util.getService().getFriendList(Prefer.get("accessToken", "")).enqueue(new Callback<FriendResponse>() {
            @Override
            public void onResponse(Call<FriendResponse> call, Response<FriendResponse> response) {
                FriendResponse body = response.body();

                mainView.updateList(body);
            }

            @Override
            public void onFailure(Call<FriendResponse> call, Throwable t) {
                mainView.showToast("에러가 발생했습니다.");
            }
        });
    }
}
