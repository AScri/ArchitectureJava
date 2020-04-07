package com.ascri.architecturetest.ui.helpers;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public abstract class PagingListener extends RecyclerView.OnScrollListener {
    private RecyclerView.Adapter<?> adapter;
    private Boolean enabled = true;
    private Integer size = 0;
    private Boolean paused = false;

    public void attach(RecyclerView recyclerView) {
        recyclerView.addOnScrollListener(this);
        adapter = recyclerView.getAdapter();
    }

    public void detach(RecyclerView recyclerView) {
        recyclerView.removeOnScrollListener(this);
        adapter = null;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getPaused() {
        return paused;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public void setPaused(Boolean paused) {
        this.paused = paused;
    }

    @Override
    public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
        if (enabled && !paused) {
            LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            size = adapter.getItemCount();
            int last = layoutManager != null ? layoutManager.findLastVisibleItemPosition() : 0;
            if (last == size - 1) {
                lastItemVisible();
            }
        }
    }

    protected abstract void lastItemVisible();
}
