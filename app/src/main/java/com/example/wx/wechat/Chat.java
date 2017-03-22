package com.example.wx.wechat;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wx on 17/3/19.
 */

public class Chat extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.tab_01, null);    //获取第一个布局来加入listview
      /**
       * View view2=inflater.inflate(R.layout.beans_item,null);  // 获取第二个布局来加入bgv

        LinearLayout chatlayout=(LinearLayout)view2.findViewById(R.id.content_layout_id);
         **/
        List<Beans> beans=new ArrayList<Beans>();
        beans.add(new Beans("小雨",R.drawable.cute,"8:54PM"));
        beans.add(new Beans("大白",R.drawable.dabai,"Yesterday"));

        Myadapter myadapter=new Myadapter(getActivity(),R.layout.beans_item,beans);

        /**
        BadgeView mbageview=new BadgeView(getActivity());
        mbageview.setBadgeCount(7);

        chatlayout.addView(mbageview);
**/

        ListView listView=(ListView)view.findViewById(R.id.list_id);
        listView.setAdapter(myadapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                AlertDialog.Builder dialog=new AlertDialog.Builder(getActivity());
                dialog.setTitle("Sorry!");
                dialog.setMessage("Function is under development,Please wait");
                dialog.setCancelable(false);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public  void onClick(DialogInterface dialog,int which)
                    {

                    }
                });
                dialog.setNegativeButton("Cancel",new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialogInterface,int which)
                    {

                    }

                });
                dialog.show();

            }
        });

        return view;
    }
}
