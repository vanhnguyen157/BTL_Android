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

public class ThemThamQuanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_them_tham_quan);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        SQLiteDatabase mydatabase;
        mydatabase=openOrCreateDatabase("qlhd.db",MODE_PRIVATE,null);
        Button btnThem=findViewById(R.id.btnThem);
        EditText edtMaTQ=findViewById(R.id.edtMaHT);
        EditText edtTDN=findViewById(R.id.edtTenDN);
        EditText edtNHT=findViewById(R.id.edtDG);
        EditText edtNT=findViewById(R.id.edtNT);
        EditText edtTG=findViewById(R.id.edtTG);
        EditText edtPT=findViewById(R.id.edtDC);
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String maTq=edtMaTQ.getText().toString();
                String diaChi=edtTDN.getText().toString();
                String thoiGian=edtTG.getText().toString();
                String ngayThang=edtNT.getText().toString();
                String phuongTien=edtPT.getText().toString();
                String nguoiHt=edtNHT.getText().toString();
                ContentValues myvalue=new ContentValues();
                myvalue.put("maTq",maTq);
                myvalue.put("diaChi",diaChi);
                myvalue.put("thoiGian",thoiGian);
                myvalue.put("ngayThang",ngayThang);
                myvalue.put("phuongTien",phuongTien);
                myvalue.put("nguoiHt",nguoiHt);
                String msg="";
                if(mydatabase.insert("tbtq",null,myvalue)==-1){
                    msg="Them khong thanh cong";
                }
                else{
                    msg="Them thanh cong";
                }
                Toast.makeText(ThemThamQuanActivity.this,msg,Toast.LENGTH_SHORT).show();
            }
        });
        Button btnHome=findViewById(R.id.btnHome);
        Button btnAccount=findViewById(R.id.btnAccount);
        Button btnSetting=findViewById(R.id.btnSetting);
        Button btnBack=findViewById(R.id.btnBack);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ThemThamQuanActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });
        btnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ThemThamQuanActivity.this,AccountActivity.class);
                startActivity(intent);
            }
        });
        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ThemThamQuanActivity.this,SettingActivity.class);
                startActivity(intent);
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ThemThamQuanActivity.this,ThamQuanActivity.class);
                startActivity(intent);
            }
        });
    }
}