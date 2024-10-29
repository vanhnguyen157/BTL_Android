package com.example.android;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android.HomeActivity;
import com.example.android.HomeUserActivity;

public class MainActivity extends AppCompatActivity {

    String DB_PATH_SUFFIX="/databases/";
    SQLiteDatabase database=null;
    String DATABASE_NAME="qlhd.db";
    private EditText edtTenDN, edtMatkhau;
    private Button btnDangNhap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtTenDN = findViewById(R.id.edtTenDN);
        edtMatkhau = findViewById(R.id.edtMatkhau);
        btnDangNhap = findViewById(R.id.btnDangNhap);

        // Open or create database
        database = openOrCreateDatabase("qlhd.db", MODE_PRIVATE, null);

        // Create table if not exists
        /*String createTable = "CREATE TABLE IF NOT EXISTS taikhoan (" +
                "tenTaiKhoan TEXT PRIMARY KEY, " +
                "matKhau TEXT, " +
                "role TEXT)";
        database.execSQL(createTable);

        // Insert sample data (you can remove this after initial run)
        String insertData = "INSERT OR IGNORE INTO taikhoan (tenTaiKhoan, matKhau, role) VALUES " +
                "('admin', 'admin123', 'admin'), " +
                "('user', 'user123', 'user')";
        database.execSQL(insertData);

         */

        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    private void login() {
        String username = edtTenDN.getText().toString();
        String password = edtMatkhau.getText().toString();

        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please enter both username and password", Toast.LENGTH_SHORT).show();
            return;
        }

        Cursor cursor = database.rawQuery("SELECT Role FROM tbtk WHERE TenTK=? AND Matkhau=?", new String[]{username, password});

        if (cursor.moveToFirst()) {
            String role = cursor.getString(0);
            Intent intent;
            if ("admin".equals(role)) {
                intent = new Intent(MainActivity.this, HomeActivity.class);
            } else {
                intent = new Intent(MainActivity.this, HomeUserActivity.class);
            }
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "Sai tài khoản mật khẩu", Toast.LENGTH_SHORT).show();
        }
        cursor.close();
    }
}