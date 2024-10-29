package com.example.android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ThamquanChitietActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_thamquan_chitiet);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView tvMact=findViewById(R.id.tvMact);
        TextView tvTendn=findViewById(R.id.tvTendn);
        TextView tvNguoiht=findViewById(R.id.tvNguoiht);
        TextView tvThoigian=findViewById(R.id.tvThoigian);
        TextView tvNgaythang=findViewById(R.id.tvNgaythang);
        TextView tvPtdc=findViewById(R.id.tvPtdc);

        Intent intent=getIntent();
        String matq=intent.getStringExtra("maTq");
        String tendn=intent.getStringExtra("diaChi");
        String nguoiht=intent.getStringExtra("nguoiHt");
        String thoigian=intent.getStringExtra("thoiGian");
        String ngaythang=intent.getStringExtra("ngayThang");
        String ptdc=intent.getStringExtra("phuongTien");

        tvMact.setText(matq);
        tvNgaythang.setText(ngaythang);
        tvTendn.setText(tendn);
        tvNguoiht.setText(nguoiht);
        tvPtdc.setText(ptdc);
        tvThoigian.setText(thoigian);

        Button btnHome=findViewById(R.id.btnHome);
        Button btnAccount=findViewById(R.id.btnAccount);
        Button btnSetting=findViewById(R.id.btnSetting);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ThamquanChitietActivity.this,HomeUserActivity.class);
                startActivity(intent);
            }
        });
        btnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ThamquanChitietActivity.this,AccountActivity.class);
                startActivity(intent);
            }
        });
        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ThamquanChitietActivity.this,SettingActivity.class);
                startActivity(intent);
            }
        });
        Button btnDangKy = findViewById(R.id.btnDangKy);
        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLogin();
            }
        });

        Button btnDanhGia = findViewById(R.id.btnDanhGia);
        btnDanhGia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ThamquanChitietActivity.this,DanhgiaChitietActivity.class);
                startActivity(intent);
            }
        });
    }
    public void showLogin(){
        Toast.makeText(this, "Đăng Ký Thành Công", Toast.LENGTH_SHORT).show();

    }

}