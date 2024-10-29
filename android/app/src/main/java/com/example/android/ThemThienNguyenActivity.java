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

public class ThemThienNguyenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_them_thien_nguyen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button btnHome=findViewById(R.id.btnHome);
        Button btnAccount=findViewById(R.id.btnAccount);
        Button btnSetting=findViewById(R.id.btnSetting);
        Button btnBack=findViewById(R.id.btnBack);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ThemThienNguyenActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });
        btnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ThemThienNguyenActivity.this,AccountActivity.class);
                startActivity(intent);
            }
        });
        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ThemThienNguyenActivity.this,SettingActivity.class);
                startActivity(intent);
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ThemThienNguyenActivity.this,ThienNguyenActivity.class);
                startActivity(intent);
            }
        });
        SQLiteDatabase mydatabase;
        mydatabase=openOrCreateDatabase("qlhd.db",MODE_PRIVATE,null);
        Button btnThem=findViewById(R.id.btnThem);
        EditText edtMaTN=findViewById(R.id.edtMaHT);
        EditText edtTenTN=findViewById(R.id.edtTenDN);
        EditText edtDiaChi=findViewById(R.id.edtDG);
        EditText edtNT=findViewById(R.id.edtNT);
        EditText edtTG=findViewById(R.id.edtTG);
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String maTn=edtMaTN.getText().toString();
                String tenTn=edtTenTN.getText().toString();
                String diaChi=edtDiaChi.getText().toString();
                String thoiGian=edtTG.getText().toString();
                String ngayThang=edtNT.getText().toString();
                ContentValues myvalue=new ContentValues();
                myvalue.put("maTn",maTn);
                myvalue.put("tenTn",tenTn);
                myvalue.put("thoiGian",thoiGian);
                myvalue.put("ngayThang",ngayThang);
                myvalue.put("diaChi",diaChi);
                String msg="";
                if(mydatabase.insert("tbtn",null,myvalue)==-1){
                    msg="Them khong thanh cong";
                }
                else{
                    msg="Them thanh cong";
                }
                Toast.makeText(ThemThienNguyenActivity.this,msg,Toast.LENGTH_SHORT).show();
            }
        });
    }
}