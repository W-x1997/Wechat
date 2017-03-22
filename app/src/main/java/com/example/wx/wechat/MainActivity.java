package com.example.wx.wechat;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jauker.widget.BadgeView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {

    private ViewPager viewPager;
    private FragmentPagerAdapter mAdapter;
    private List <Fragment> mDatas;
    private TextView mchat_tv;
    private  TextView mfriend_tv;
    private  TextView mcontact_tv;
    private  BadgeView mbageview;
    private LinearLayout chat_layout;
    private ImageView tabline;
    private int mScreen1_3;





    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        initView();
        inittableline();


    }

    public void inittableline()
    {
        tabline=(ImageView)findViewById(R.id.imv_tab);
        Display display=getWindow().getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics=new DisplayMetrics();
        display.getMetrics(outMetrics);
        mScreen1_3=outMetrics.widthPixels/3;
        ViewGroup.LayoutParams lp= tabline.getLayoutParams();
        lp.width=mScreen1_3;
        tabline.setLayoutParams(lp);

    }

   private void initView()
   {
      mchat_tv=(TextView)findViewById(R.id.chat_tv);
       mcontact_tv=(TextView)findViewById(R.id.contact_tv);
       mfriend_tv=(TextView)findViewById(R.id.friend_tv);
       viewPager=(ViewPager)findViewById(R.id.id_viewpager);
       mDatas=new ArrayList<Fragment>();
       chat_layout=(LinearLayout)findViewById(R.id.chat_wapper);


       Chat tab_01=new Chat();
       Friend tab_02=new Friend();
       Contact tab_03=new Contact();
       mDatas.add(tab_01);
       mDatas.add(tab_02);
       mDatas.add(tab_03);

       mAdapter=new FragmentPagerAdapter(getSupportFragmentManager()) {
           @Override
           public Fragment getItem(int position) {
               return mDatas.get(position);
           }

           @Override
           public int getCount() {
               return mDatas.size();
           }
       };
       viewPager.setAdapter(mAdapter);
       viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
           @Override
           public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {



           }

           @Override
           public void onPageSelected(int position) {

               resetTextView();
               switch (position)
               {
                   case 0:
                       if(mbageview!=null)
                       {
                           chat_layout.removeView(mbageview);
                       }
                       mbageview=new BadgeView(MainActivity.this);
                       mbageview.setBadgeCount(7);
                       chat_layout.addView(mbageview);
                       mchat_tv.setTextColor(Color.parseColor("#008000"));
                       break;
                   case 1:
                       mfriend_tv.setTextColor(Color.parseColor("#008000"));
                       break;
                   case 2:
                     mcontact_tv.setTextColor(Color.parseColor("#008000"));
                       break;

               }

           }

           @Override
           public void onPageScrollStateChanged(int state) {

           }

           public  void resetTextView()
           {
               mchat_tv.setTextColor(Color.BLACK);
               mfriend_tv.setTextColor(Color.BLACK);
               mcontact_tv.setTextColor(Color.BLACK);
           }
       });

   }
}
