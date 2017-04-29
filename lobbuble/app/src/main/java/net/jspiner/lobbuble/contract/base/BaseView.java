package net.jspiner.lobbuble.contract.base;

/**
 * Created by jspiner on 2017. 4. 29..
 */

public interface BaseView<T> {

    void setPresenter(T presenter);

    void showToast(String text);
}
