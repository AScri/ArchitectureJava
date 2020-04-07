package com.ascri.architecturetest.ui.main;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ascri.architecturetest.data.models.ImageResponse;
import com.ascri.architecturetest.data.models.Repository;
import com.ascri.architecturetest.data.repositories.ImageRepository;
import com.ascri.architecturetest.ui.base.BaseViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import static com.ascri.architecturetest.ui.main.MainFragment.TAG;

public class MainViewModel extends BaseViewModel {
    private ImageRepository imageRepository;
    private MutableLiveData<ImageResponse> liveData = new MutableLiveData<>();
    private MutableLiveData<Boolean> isLoading = new MutableLiveData<>(false);
    private Integer page = 0;

    @Inject
    MainViewModel(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    LiveData<ImageResponse> getLiveData() {
        return liveData;
    }

    LiveData<Boolean> getIsLoading() {
        return isLoading;
    }

    void fetchNextUsers() {
        isLoading.setValue(true);
        compositeDisposable.add(imageRepository.getRestAPI()
                .listRepos("AScri")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(repositories -> {
                    Log.d(TAG, "fetchRepos: " + repositories.toString());
                }, throwable -> {
                    Log.d(TAG, "fetchRepos: " + throwable.toString());
                })
        );
        liveData.setValue(new ImageResponse());
        page++;
        isLoading.setValue(false);
    }

    void refresh() {
        page = 0;
        fetchNextUsers();
    }
}
