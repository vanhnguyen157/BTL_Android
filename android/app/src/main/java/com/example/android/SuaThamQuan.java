package com.example.android;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class SuaThamQuan extends AppCompatActivity {
    String DB_PATH_SUFFIX="/databases/";
    SQLiteDatabase database=null;
    String DATABASE_NAME="qlhd.db";
    ListView lv;
    ArrayList<String> mylist;
    ArrayAdapter<String> myadapter;
    ArrayList<ThamQuan> thamQuanList;
    ArrayAdapter<ThamQuan> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sua_tham_quan);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        lv=findViewById(R.id.lv);
        mylist=new ArrayList<>();
        myadapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,mylist);
        lv.setAdapter(myadapter);
        processCopy();
        database=openOrCreateDatabase("qlhd.db",MODE_PRIVATE,null);
        Cursor c=database.query("tbtq",null,null,null,null,null,null,null);
        String data="";
        c.moveToFirst();
        while(c.isAfterLast()==false){
            data=c.getString(0)+"\n"+c.getString(1)+"\n"+c.getString(2)+"\n"+c.getString(3)+"\n"+c.getString(4)+"\n"+c.getString(5);
            mylist.add(data);
            c.moveToNext();
        }
        c.close();
        myadapter.notifyDataSetChanged();
        thamQuanList=new ArrayList<>();
        adapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,thamQuanList);

        loadDataFromDatabase();
        EditText edtDn=findViewById(R.id.edtTenDN);
        EditText edtMa=findViewById(R.id.edtMaCT);
        EditText edtNht=findViewById(R.id.edtDG);
        EditText edtNT=findViewById(R.id.edtNT);
        EditText edtTG=findViewById(R.id.edtTG);
        EditText edtPT=findViewById(R.id.edtDC);
        Button btnHome=findViewById(R.id.btnHome);
        Button btnAccount=findViewById(R.id.btnAccount);
        Button btnSetting=findViewById(R.id.btnSetting);
        Button btnBack=findViewById(R.id.btnBack);
        Button btnSua=findViewById(R.id.btnThem);
        SQLiteDatabase mydatabase;
        mydatabase=openOrCreateDatabase("qlhd.db",MODE_PRIVATE,null);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                edtMa.setText(thamQuanList.get(position).getMaTq().toString());
                edtDn.setText(thamQuanList.get(position).getDiaChi().toString());
                edtNht.setText(thamQuanList.get(position).getNguoiHoTro().toString());
                edtNT.setText(thamQuanList.get(position).getNgayThang().toString());
                edtTG.setText(thamQuanList.get(position).getThoiGian().toString());
                edtPT.setText(thamQuanList.get(position).getPhuongTien().toString());
            }
        });
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SuaThamQuan.this,HomeActivity.class);
                startActivity(intent);
            }
        });

        btnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SuaThamQuan.this,AccountActivity.class);
                startActivity(intent);
            }
        });
        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SuaThamQuan.this,SettingActivity.class);
                startActivity(intent);
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SuaThamQuan.this,ThamQuanActivity.class);
                startActivity(intent);
            }
        });
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String maCt=edtMa.getText().toString();
                String tenDN=edtDn.getText().toString();
                String nguoiHT=edtNht.getText().toString();
                String thoiGian=edtTG.getText().toString();
                String ngayThang=edtNT.getText().toString();
                String phuongTien=edtPT.getText().toString();
                ContentValues myvalue=new ContentValues();
                myvalue.put("diaChi",tenDN);
                myvalue.put("thoiGian",thoiGian);
                myvalue.put("ngayThang",ngayThang);
                myvalue.put("phuongTien",phuongTien);
                myvalue.put("nguoiHt",nguoiHT);
                int n=mydatabase.update("tbtq",myvalue,"maTq=?",new String[]{maCt});
                String msg="";
                if(n==0){
                    msg="Không cập nhật thành công";
                }
                else{
                    msg="Cập nhật thành công";
                }
                Toast.makeText(SuaThamQuan.this,msg,Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void loadDataFromDatabase() {
        database=openOrCreateDatabase("qlhd.db",MODE_PRIVATE,null);
        Cursor c=database.query("tbtq",null,null,null,null,null,null,null);

        if (c != null) {
            while (c.moveToNext()) {
                String[] data = new String[6];
                for (int i = 0; i < data.length; i++) {
                    data[i] = c.getString(i); // Lấy dữ liệu từ cột 0 đến cột 5
                }

                ThamQuan thamQuan = createThamQuanFromData(data);
                thamQuanList.add(thamQuan);
            }
            c.close();
        }
        adapter.notifyDataSetChanged();
    }
    private ThamQuan createThamQuanFromData(String[] data) {
        String maThamQuan = data[0];
        String tenDoanhNghiep = data[1];
        String thoiGian = data[2];
        String ngayThang = data[3];
        String nguoiHoTro = data[4];
        String phuongTienDiChuyen = data[5];

        return new ThamQuan(maThamQuan, tenDoanhNghiep, thoiGian, ngayThang, nguoiHoTro, phuongTienDiChuyen);
    }
    private void processCopy() {
        File dbFile = getDatabasePath(DATABASE_NAME);
        if (!dbFile.exists())
        {
            try{
                CopyDataBaseFromAsset();
                Toast.makeText(this, "Copying sucess from Assets folder",
                        Toast.LENGTH_LONG).show();
            }
            catch (Exception e){
                Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
            }
        }
    }
    private String getDatabasePath() {
        return getApplicationInfo().dataDir + DB_PATH_SUFFIX+ DATABASE_NAME;
    }
    public void CopyDataBaseFromAsset() {
        try {
            InputStream myInput;
            myInput = getAssets().open(DATABASE_NAME);
            String outFileName = getDatabasePath();
            File f = new File(getApplicationInfo().dataDir + DB_PATH_SUFFIX);
            if (!f.exists())
                f.mkdir();
            OutputStream myOutput = new FileOutputStream(outFileName);
            int size = myInput.available();
            byte[] buffer = new byte[size];
            myInput.read(buffer);
            myOutput.write(buffer);
            myOutput.flush();
            myOutput.close();
            myInput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}