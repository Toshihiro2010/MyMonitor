package com.ssru.toshihiro.mymonitor;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Created by Admin on 01-Dec-16.
 */
public class MyAdapter extends BaseAdapter {

    Context context;
    String[] strTilte;
    String[] strPrice;
    String[] strIcon;

    public MyAdapter(Context context, String[] strPrice, String[] strTilte, String[] strIcon) {
        this.context = context;
        this.strPrice = strPrice;
        this.strTilte = strTilte;
        this.strIcon = strIcon;
    }

    @Override
    public int getCount() {
        return strIcon.length;
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
        return null;
    }
}
