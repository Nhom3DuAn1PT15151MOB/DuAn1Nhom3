package com.example.baitest1;

import android.content.Intent;
import android.os.Bundle;

import com.example.baitest1.them.ThemKhoanChiActivity;
import com.example.baitest1.them.ThemKhoanThuActivity;
import com.example.baitest1.them.ThemLoaiChiActivity;
import com.example.baitest1.them.ThemLoaiThuActyvity;
import com.example.baitest1.fragment.fragmen_chi.FragmentDSKhoanChi;
import com.example.baitest1.fragment.fragmen_chi.FragmentDSLoaiChi;
import com.example.baitest1.fragment.fragment_thu.FragmentDSLoaiThu;
import com.example.baitest1.fragment.fragment_thu.FragmentDSKhoanThu;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.example.baitest1.sqlite.LoaiChiDAO;

import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    public EditText tenkt,tenlt,sotienthu,ngaythu;
    private LoaiChiDAO loaiChiDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loaiChiDAO = new LoaiChiDAO(this);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab_loaichi);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.home,
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                 R.id.nav_share, R.id.nav_send)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void addDataLoaiChi(View view) {
        Intent intent = new Intent(this, ThemLoaiChiActivity.class);
        startActivity(intent);
    }
    public void addDataKhoanChi(View view) {
        Intent intent = new Intent(this, ThemKhoanChiActivity.class);
        startActivity(intent);
    }
    public void addDataKhoanThu(View view) {
        Intent intent = new Intent(this, ThemKhoanThuActivity.class);
        startActivity(intent);
    }
    public void addDataLoaiThu(View view) {
        Intent intent = new Intent(this, ThemLoaiThuActyvity.class);
        startActivity(intent);
    }
    public void openkhoanthu(View view) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        Fragment fragment1 = new FragmentDSKhoanThu();
        fragmentTransaction.replace(R.id.framconten,fragment1);
        fragmentTransaction.addToBackStack("to back");
        fragmentTransaction.commit();
    }

    public void openloaithu(View view) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        Fragment fragment2 = new FragmentDSLoaiThu();
        fragmentTransaction.replace(R.id.framconten,fragment2);
        fragmentTransaction.addToBackStack("to back");
        fragmentTransaction.commit();
    }

    public void openkhoanchi(View view) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        Fragment khoanchi= new FragmentDSKhoanChi();
        fragmentTransaction.replace(R.id.showfragment,khoanchi);
        fragmentTransaction.addToBackStack("back");
        fragmentTransaction.commit();

    }
    public void openloaichi(View view) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        Fragment loaiChi= new FragmentDSLoaiChi();
        fragmentTransaction.replace(R.id.showfragment,loaiChi);
        fragmentTransaction.addToBackStack("back");
        fragmentTransaction.commit();
    }


}
