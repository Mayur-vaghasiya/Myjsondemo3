package com.example.myjsondemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by peacock on 3/19/16.
 */
public class listadpter extends BaseAdapter {
    public Context mContext;
    public ArrayList<String> projectid;
    public ArrayList<String> projnumber;
    public ArrayList<String> name;



    public listadpter(Context mContext, ArrayList<String> projectid, ArrayList<String> projnumber, ArrayList<String> name) {
        this.mContext = mContext;
        this.projectid = projectid;
        this.projnumber = projnumber;
        this.name = name;
    }

    @Override
    public int getCount() {
        return 0;
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
            convertView = layoutInflater.inflate(R.layout.listcitem, null);
            holder = new Holder();

            holder.txtpid = (TextView) convertView.findViewById(R.id.txtpid);
            holder.txtproj_number = (TextView) convertView.findViewById(R.id.txtproj_number);
            holder.txtname = (TextView) convertView.findViewById(R.id.txtname);
/*--*/
            /*holder.txtmobile_sdk_id = (TextView) convertView.findViewById(R.id.txtmobile_sdk_id);
            holder.txtclient_id = (TextView) convertView.findViewById(R.id.txtclient_id);
            holder.txtclient_type = (TextView) convertView.findViewById(R.id.txtclient_type);
            holder.txtpackage_name = (TextView) convertView.findViewById(R.id.txtpackage_name);*/
/*--*/
            /*holder.txtclient_id1 = (TextView) convertView.findViewById(R.id.txtclient_id1);
            holder.txtclient_type1 = (TextView) convertView.findViewById(R.id.txtclient_type1);
            holder.txtpackage_name1 = (TextView) convertView.findViewById(R.id.txtpackage_name1);
            holder.txtcertificate_hash = (TextView) convertView.findViewById(R.id.txtcertificate_hash);
            holder.txtclient_id2 = (TextView) convertView.findViewById(R.id.txtclient_id2);
            holder.txtclient_type2 = (TextView) convertView.findViewById(R.id.txtclient_type2);*/
/*---*/
           /* holder.txtstatus = (TextView) convertView.findViewById(R.id.txtstatus);*/
 /*---*/
            /*holder.txtstatus1 = (TextView) convertView.findViewById(R.id.txtstatus1);
            holder.txtapns_config = (TextView) convertView.findViewById(R.id.txtapns_config);*/
 /*---*/
           /* holder.txtstatus2 = (TextView) convertView.findViewById(R.id.txtstatus2);
            holder.txtother_platform_oauth_client = (TextView) convertView.findViewById(R.id.txtother_platform_oauth_client);*/
/*--*/
           /* holder.txtstatus3 = (TextView) convertView.findViewById(R.id.txtstatus3);
            holder.txtstatus4 = (TextView) convertView.findViewById(R.id.txtstatus4);*/
/*-----------------------------------*/
            holder.lblproj = (TextView) convertView.findViewById(R.id.lblproj);
            holder.lblproject_info = (TextView) convertView.findViewById(R.id.lblproject_info);
            holder.lblproject_id = (TextView) convertView.findViewById(R.id.lblproject_id);
            holder.lblproj_number = (TextView) convertView.findViewById(R.id.lblproj_number);
            holder.lblname = (TextView) convertView.findViewById(R.id.lblname);
/*--*/
            /*holder.lblclient = (TextView) convertView.findViewById(R.id.lblclient);
            holder.lblclient_info = (TextView) convertView.findViewById(R.id.lblclient_info);
            holder.lblmobilesdk_app_id = (TextView) convertView.findViewById(R.id.lblmobilesdk_app_id);
            holder.lblclient_id = (TextView) convertView.findViewById(R.id.lblclient_id);
            holder.lblclient_type = (TextView) convertView.findViewById(R.id.lblclient_type);
            holder.lblandroid_client_info = (TextView) convertView.findViewById(R.id.lblandroid_client_info);
            holder.lblpackage_name = (TextView) convertView.findViewById(R.id.lblpackage_name);*/
/*--*/
            /*holder.lbloauth_client = (TextView) convertView.findViewById(R.id.lbloauth_client);
            holder.lblclient_id1 = (TextView) convertView.findViewById(R.id.lblclient_id1);
            holder.lblclient_type1 = (TextView) convertView.findViewById(R.id.lblclient_type1);
            holder.lblandroid_info = (TextView) convertView.findViewById(R.id.lblandroid_info);
            holder.lblpackage_name1 = (TextView) convertView.findViewById(R.id.lblpackage_name1);
            holder.lblcertificate_hash = (TextView) convertView.findViewById(R.id.lblcertificate_hash);
            holder.lblclient_id2 = (TextView) convertView.findViewById(R.id.lblclient_id2);
            holder.lblclient_type2 = (TextView) convertView.findViewById(R.id.lblclient_type2);*/
/*--*/
           /* holder.lblapi_key = (TextView) convertView.findViewById(R.id.lblapi_key);
            holder.lblservices = (TextView) convertView.findViewById(R.id.lblservices);
            holder.lblanalytics_service = (TextView) convertView.findViewById(R.id.lblanalytics_service);*/
/*--*/
          /*  holder.lblstatus = (TextView) convertView.findViewById(R.id.lblstatus);*/
/*--*/
           /* holder.lblcloud_messaging_service = (TextView) convertView.findViewById(R.id.lblcloud_messaging_service);
            holder.lblstatus1 = (TextView) convertView.findViewById(R.id.lblstatus1);
            holder.lblapns_config = (TextView) convertView.findViewById(R.id.lblapns_config);*/
/*--*/
           /* holder.lblcloud_messaging_service = (TextView) convertView.findViewById(R.id.lblcloud_messaging_service);
            holder.lblstatus1 = (TextView) convertView.findViewById(R.id.lblstatus1);
            holder.lblapns_config = (TextView) convertView.findViewById(R.id.lblapns_config);*/
/*--*/
           /* holder.lblappinvite_service = (TextView) convertView.findViewById(R.id.lblappinvite_service);
            holder.lblstatus2 = (TextView) convertView.findViewById(R.id.lblstatus2);
            holder.lblother_platform_oauth_client = (TextView) convertView.findViewById(R.id.lblother_platform_oauth_client);*/
/*--*/
            /*holder.lblgoogle_signin_service = (TextView) convertView.findViewById(R.id.lblgoogle_signin_service);
            holder.lblstatus3 = (TextView) convertView.findViewById(R.id.lblstatus3);*/
 /*--*/
           /* holder.lblads_service = (TextView) convertView.findViewById(R.id.lblads_service);
            holder.lblstatus4 = (TextView) convertView.findViewById(R.id.lblstatus4);*/
/*--*/

/*--*/

            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        holder.txtpid.setText(projectid.get(position));
        holder.txtproj_number.setText(projnumber.get(position));
        holder.txtname.setText(name.get(position));
/*--*/
        /*holder.txtmobile_sdk_id.setText(String.valueOf(married.get(position)));
        holder.txtclient_id.setText(id.get(position));
        holder.txtclient_type.setText(Name.get(position));
        holder.txtpackage_name.setText(String.valueOf(salary.get(position)));*/
/*--*/
        /*holder.txtclient_id1.setText(String.valueOf(married.get(position)));
        holder.txtclient_type1.setText(id.get(position));
        holder.txtpackage_name1.setText(Name.get(position));
        holder.txtcertificate_hash.setText(String.valueOf(salary.get(position)));
        holder.txtclient_id2.setText(Name.get(position));
        holder.txtclient_type2.setText(String.valueOf(salary.get(position)));*/
/*--*/
       /* holder.txtstatus.setText(String.valueOf(salary.get(position)));*/
/*--*/
       /* holder.txtstatus1.setText(String.valueOf(salary.get(position)));
        holder.txtapns_config.setText(String.valueOf(salary.get(position)));*/
/*--*/

/*--*/
        /*holder.txtstatus2.setText(String.valueOf(salary.get(position)));
        holder.txtother_platform_oauth_client.setText(String.valueOf(salary.get(position)));
        holder.txtstatus3.setText(String.valueOf(salary.get(position)));
        holder.txtstatus4.setText(String.valueOf(salary.get(position)));
*/
        return convertView;
    }

    public class Holder {
        TextView txtpid, txtproj_number, txtname;
        TextView txtmobile_sdk_id, txtclient_id, txtclient_type, txtpackage_name;
        TextView txtclient_id1, txtclient_type1, txtpackage_name1, txtcertificate_hash, txtclient_id2,
                 txtclient_type2;
        TextView txtstatus;
        TextView txtstatus1,txtapns_config;
        TextView txtstatus2,txtother_platform_oauth_client;
        TextView txtstatus3,txtstatus4;

        TextView lblproj, lblproject_info, lblproject_id, lblproj_number, lblname;
        TextView lblclient, lblclient_info, lblmobilesdk_app_id, lblclient_id, lblclient_type,
                 lblandroid_client_info, lblpackage_name;
        TextView lbloauth_client, lblclient_id1, lblclient_type1, lblandroid_info, lblpackage_name1, lblcertificate_hash,
                 lblclient_id2, lblclient_type2;
        TextView lblapi_key, lblservices, lblanalytics_service;
        TextView lblstatus;
        TextView lblcloud_messaging_service,lblstatus1,lblapns_config;
        TextView lblappinvite_service,lblstatus2,lblother_platform_oauth_client;
        TextView lblgoogle_signin_service,lblstatus3;
        TextView lblads_service,lblstatus4;
    }
}
