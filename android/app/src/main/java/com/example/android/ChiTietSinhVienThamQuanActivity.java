package com.example.android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ChiTietSinhVienThamQuanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chi_tiet_sinh_vien_tham_quan);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        RadioGroup rg=findViewById(R.id.rg);
        RadioButton rb1=findViewById(R.id.rb1);
        RadioButton rb2=findViewById(R.id.rb2);
        RadioButton rb3=findViewById(R.id.rb3);
        RadioButton rb4=findViewById(R.id.rb4);
        RadioButton rb5=findViewById(R.id.rb5);
        EditText edtMasv=findViewById(R.id.edtMaSv);
        EditText edtHoten=findViewById(R.id.edtHoten);
        EditText edtKhoa=findViewById(R.id.edtKhoa);
        Button btnHome=findViewById(R.id.btnHome);
        Button btnAccount=findViewById(R.id.btnAccount);
        Button btnSetting=findViewById(R.id.btnSetting);
        Intent intent=getIntent();
        String masv=intent.getStringExtra("maSv");
        String hoten=intent.getStringExtra("hoTen");
        String khoa=intent.getStringExtra("khoa");
        String danhgia=intent.getStringExtra("danhGia");
        if("1".equals(danhgia)){
            rb1.setChecked(true);
        }
        else if("2".equals(danhgia)){
            rb2.setChecked(true);
        }
        else if("3".equals(danhgia)){
            rb3.setChecked(true);
        }
        else if("4".equals(danhgia)){
            rb4.setChecked(true);
        }
        else{
            rb5.setChecked(true);
        }
        edtMasv.setText(masv);
        edtHoten.setText(hoten);
        edtKhoa.setText(khoa);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ChiTietSinhVienThamQuanActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });
        btnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ChiTietSinhVienThamQuanActivity.this,AccountActivity.class);
                startActivity(intent);
            }
        });
        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ChiTietSinhVienThamQuanActivity.this,SettingActivity.class);
                startActivity(intent);
            }
        });

    }
}