package com.example.ktragiuaki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView txtHienThi;
    Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //AnhXa
        txtHienThi = (TextView) findViewById(R.id.textViewHienThi);
        btnBack = (Button) findViewById(R.id.buttonBack);

        //Hiển thị Kết Quả Từ Main1
        Intent i = getIntent();
        String hoten = i.getStringExtra("hoTen" );
        String ngaysinh = i.getStringExtra("ngaySinh");
        String tuoi = i.getStringExtra("tuoi");

        txtHienThi.setText("Họ Tên: "+hoten + "\n"+"Ngày Sinh: " + ngaysinh + "\n"  + tuoi);

        //Back lại Main1
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity2.this , MainActivity.class);
                startActivity(i);
            }
        });
    }
}