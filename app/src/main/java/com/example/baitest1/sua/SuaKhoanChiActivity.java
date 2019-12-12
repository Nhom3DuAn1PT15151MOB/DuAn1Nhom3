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
//import com.example.baitest1.model.KhoanChi;
//import com.example.baitest1.sqlite.KhoanChiDAO;
//
//public class SuaKhoanChiActivity extends AppCompatActivity {
//    EditText editTenKC;
//    EditText editSotien;
//    EditText editNgay;
//    KhoanChiDAO khoanChiDAO;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_sua_khoan_chi);
//        editTenKC = findViewById(R.id.id_suatenkhoanchi);
//        editSotien = findViewById(R.id.id_suasoTien);
//        editNgay = findViewById(R.id.id_suangayChi);
//        khoanChiDAO = new KhoanChiDAO(this);
//    }
//
//    public void suaKhoanChi(View view) {
//        String sTKC = editTenKC.getText().toString();
//        String sST = editSotien.getText().toString();
//        String sNC = editNgay.getText().toString();
//        KhoanChi khoanChi = new KhoanChi(sTKC, sST, sNC);
//        boolean suakc = khoanChiDAO.suaKhoanChi(khoanChi);
//        if (suakc) {
//            Toast.makeText(this, "Sửa khoản chi thành công", Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(this, "Không sửa được", Toast.LENGTH_SHORT).show();
//        }
//    }
//}
