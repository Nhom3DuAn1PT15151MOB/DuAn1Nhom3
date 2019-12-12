//package com.example.baitest1.sua;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//import android.view.View;
//import android.widget.EditText;
//import android.widget.Toast;
//
//import com.example.baitest1.R;
//import com.example.baitest1.fragment.fragmen_chi.FragmentDSLoaiChi;
//import com.example.baitest1.model.LoaiChi;
//import com.example.baitest1.sqlite.LoaiChiDAO;
//
//public class SuaLoaiChiActivity extends AppCompatActivity {
//    EditText editTenLC;
//    LoaiChiDAO loaiChiDAO;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_sua_loai_chi);
//        editTenLC = findViewById(R.id.suaTenloaichi);
//        loaiChiDAO = new LoaiChiDAO(this);
//    }
//
//    public void btnSuaLoaiChi(View view) {
//        FragmentDSLoaiChi dsLoaiChi = new FragmentDSLoaiChi();
//        String dkk = dsLoaiChi.chuoi;
//        String tlc = editTenLC.getText().toString();
//        LoaiChi loaiChi = new LoaiChi(tlc);
//        boolean suaLC = loaiChiDAO.suaLoaiChi(dkk);
//        if (suaLC) {
//            Toast.makeText(this, "Sửa loại chi thành công", Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(this, "không sủa được", Toast.LENGTH_SHORT).show();
//        }
//    }
//}
