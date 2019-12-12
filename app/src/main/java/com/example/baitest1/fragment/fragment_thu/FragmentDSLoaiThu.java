package com.example.baitest1.fragment.fragment_thu;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.baitest1.R;
import com.example.baitest1.model.LoaiThu;
import com.example.baitest1.sqlite.LoaiThuDAO;

import java.util.List;

public class FragmentDSLoaiThu extends Fragment {
    private LoaiThuDAO loaiThuDAO;
    private List<LoaiThu> loaiThuList;
    private ArrayAdapter<LoaiThu> adapter;
    public FragmentDSLoaiThu() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.danh_sach_loai_thu, container, false);
        ListView listView = view.findViewById(R.id.lv_loaiThu);
        loaiThuDAO = new LoaiThuDAO(getActivity());
        loaiThuList = loaiThuDAO.showLoaiThu();
        adapter = new ArrayAdapter<LoaiThu>(getActivity(),android.R.layout.simple_list_item_1,loaiThuList);
        listView.setAdapter(adapter);
        return view;
    }

}
