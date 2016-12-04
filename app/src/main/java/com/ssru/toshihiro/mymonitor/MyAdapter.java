package com.ssru.toshihiro.mymonitor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by Admin on 01-Dec-16.
 */
public class MyAdapter extends BaseAdapter {

    Context context;
    String[] strTilte;
    String[] strPrice;
    String[] strIcon;

    public MyAdapter(Context context, String[] strTilte, String[] strPrice, String[] strIcon) {
        this.context = context;
        this.strTilte = strTilte;
        this.strPrice = strPrice;
        this.strIcon = strIcon;
    }

    @Override
    public int getCount() {
        return strTilte.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1 = layoutInflater.inflate(R.layout.my_listview, viewGroup, false);

        TextView txtTitle = (TextView) view1.findViewById(R.id.tvName);
        txtTitle.setText(strTilte[i]);

        TextView txtPrice = (TextView) view1.findViewById(R.id.tvPrice);
        Float priceFloat = Float.parseFloat(strPrice[i]);
        txtPrice.setText(priceFloat + " บาท");

        ImageView iconImage = (ImageView) view1.findViewById(R.id.tvIcon);
        Picasso.with(context).load(strIcon[i]).resize(100, 100).into(iconImage);



        return view1;
    }
}
