package com.example.baitest1.fragment.fragment_thu;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.baitest1.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDSKhoanThu extends Fragment {


    public FragmentDSKhoanThu() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.danh_sach_khoan_thu,container,false);
        return view;
    }

}
