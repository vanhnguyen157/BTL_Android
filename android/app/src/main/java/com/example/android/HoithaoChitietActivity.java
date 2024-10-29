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

public class HoithaoChitietActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_hoithao_chitiet);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        TextView tvMact=findViewById(R.id.tvMact);
        TextView tvDiachi=findViewById(R.id.tvTendn);
        TextView tvThoigian=findViewById(R.id.tvNguoiht);
        TextView tvDiengia=findViewById(R.id.tvThoigian);
        TextView tvNgaythang=findViewById(R.id.tvNgaythang);
        TextView tvDoanhnghiep=findViewById(R.id.tvPtdc);

        Intent intent=getIntent();
        String maHt=intent.getStringExtra("maHt");
        String diaChi=intent.getStringExtra("diaChi");
        String thoiGian=intent.getStringExtra("thoiGian");
        String dienGia=intent.getStringExtra("dienGia");
        String ngaythang=intent.getStringExtra("ngayThang");
        String tendn=intent.getStringExtra("tenDN");

        tvMact.setText(maHt);
        tvNgaythang.setText(ngaythang);
        tvDoanhnghiep.setText(tendn);
        tvDiengia.setText(dienGia);
        tvDiachi.setText(diaChi);
        tvThoigian.setText(thoiGian);

        Button btnHome=findViewById(R.id.btnHome);
        Button btnAccount=findViewById(R.id.btnAccount);
        Button btnSetting=findViewById(R.id.btnSetting);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HoithaoChitietActivity.this,HomeUserActivity.class);
                startActivity(intent);
            }
        });
        btnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HoithaoChitietActivity.this,AccountActivity.class);
                startActivity(intent);
            }
        });
        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HoithaoChitietActivity.this,SettingActivity.class);
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
                Intent intent=new Intent(HoithaoChitietActivity.this,DanhgiaChitietActivity.class);
                startActivity(intent);
            }
        });

    }
    public void showLogin(){
        Toast.makeText(this, "Đăng Ký Thành Công", Toast.LENGTH_SHORT).show();

    }
}