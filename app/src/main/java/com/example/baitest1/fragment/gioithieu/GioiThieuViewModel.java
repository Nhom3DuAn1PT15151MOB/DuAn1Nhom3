package com.example.baitest1.fragment.gioithieu;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GioiThieuViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public GioiThieuViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("");
    }

    public LiveData<String> getText() {
        return mText;
    }
}