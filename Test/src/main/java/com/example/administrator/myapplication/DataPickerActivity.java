package com.example.administrator.myapplication;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by Administrator on 2016/3/24.
 */
public class DataPickerActivity extends AppCompatActivity {
    private Button date_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.layout_dialog);
        InitView();
    }

    private void InitView() {
        date_button = (Button) this.findViewById(R.id.dialog_button);
        date_button.setOnClickListener(new View.OnClickListener() {
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            @Override
            public void onClick(View v) {
                //DatePicker datePicker = (DatePicker) DataPickerActivity.this.findViewById(R.id.datePicker);
//                datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
//                    @Override
//                    public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//                        String str_msg;
//                        str_msg = "年=" + String.valueOf(year) + ",月=" + String.valueOf(monthOfYear) + ",日=" + String.valueOf(dayOfMonth);
//                        Toast.makeText(DataPickerActivity.this, str_msg, Toast.LENGTH_LONG).show();
//                    }
//                });
                DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        String str_msg;
                        str_msg = "年=" + String.valueOf(year) + ",月=" + String.valueOf(monthOfYear) + ",日=" + String.valueOf(dayOfMonth);
                        Toast.makeText(DataPickerActivity.this, str_msg, Toast.LENGTH_LONG).show();
                    }
                };
                DatePickerDialog datePickerDialog = new DatePickerDialog(DataPickerActivity.this, onDateSetListener, year, month, day);
                datePickerDialog.show();
            }
        });
    }
}
