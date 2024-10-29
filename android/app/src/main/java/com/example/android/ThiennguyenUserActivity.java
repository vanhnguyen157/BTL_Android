package com.example.android;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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

public class ThiennguyenUserActivity extends AppCompatActivity {


    String DB_PATH_SUFFIX="/databases/";
    SQLiteDatabase database=null;
    String DATABASE_NAME="qlhd.db";
    ListView lv;
    ArrayList<String> mylist;
    ArrayList<String> originalList;
    ArrayAdapter<String> myadapter;
    ArrayList<ThienNguyen> thamQuanList;
    ArrayAdapter<ThienNguyen> adapter;
    EditText searchEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_thiennguyen_user);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        lv=findViewById(R.id.lv);
        searchEditText = findViewById(R.id.searchEditText);
        mylist=new ArrayList<>();
        originalList = new ArrayList<>();

        myadapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,mylist);
        lv.setAdapter(myadapter);
        processCopy();
        database=openOrCreateDatabase("qlhd.db",MODE_PRIVATE,null);
        Cursor c=database.query("tbtn",null,null,null,null,null,null,null);
        String data="";
        c.moveToFirst();
        while(c.isAfterLast()==false){
            data=c.getString(0)+"\n"+c.getString(1)+"\n"+c.getString(2)+"\n"+c.getString(3)+"\n"+c.getString(4);
            mylist.add(data);
            originalList.add(data);
            c.moveToNext();
        }
        c.close();
        myadapter.notifyDataSetChanged();

        thamQuanList=new ArrayList<>();
        adapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,thamQuanList);

        loadDataFromDatabase();

        Button btnHome=findViewById(R.id.btnHome);
        Button btnAccount=findViewById(R.id.btnAccount);
        Button btnSetting=findViewById(R.id.btnSetting);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ThiennguyenUserActivity.this,HomeUserActivity.class);
                startActivity(intent);
            }
        });
        btnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ThiennguyenUserActivity.this,AccountActivity.class);
                startActivity(intent);
            }
        });
        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ThiennguyenUserActivity.this,SettingActivity.class);
                startActivity(intent);
            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(ThiennguyenUserActivity.this,ThiennguyenChitietActivity.class);
                ThienNguyen sinhvien=thamQuanList.get(position);
                intent.putExtra("maTn",sinhvien.getMaTn());
                intent.putExtra("tenTn",sinhvien.getTenTn());
                intent.putExtra("thoiGian",sinhvien.getThoiGian());
                intent.putExtra("ngayThang",sinhvien.getNgayThang());
                intent.putExtra("diaChi",sinhvien.getDiaChi());
                startActivity(intent);
            }
        });
        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                filter(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }
    private void loadDataFromDatabase() {
        database=openOrCreateDatabase("qlhd.db",MODE_PRIVATE,null);
        Cursor c=database.query("tbtn",null,null,null,null,null,null,null);

        if (c != null) {
            while (c.moveToNext()) {
                String[] data = new String[5];
                for (int i = 0; i < data.length; i++) {
                    data[i] = c.getString(i); // Lấy dữ liệu từ cột 0 đến cột 4
                }

                ThienNguyen thienNguyen = createThienNguyenFromData(data);
                thamQuanList.add(thienNguyen);
            }
            c.close();
        }
        adapter.notifyDataSetChanged();
    }
    private ThienNguyen createThienNguyenFromData(String[] data) {
        String maTn = data[0];
        String tenTn = data[1];
        String ngayThang = data[2];
        String thoiGian = data[3];
        String diaChi = data[4];

        return new ThienNguyen(maTn, tenTn, ngayThang, thoiGian, diaChi);
    }
    private void filter(String text) {
        if (text.isEmpty()) {
            myadapter.clear();
            myadapter.addAll(originalList); // Trả về danh sách ban đầu
        } else {
            ArrayList<String> filteredList = new ArrayList<>();
            for (String item : mylist) {
                if (item.toLowerCase().contains(text.toLowerCase())) {
                    filteredList.add(item);
                }
            }
            myadapter.clear();
            myadapter.addAll(filteredList);
        }
        myadapter.notifyDataSetChanged();
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