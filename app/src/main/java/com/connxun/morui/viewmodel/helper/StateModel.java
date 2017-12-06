package com.connxun.morui.viewmodel.helper;

import android.app.Application;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableBoolean;

import com.connxun.morui.MyApplication;
import com.connxun.morui.R;

public final class StateModel extends BaseObservable {
    Application       app      = MyApplication.getInstance();
    ObservableBoolean loading  = new ObservableBoolean(false);
    ObservableBoolean loadMore = new ObservableBoolean(false);
    ObservableBoolean empty    = new ObservableBoolean(false);
    int emptyState;

    public final Application getApp() {
        return app;
    }

    public final ObservableBoolean getLoading() {
        return loading;
    }

    public final ObservableBoolean getLoadMore() {
        return loadMore;
    }

    public final ObservableBoolean getEmpty() {
        return empty;
    }

    public final boolean canLoadMore() {
        return loadMore.get() && !loading.get();
    }

    @Bindable
    public final int getEmptyState() {
        return emptyState;
    }

    public final void setEmptyState(int value) {
        emptyState = value;
        notifyPropertyChanged(4);
    }

    public final void showEmpty(int emptyType) {
        if (!empty.get()) {
            empty.set(true);
        }
    }

    public final void hideEmpty() {
        if (empty.get()) {
            empty.set(false);
        }

    }

    @Bindable
    public final String getCurrentStateLabel() {
        int resId = R.string.no_data;
        return app.getString(resId);
    }

}