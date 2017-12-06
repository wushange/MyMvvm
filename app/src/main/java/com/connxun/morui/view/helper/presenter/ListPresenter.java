package com.connxun.morui.view.helper.presenter;

import android.view.View;

import com.connxun.morui.viewmodel.helper.StateModel;

public interface ListPresenter extends Presenter {
    StateModel getState();

    void loadData(boolean var1);

    void onClick(View var1);
}
