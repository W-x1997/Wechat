package com.example.wx.wechat;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wx on 17/3/21.
 */

public class Myadapter extends ArrayAdapter<Beans>{
    private int resource_id;
    private  List<Beans> beans=new ArrayList<Beans>();

    public Myadapter(Context context, int resource_id, List<Beans> objects) //resource id为实用的listview的布局文件
    {
        super(context,resource_id,objects);
        this.resource_id=resource_id;
        this.beans=objects;

    }


    @Nullable
    @Override
    public Beans getItem(int position) {
        return beans.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Beans bean=(Beans)getItem(position);
        ViewHolder viewHolder;
        View view;
        if(convertView==null)
        {
            view= LayoutInflater.from(getContext()).inflate(resource_id,null);
            viewHolder=new ViewHolder();
            viewHolder.image=(ImageView)view.findViewById(R.id.image_id);
            viewHolder.content=(TextView)view.findViewById(R.id.content_id);
            viewHolder.date=(TextView)view.findViewById(R.id.date_id);
            view.setTag(viewHolder);

        }
        else
        {
            view=convertView;
            viewHolder=(ViewHolder)view.getTag();
        }


        viewHolder.image.setImageResource(bean.getImageId());
        viewHolder.content.setText(bean.getName());
        viewHolder.date.setText(bean.getDate());
        return  view;

    }


class ViewHolder
    {
        ImageView image;
        TextView content;
        TextView  date;
    }



}
