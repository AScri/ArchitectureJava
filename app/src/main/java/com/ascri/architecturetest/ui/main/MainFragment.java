package com.ascri.architecturetest.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.ascri.architecturetest.R;
import com.ascri.architecturetest.ui.adapters.ImageBaseAdapter2;
import com.ascri.architecturetest.ui.base.BaseFragment;
import com.ascri.architecturetest.ui.helpers.PagingListener;
import com.ascri.architecturetest.utils.extensions.StubGenerator;

public class MainFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {
    public static final String TAG = "MAIN_FRAGMENT";
    private MainViewModel viewModel;
    private LinearLayoutManager linearLayoutManager;
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView rvImages;
    private ImageBaseAdapter2 adapter;

    private ScrollListener pagingListener = new ScrollListener();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment, container, false);
        swipeRefreshLayout = view.findViewById(R.id.refreshLayout);
        rvImages = view.findViewById(R.id.rvImages);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
        viewModel = new ViewModelProvider(this, viewModelFactory).get(MainViewModel.class);
        subscribeLiveData();
        viewModel.fetchNextUsers();
    }

    private void init() {
        swipeRefreshLayout.setOnRefreshListener(this);
        adapter = new ImageBaseAdapter2(requireContext());
        linearLayoutManager = new LinearLayoutManager(getContext());
        rvImages.setLayoutManager(linearLayoutManager);
        rvImages.setAdapter(adapter);
        pagingListener.attach(rvImages);
    }

    private void subscribeLiveData() {
        viewModel.getIsLoading().observe(getViewLifecycleOwner(), aBoolean -> swipeRefreshLayout.setRefreshing(aBoolean));
        viewModel.getLiveData().observe(getViewLifecycleOwner(), imageResponse -> {
            adapter.setData(StubGenerator.getUsers());
            pagingListener.setPaused(false);
        });
    }

    @Override
    public void onRefresh() {
        adapter.clear();
        viewModel.refresh();
    }


    private class ScrollListener extends PagingListener {
        private Integer page = 10;

        @Override
        protected void lastItemVisible() {
            page += 10;
            pagingListener.setPaused(true);
            viewModel.fetchNextUsers();
        }
    }
}
