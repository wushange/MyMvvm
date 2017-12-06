package com.connxun.morui.viewmodel.helper;

import android.databinding.ObservableBoolean;

public class PagedViewModel extends BaseViewModel {

    private final ObservableBoolean loading = state.loading;

    private final ObservableBoolean loadMore = state.loadMore;
    private final ObservableBoolean empty    = state.empty;
    private int page;

    public final ObservableBoolean getLoading() {
        return this.loading;
    }

    public final ObservableBoolean getLoadMore() {
        return this.loadMore;
    }

    public final ObservableBoolean getEmpty() {
        return this.empty;
    }

    public final int getPage() {
        return this.page;
    }

    public final void setPage(int var1) {
        this.page = var1;
    }

    public final int getPage(boolean isRefresh) {
        if (isRefresh) {
            page = 0;
        } else {
            page++;
        }

        return page;
    }

    public final void startLoad() {
        this.loading.set(true);
    }

    public final void stopLoad() {
        this.loading.set(false);
    }

    public final void showEmpty(int type) {
        state.showEmpty(type);
    }

    public final void hideEmpty() {
        state.hideEmpty();
    }
}
