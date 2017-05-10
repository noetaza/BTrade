package com.example.noe.btrade;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class AdapterGB extends BaseAdapter {
    Context context;
    ArrayList<Item> items;

    public AdapterGB(Context c, ArrayList<Item> it) {
        context = c;
        items = it;
    }

    public int getCount() {
        return items.size();
    }

    public Object getItem(int index) {
        return items.get(index);
    }

    public long getItemId(int index) {
        return items.indexOf(getItem(index));
    }


    private class ViewHolder {
        ImageView Picture;
        TextView Name;
    }

    public View getView(int index, View convertView, final ViewGroup parent) {

        ViewHolder holder = null;
        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.content_gbook, null);
            holder = new ViewHolder();
            holder.Name = (TextView) convertView.findViewById(R.id.nameGen);
            holder.Picture = (ImageView) convertView.findViewById(R.id.imgGen);

            Item current = items.get(index);

            holder.Picture.setImageResource(current.getPic());
            holder.Name.setText(current.getGenId());
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
            holder.Name.setText(items.get(index).getGenId());
            holder.Picture.setImageResource(items.get(index).getPic());
        }

        return convertView;
    }
}

