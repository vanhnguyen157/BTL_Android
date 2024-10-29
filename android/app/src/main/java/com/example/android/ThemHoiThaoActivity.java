package com.example.android;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ThemHoiThaoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_them_hoi_thao);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        SQLiteDatabase mydatabase;
        mydatabase=openOrCreateDatabase("qlhd.db",MODE_PRIVATE,null);
        Button btnThem=findViewById(R.id.btnThem);
        EditText edtMact=findViewById(R.id.edtMaHT);
        EditText edtTenDN=findViewById(R.id.edtTenDN);
        EditText edtDienGia=findViewById(R.id.edtDG);
        EditText edtNgayThang=findViewById(R.id.edtNT);
        EditText edtThoiGian=findViewById(R.id.edtTG);
        EditText edtDiaDiem=findViewById(R.id.edtDC);
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String maHt=edtMact.getText().toString();
                String diaChi=edtDiaDiem.getText().toString();
                String thoiGian=edtThoiGian.getText().toString();
                String ngayThang=edtNgayThang.getText().toString();
                String dienGia=edtDienGia.getText().toString();
                String tenDN=edtTenDN.getText().toString();
                ContentValues myvalue=new ContentValues();
                myvalue.put("maHt",maHt);
                myvalue.put("diaChi",diaChi);
                myvalue.put("thoiGian",thoiGian);
                myvalue.put("ngayThang",ngayThang);
                myvalue.put("dienGia",dienGia);
                myvalue.put("tenDN",tenDN);
                String msg="";
                if(mydatabase.insert("tbht",null,myvalue)==-1){
                    msg="Them khong thanh cong";
                }
                else{
                    msg="Them thanh cong";
                }
                Toast.makeText(ThemHoiThaoActivity.this,msg,Toast.LENGTH_SHORT).show();
            }
        });
        Button btnHome=findViewById(R.id.btnHome);
        Button btnAccount=findViewById(R.id.btnAccount);
        Button btnSetting=findViewById(R.id.btnSetting);
        Button btnBack=findViewById(R.id.btnBack);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ThemHoiThaoActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });
        btnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ThemHoiThaoActivity.this,AccountActivity.class);
                startActivity(intent);
            }
        });
        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ThemHoiThaoActivity.this,SettingActivity.class);
                startActivity(intent);
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ThemHoiThaoActivity.this,HoiThaoActivity.class);
                startActivity(intent);
            }
        });
    }
}