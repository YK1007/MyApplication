package com.example.administrator.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * Created by Administrator on 2016/3/17.
 */
public class SpinnerActivity extends AppCompatActivity {
    private String[] province = new String[]{"北京市", "山西省", "广东省"};
    private String[][] cities = new String[][]{
            {"东城区", "西城区", "崇文区", "宣武区", "朝阳区", "海淀区", "丰台区", "石景山区", "门头沟区",
                    "房山区", "通州区", "顺义区", "大兴区", "昌平区", "平谷区", "怀柔区", "密云县",
                    "延庆县"},
            {
                    "太原市", "大同市", "吕梁市", "忻州市", "朔州市", "晋中市", "阳泉市", "临汾市", "运城市", "长治市", "晋城市"
            },
            {
                    "广州", "深圳", "韶关", "珠海", "汕头", "佛山", "湛江", "肇庆", "江门", "茂名", "惠州", "梅州",
                    "汕尾", "河源", "阳江", "清远", "东莞", "中山", "潮州", "揭阳", "云浮"
            }
    };
    private String[][][] district = new String[][][]{
            {
                    {""}, {"无"}, {"无"}, {"无"}, {"无"}, {"无"}, {"无"}, {"无"}, {"无"}, {"无"},
                    {"无"}, {"无"}, {"无"}, {"无"}, {"无"}, {"无"}, {"无"}, {"无"}
            },
            {
                    {"迎泽区", "万柏林区", "尖草坪区", "杏花岭区", "小店区", "晋源区区"},
                    {"宝安区", "福田区", "龙岗区", "罗湖区", "南山区", "盐田区"},
                    {"宝安区", "福田区", "龙岗区", "罗湖区", "南山区", "盐田区"},
                    {"宝安区", "福田区", "龙岗区", "罗湖区", "南山区", "盐田区"},
                    {"宝安区", "福田区", "龙岗区", "罗湖区", "南山区", "盐田区"},
                    {"宝安区", "福田区", "龙岗区", "罗湖区", "南山区", "盐田区"},
                    {"宝安区", "福田区", "龙岗区", "罗湖区", "南山区", "盐田区"},
                    {"宝安区", "福田区", "龙岗区", "罗湖区", "南山区", "盐田区"},
                    {"宝安区", "福田区", "龙岗区", "罗湖区", "南山区", "盐田区"},
                    {"宝安区", "福田区", "龙岗区", "罗湖区", "南山区", "盐田区"},
                    {"宝安区", "福田区", "龙岗区", "罗湖区", "南山区", "盐田区"}

            },
            {
                    //广东
                    {"海珠区", "荔湾区", "越秀区", "白云区", "萝岗区", "天河区", "黄埔区", "花都区", "从化市", "增城市", "番禺区", "南沙区"}, //广州
                    {"宝安区", "福田区", "龙岗区", "罗湖区", "南山区", "盐田区"},
                    //深圳
                    {"武江区", "浈江区", "曲江区", "乐昌市", "南雄市", "始兴县", "仁化县", "翁源县", "新丰县", "乳源县"}  //韶关
            }


    };
    private Spinner Spinner[] = new Spinner[3];
    private ArrayAdapter<String> arrayAdapter_province;
    private ArrayAdapter<String> arrayAdapter_city;
    private ArrayAdapter<String> arrayAdapter_district;
    private static int provincePosition;
    private static int cityPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.layout_spinner);
        InitView();
    }

    private void InitView() {
        Spinner[0] = (android.widget.Spinner) findViewById(R.id.spinner_province);
        Spinner[1] = (android.widget.Spinner) findViewById(R.id.spinner_city);
        Spinner[2] = (android.widget.Spinner) findViewById(R.id.spinner_district);

        arrayAdapter_province = new ArrayAdapter<String>(SpinnerActivity.this, android.R.layout.simple_spinner_item, province);
        Spinner[0].setAdapter(arrayAdapter_province);
        Spinner[0].setSelection(0);

        arrayAdapter_city = new ArrayAdapter<String>(SpinnerActivity.this, android.R.layout.simple_spinner_item, cities[0]);
        Spinner[1].setAdapter(arrayAdapter_city);
        Spinner[1].setSelection(0);

        arrayAdapter_district = new ArrayAdapter<String>(SpinnerActivity.this, android.R.layout.simple_spinner_item, district[0][0]);
        Spinner[2].setAdapter(arrayAdapter_district);
        Spinner[2].setSelection(0);

        Spinner[0].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                arrayAdapter_city = new ArrayAdapter<String>(SpinnerActivity.this, android.R.layout.simple_spinner_item, cities[position]);
                Spinner[1].setAdapter(arrayAdapter_city);
                provincePosition = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Spinner[1].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                arrayAdapter_district = new ArrayAdapter<String>(SpinnerActivity.this, android.R.layout.simple_spinner_item, district[provincePosition][position]);
                Spinner[2].setAdapter(arrayAdapter_district);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}
