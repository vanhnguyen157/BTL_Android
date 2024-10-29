package com.example.android;

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

public class XoaHoiThaoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_xoa_hoi_thao);
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
                Intent intent=new Intent(XoaHoiThaoActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });
        btnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(XoaHoiThaoActivity.this,AccountActivity.class);
                startActivity(intent);
            }
        });
        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(XoaHoiThaoActivity.this,SettingActivity.class);
                startActivity(intent);
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(XoaHoiThaoActivity.this,HoiThaoActivity.class);
                startActivity(intent);
            }
        });
        SQLiteDatabase mydatabase;
        mydatabase=openOrCreateDatabase("qlhd.db",MODE_PRIVATE,null);
        EditText edtMaCT=findViewById(R.id.edtTenDN);
        Button btnXoa=findViewById(R.id.btnThem);
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String maCt=edtMaCT.getText().toString();
                int n=mydatabase.delete("tbht","maHt=?",new String[]{maCt});
                String msg="";
                if(n==0){
                    msg="Không xóa thành công";
                }
                else{
                    msg="Xóa thành công";
                }
                Toast.makeText(XoaHoiThaoActivity.this,msg,Toast.LENGTH_SHORT).show();
            }
        });
    }
}