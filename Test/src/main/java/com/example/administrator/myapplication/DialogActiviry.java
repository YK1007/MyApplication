package com.example.administrator.myapplication;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/3/24.
 */
public class DialogActiviry extends AppCompatActivity {
    private Button dialog_buuton;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.layout_dialog);
        InintView();
    }

    private void InintView() {

        dialog_buuton = (Button) this.findViewById(R.id.dialog_button);
        dialog_buuton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder diaolog = new AlertDialog.Builder(DialogActiviry.this);
                diaolog.setTitle("警示对话框");
                diaolog.setNegativeButton("取消",null);
                diaolog.setPositiveButton("确定",null);
                diaolog.setIcon(R.drawable.ic_launcher);
                diaolog.setSingleChoiceItems(R.array.company, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String string_msg = "选中了" + String.valueOf(which);
                        Toast.makeText(DialogActiviry.this, string_msg, Toast.LENGTH_LONG).show();
                    }
                });
                diaolog.create();
                diaolog.show();
            }
        });
    }
}
