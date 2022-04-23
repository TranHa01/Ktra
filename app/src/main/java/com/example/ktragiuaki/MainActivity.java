package com.example.ktragiuaki;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Button btnHienThi;
    EditText edtHoten, edtNgaySinh, edtNgay;
    TextView txtTuoi;
    Calendar calendarNgaySinh ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        edtHoten.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_NORMAL);

        txtTuoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    //Tính Tuổi
                    Calendar today = Calendar.getInstance();
                    int tuoi = today.get(Calendar.YEAR) - calendarNgaySinh.get(Calendar.YEAR);
                txtTuoi.setText("Tuổi: "+ tuoi);
            }
        });


        btnHienThi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtNgaySinh.length() == 0 || edtHoten.length() == 0){
                    Toast.makeText(MainActivity.this, "Hãy Nhập Họ Tên và Ngày Sinh!", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(MainActivity.this , MainActivity2.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("hoTen",edtHoten.getText().toString());
                    bundle.putString("ngaySinh",edtNgaySinh.getText().toString());
                    bundle.putString("tuoi",txtTuoi.getText().toString());
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }
        });
        edtNgaySinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChonNgaySinh();
            }
        });
    }
    private void ChonNgaySinh(){
        calendarNgaySinh = Calendar.getInstance();
        int ngay = calendarNgaySinh.get(Calendar.DATE);
        int thang = calendarNgaySinh.get(Calendar.MONTH);
        int nam = calendarNgaySinh.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                //i: năm - i1: tháng - i2: Ngày
                calendarNgaySinh.set(i,i1,i2);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                edtNgaySinh.setText(simpleDateFormat.format(calendarNgaySinh.getTime()));
            }
        },nam,thang,ngay);
        datePickerDialog.show();
    }

    private void AnhXa() {
        btnHienThi = (Button) findViewById(R.id.buttonHienThi);
        edtHoten = (EditText) findViewById(R.id.editTextHoTen);
        edtNgaySinh = (EditText) findViewById(R.id.editTextNgaySinh);
//        edtNgay = (EditText) findViewById(R.id.editTextNgaySinh3);
        txtTuoi = (TextView) findViewById(R.id.textViewTuoi);
    }
}