package net.jspiner.lobbuble.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.jspiner.lobbuble.R;
import net.jspiner.lobbuble.adapter.MainRecyclerAdapter;
import net.jspiner.lobbuble.contract.MainContract;
import net.jspiner.lobbuble.fragment.base.BaseFragment;
import net.jspiner.lobbuble.model.FriendResponse;
import net.jspiner.lobbuble.presenter.MainPresenter;
import net.jspiner.lobbuble.presenter.base.BasePresenter;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by jspiner on 2017. 4. 29..
 */

public class MainFragment extends BaseFragment implements MainContract.View {

    @Bind(R.id.recycler_main_list)
    RecyclerView recyclerMainList;

    MainRecyclerAdapter recyclerAdapter;

    private MainContract.Presenter presenter;

    public static MainFragment getInstance(){
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);

        ButterKnife.bind(this, view);

        init();
        return view;
    }

    void init(){

        presenter.loadData();
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showToast(String text) {

    }

    @Override
    public void updateList(FriendResponse response) {
        recyclerAdapter = new MainRecyclerAdapter(getActivity(), response.data);

        recyclerMainList.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerMainList.setAdapter(recyclerAdapter);

    }
}
