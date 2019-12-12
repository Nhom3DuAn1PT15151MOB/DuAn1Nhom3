package com.example.baitest1.fragment.fragmen_chi;


import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.baitest1.R;
import com.example.baitest1.sqlite.LoaiChiDAO;
import com.example.baitest1.model.LoaiChi;

import java.util.ArrayList;
import java.util.List;

public class FragmentDSLoaiChi extends Fragment {
    private EditText hienthi;
    private ListView lv;
    private List<LoaiChi> loaiChis = new ArrayList<>();
    private ArrayAdapter<LoaiChi> adapter;
    public int index;
    public  String chuoi;
    public FragmentDSLoaiChi() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.loai_chi, container, false);

        lv = view.findViewById(R.id.lv_loaichi);
        hienthi = view.findViewById(R.id.id_hienthi);
        final LoaiChiDAO loaiChiDAO = new LoaiChiDAO(getActivity());
        loaiChis = loaiChiDAO.showListLC();
        adapter = new ArrayAdapter<LoaiChi>(getActivity(), android.R.layout.simple_list_item_1, loaiChis);
        adapter.notifyDataSetChanged();
        lv.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                index = position;
                hienthi.setText(String.valueOf(loaiChis.get(index).getmaLoaiChi()));
                final String chuoi = hienthi.getText().toString();

                Toast.makeText(getActivity(), "" + index, Toast.LENGTH_SHORT).show();

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setMessage("Bạn muốn làm gì ?");
                builder.setCancelable(false);

                builder.setNeutralButton("Sửa", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Dialog dialog1 = new Dialog(getActivity());
                        dialog1.setTitle("Sửa tên loại chi");
                        dialog1.setContentView(R.layout.activity_sua_loai_chi);
                        dialog1.show();
                        final EditText editTenLC;
                        final LoaiChiDAO loaiChiDAO = new LoaiChiDAO(getActivity());
                        Button button = dialog1.findViewById(R.id.onclicksua);
                        editTenLC = dialog1.findViewById(R.id.suaTenloaichi);
                        button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String tlc = editTenLC.getText().toString();
                                LoaiChi loaiChi = new LoaiChi(tlc);
                                boolean suaLC = loaiChiDAO.suaLoaiChi(chuoi,loaiChi);
                                if (suaLC) {
                                    Toast.makeText(getActivity(), "Sửa loại chi thành công", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(getActivity(), "không sủa được", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

//                        Intent intent = new Intent(getActivity(), SuaLoaiChiActivity.class);
//                        startActivity(intent);
                        Toast.makeText(getActivity(), "Chuyển đến giao diện chỉnh sửa.", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("Xóa", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        boolean xoa = loaiChiDAO.deleteLoaichi(chuoi);
                        if (xoa) {
                            loaiChis.remove(position);
                            Toast.makeText(getActivity(), "Đã xóa thành công", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getActivity(), "Không thành công", Toast.LENGTH_SHORT).show();
                        }
                        adapter.notifyDataSetChanged();
                    }
                });
                builder.setPositiveButton("Thoát", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        //ko làm j
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
        return view;
    }

}
