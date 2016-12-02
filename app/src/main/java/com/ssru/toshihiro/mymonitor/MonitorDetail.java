package com.ssru.toshihiro.mymonitor;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MonitorDetail extends AppCompatActivity {

    private Context context;
    private ImageView imgDetail;

    private TextView titleDetail,priceDetail,brandDetail,sizeDetail,curveDetail,typeDetail, detailDetail;

    private String strImg,strTitle,strPrice,strBrand,strSize,strCurve,strType, strDetail;

    private Double priceDoube, sizeDoube;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitor_detail);

        binWidget();
        getDataActivity();
        changData();
        setWidget();





    }

    private void changData() {
        priceDoube = Double.parseDouble(strPrice);
        sizeDoube = Double.parseDouble(strSize);

        if (strCurve == "0") {
            strCurve = "จอปกติ";
        } else {
            strCurve = "จอโค้ง";
        }

    }

    private void setWidget() {
        titleDetail.setText(strTitle);
        priceDetail.setText(priceDoube + " บาท");
        brandDetail.setText(strBrand);
        sizeDetail.setText(sizeDoube + " นิ้ว");
        curveDetail.setText(strCurve);
        typeDetail.setText(strType);
        detailDetail.setText(strDetail);
        Picasso.with(context).load(strImg).resize(120,120).into(imgDetail);
    }

    private void binWidget() {
        imgDetail = (ImageView) findViewById(R.id.imgDetail);
        titleDetail = (TextView) findViewById(R.id.titleDetail);
        priceDetail = (TextView) findViewById(R.id.priceDetail);
        brandDetail = (TextView) findViewById(R.id.brandDetail);
        sizeDetail = (TextView) findViewById(R.id.sizeDetail);
        curveDetail = (TextView) findViewById(R.id.curveDetail);
        typeDetail = (TextView) findViewById(R.id.typeDetail);
        detailDetail = (TextView) findViewById(R.id.detailDetail);
    }

    private void getDataActivity() {
        Bundle bundle = getIntent().getExtras();
        strImg = bundle.getString("img");
        strTitle = bundle.getString("title");
        strPrice = bundle.getString("price");
        strBrand = bundle.getString("brand");
        strSize = bundle.getString("size");
        strCurve = bundle.getString("curve");
        strType = bundle.getString("type");
        strDetail = bundle.getString("detail");

    }
}
