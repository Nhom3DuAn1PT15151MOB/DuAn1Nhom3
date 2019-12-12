package com.example.baitest1.fragment.fragmen_chi;


import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

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
import android.widget.TextView;
import android.widget.Toast;

import com.example.baitest1.R;
import com.example.baitest1.model.KhoanChi;
import com.example.baitest1.model.LoaiChi;
import com.example.baitest1.sqlite.KhoanChiDAO;
import com.example.baitest1.sqlite.LoaiChiDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDSKhoanChi extends Fragment {
    public EditText hienthi1;
    EditText editTenKC;
    EditText editSotien;
    EditText editNgay;
    KhoanChiDAO khoanChiDAO;
    private ListView lvKhoanChi;
    private List<KhoanChi> khoanChis;
    private ArrayAdapter<KhoanChi> khoanChiArrayAdapter;
    private int index1;

    public FragmentDSKhoanChi() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.danh_sach_khoan_chi, container, false);
        lvKhoanChi = view.findViewById(R.id.lv_khoanchi);
        hienthi1 = view.findViewById(R.id.hienthi_1);
        khoanChis = new ArrayList<>();
        final KhoanChiDAO khoanChiDAO = new KhoanChiDAO(getActivity());
        khoanChis = khoanChiDAO.showListKC();
        khoanChiArrayAdapter = new ArrayAdapter<KhoanChi>(getActivity(), android.R.layout.simple_list_item_1, khoanChis);
        lvKhoanChi.setAdapter(khoanChiArrayAdapter);
        khoanChiArrayAdapter.notifyDataSetChanged();

        lvKhoanChi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                index1 = position;
                String maKhoanChi = String.valueOf(khoanChis.get(index1).getMaKC());
                hienthi1.setText(maKhoanChi);
                final String chuoi1 = hienthi1.getText().toString();
                Toast.makeText(getActivity(), "" + maKhoanChi, Toast.LENGTH_SHORT).show();

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setMessage("Bạn muốn làm gì ?");
                builder.setCancelable(false);

                builder.setNeutralButton("Sửa", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Dialog dialog1 = new Dialog(getActivity());
                        dialog1.setTitle("Sửa tên loại chi");
                        dialog1.setContentView(R.layout.activity_sua_khoan_chi);
                        dialog1.show();
                        Button button = dialog1.findViewById(R.id.suakhoanchi);
                        editTenKC = dialog1.findViewById(R.id.id_suatenkhoanchi);
                        editSotien = dialog1.findViewById(R.id.id_suasoTien);
                        editNgay = dialog1.findViewById(R.id.id_suangayChi);
                        button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String tkc = editTenKC.getText().toString();
                                String sST = editSotien.getText().toString();
                                String sNC = editNgay.getText().toString();
                                KhoanChi khoanChi = new KhoanChi(tkc, sST, sNC);
                                boolean suakc = khoanChiDAO.suaKhoanChi(chuoi1, khoanChi);
                                if (suakc) {
                                    Toast.makeText(getActivity(), "Sửa khoản chi thành công", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(getActivity(), "Không thành công", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
//                        Intent intent = new Intent(getActivity(), SuaKhoanChiActivity.class);
//                        startActivity(intent);
                        Toast.makeText(getActivity(), "Chuyển đến giao diện chỉnh sửa.", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("Xóa", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        boolean xoa1 = khoanChiDAO.xoaKhoanChi(chuoi1);
                        if (xoa1) {
                            khoanChis.remove(index1);
                            Toast.makeText(getActivity(), "Đã xóa thành công", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getActivity(), "Không thành công", Toast.LENGTH_SHORT).show();
                        }
                        khoanChiArrayAdapter.notifyDataSetChanged();
                    }
                });
                builder.setPositiveButton("Thoát", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        //Thoat
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
        return view;
    }

}
