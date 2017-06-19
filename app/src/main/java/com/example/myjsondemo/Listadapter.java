package com.example.myjsondemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by peacock on 3/18/16.
 */
public class Listadapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<String> id;
    private ArrayList<String> Name;
    private ArrayList<Integer> salary;
    private ArrayList<Boolean> married;


    public Listadapter(Context mContext, ArrayList<String> id, ArrayList<String> name, ArrayList<Integer> salary, ArrayList<Boolean> married) {
        this.mContext = mContext;
        this.id = id;
        this.Name = name;
        this.salary = salary;
        this.married = married;

    }

    @Override
    public int getCount() {
        return id.size();
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
        LayoutInflater layoutInflater;
        if (convertView == null) {
            layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.listitem, null);
            holder = new Holder();
            holder.txt_id = (TextView) convertView.findViewById(R.id.txtid);
            holder.txt_name = (TextView) convertView.findViewById(R.id.txtname);
            holder.txt_salary = (TextView) convertView.findViewById(R.id.txtsalary);
            holder.txt_married = (TextView) convertView.findViewById(R.id.txtmarried);
            holder.lbl_id = (TextView) convertView.findViewById(R.id.lblid);
            holder.lbl_name = (TextView) convertView.findViewById(R.id.lblname);
            holder.lbl_salary = (TextView) convertView.findViewById(R.id.lblsalary);
            holder.lbl_married = (TextView) convertView.findViewById(R.id.lblmeried);
            convertView.setTag(holder);
        } else {
            holder = (Holder)convertView.getTag();
        }
        holder.txt_id.setText(id.get(position));
        holder.txt_name.setText(Name.get(position));
        holder.txt_salary.setText(String.valueOf(salary.get(position)));
        holder.txt_married.setText(String.valueOf(married.get(position)));
        return convertView;
    }

    public class Holder {
        TextView txt_id;
        TextView txt_name;
        TextView txt_salary;
        TextView txt_married;
        TextView lbl_id;
        TextView lbl_name;
        TextView lbl_salary;
        TextView lbl_married;

    }
}
