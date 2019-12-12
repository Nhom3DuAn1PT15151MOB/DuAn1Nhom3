package com.example.baitest1.fragment.ThongKe;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ShowFragmentThongKe extends ViewModel {

    private MutableLiveData<String> mText;

    public ShowFragmentThongKe() {
        mText = new MutableLiveData<>();
        mText.setValue("no data");
    }

    public LiveData<String> getText() {
        return mText;
    }
}