package com.example.quanlykhogao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LogInActivity extends AppCompatActivity  {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    EditText edUserName, edPassword;
    CheckBox chkRememberPass;
    String stU, stP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Đăng nhập");
        setContentView(R.layout.activity_log_in);
        edPassword = findViewById(R.id.edPasswordLogin);
        edUserName = findViewById(R.id.edUserNameLogin);
        chkRememberPass = findViewById(R.id.checkbox);
        initPreFerences();
        String data = sharedPreferences.getString("DATA", "");
        edUserName.setText("0333049379");
        String data2 = sharedPreferences.getString("DATA2", "");
        edPassword.setText("admin");
    }
public boolean check(){
        if (chkRememberPass.isSelected())
            return true;
        return false;
}
    public void btnLogIn(View view) {
        stU = edUserName.getText().toString();
        stP = edPassword.getText().toString();
        if (check()==true) {
            String data = edUserName.getText().toString();
            String data2 = edPassword.getText().toString();
            editor.putString("DATA", data);
            editor.putString("DATA2", data2);
            editor.commit();
        }
            else {
                editor.clear();
                editor.commit();
            }
        if (stU.isEmpty() || stP.isEmpty()) {
            Toast.makeText(this, "Khong duoc de trong", Toast.LENGTH_LONG).show();
        } else {
            if (checkLogin(stU, stP) > 0) {
                Toast.makeText(this, "Login thanh cong", Toast.LENGTH_LONG).show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(LogInActivity.this, MainActivity.class));
                    }
                }, 1000);
            } else {
                Toast.makeText(this, "Sai thong tin dang nhap", Toast.LENGTH_LONG).show();

            }
        }
    }

    public int checkLogin(String u, String p) {

        if (u.equals("0333049379") && p.equals("admin")) {
            return 1;
        } else {
            return -1;
        }
    }

    public void initPreFerences() {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor = sharedPreferences.edit();
    }

    public void quenPass(View view) {
        Intent intent = new Intent(LogInActivity.this, QuenPassActivity.class);
        startActivity(intent);
    }

    public void btnDangKy(View view) {
        Intent intent = new Intent(this, NguoiDungActivity.class);
        startActivity(intent);
    }
}
