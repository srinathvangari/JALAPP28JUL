package com.ssvtech.jalforce.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ssvtech.jalforce.Dailydelivery;
import com.ssvtech.jalforce.R;

import java.util.List;

import com.ssvtech.jalforce.entity.CustomerBean;


        import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.BaseAdapter;
        import android.widget.TextView;
        import java.util.List;

        import java.util.ArrayList;

public class CustomerListAdapter extends BaseAdapter {
    private List<CustomerBean> listData;
    private LayoutInflater layoutInflater;

    CustomerBean customerBean;


    public CustomerListAdapter(Context aContext, List<CustomerBean> listData) {
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);
    }
    @Override
    public int getCount() {
        return listData.size();
    }
    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    public View getView(int position, View v, ViewGroup vg) {
        com.ssvtech.jalforce.adapter.CustomerListAdapter.ViewHolder holder;
        if (v == null) {
            v = layoutInflater.inflate(R.layout.list_row, null);
            holder = new com.ssvtech.jalforce.adapter.CustomerListAdapter.ViewHolder();
            holder.uName = (TextView) v.findViewById(R.id.customerId);
            holder.uDesignation = (TextView) v.findViewById(R.id.employeeId);
            holder.uLocation = (TextView) v.findViewById(R.id.returnCanCount);
            v.setTag(holder);
        } else {
            holder = (com.ssvtech.jalforce.adapter.CustomerListAdapter.ViewHolder) v.getTag();
        }
        holder.uName.setText(""+listData.get(position).getFirstName()+" "+listData.get(position).getLastName());
        holder.uDesignation.setText(""+listData.get(position).getMobileNo());
        holder.uLocation.setText(""+listData.get(position).getAddress());
        return v;
    }
    static class ViewHolder {
        TextView uName;
        TextView uDesignation;
        TextView uLocation;
    }




}