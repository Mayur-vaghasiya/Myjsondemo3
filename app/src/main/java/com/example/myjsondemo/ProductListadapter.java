package com.example.myjsondemo;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by peacock on 4/6/16.
 */
public class ProductListadapter extends BaseAdapter {

    public Context context;
    public ArrayList<product> Productlist;


    public ProductListadapter(Context context, ArrayList<product> prodlist) {
        this.context = context;
        this.Productlist = prodlist;
    }

    @Override
    public int getCount() {
        return Productlist.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        LayoutInflater layoutinflater;

        if (convertView == null) {
            layoutinflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutinflater.inflate(R.layout.product, null);
            holder = new Holder();
            holder.txt_name = (TextView) convertView.findViewById(R.id.txtName);
            holder.txt_image = (TextView) convertView.findViewById(R.id.txtImageName);
            holder.txtprice = (TextView) convertView.findViewById(R.id.txtPrice);

            holder.lbl_name = (TextView) convertView.findViewById(R.id.lblName1);
            holder.lbl_image = (TextView) convertView.findViewById(R.id.lblImageName1);
            holder.lbl_price = (TextView) convertView.findViewById(R.id.lblPrice1);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        holder.txt_name.setText(Productlist.get(position).getName());
        holder.txt_image.setText(Productlist.get(position).getImageName());
        holder.txtprice.setText(String.valueOf(Productlist.get(position).getPrice()));

        Log.e("CNAME", Productlist.get(position).getName());
        Log.e("Cimage",Productlist.get(position).getImageName());
        Log.e("cprice",(String.valueOf(Productlist.get(position).getPrice())));


        return convertView;
    }
    public class Holder {

        TextView txt_name;
        TextView txt_image;
        TextView txtprice;

        TextView lbl_name;
        TextView lbl_image;
        TextView lbl_price;

    }
}

