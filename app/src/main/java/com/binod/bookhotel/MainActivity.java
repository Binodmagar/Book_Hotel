package com.binod.bookhotel;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText etCheckingdate, etCheckoutdate, etRoom, etAdult, etChild;
    Button btnCalculate;
    TextView tvTotalDays, tvTotalRoom,tvRoomPrice, tvTotal, tvGrandTotal;
    Spinner spRoom;
    int year, year1;
    int month, month1;
    int day, day1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //binding
        etCheckingdate = findViewById(R.id.etCheckingdate);
        etCheckoutdate = findViewById(R.id.etCheckoutdate);
        spRoom = findViewById(R.id.spRoom);
        etRoom = findViewById(R.id.etRoom);
        etAdult = findViewById(R.id.etAdult);
        etChild = findViewById(R.id.etChild);
        btnCalculate = findViewById(R.id.btnCalculate);
        tvTotalDays = findViewById(R.id.tvTotalDays);
        tvTotalRoom = findViewById(R.id.tvTotalRoom);
        tvRoomPrice = findViewById(R.id.tvRoomPrice);
        tvTotal = findViewById(R.id.tvTotal);
        tvGrandTotal = findViewById(R.id.tvGrandTotal);




        //for spinner Room
        String Room[] ={"--Select Room--", "Deluxe: Rs 2000","Presidential: Rs 5000","Premium: Rs 3000"};
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, Room);
        spRoom.setAdapter(adapter);


        //for checking date

        etCheckingdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadDatePicker();
            }
        });

        //for checkout datete.getDate
        etCheckoutdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadDatePicker1();
            }
        });
    }
    //fucnction loadDatePicker for checking date
    private  void loadDatePicker(){
        //use current date as default date in the picker and popup calender of todays
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int dayOfMonth = c.get(Calendar.DAY_OF_MONTH);

        //show selected data by user in main activity
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String date = "Day/Month/Year: " + dayOfMonth + "/" + month + "/" + year;
                etCheckingdate.setText(date);
            }
        },year,month,dayOfMonth);
        datePickerDialog.show();
    }



    //function loadDatePicker for checkout date
    private  void loadDatePicker1(){
        //use current date as default date in the picker and popup calender of todays
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        //show selected data by user in main activity
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String date = "Date/Month/Year: " + dayOfMonth + "/" + month + "/" + year;
                etCheckoutdate.setText(date);
            }
        },year,month,day);
        datePickerDialog.show();
    }
}
