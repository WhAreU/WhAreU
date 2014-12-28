package com.example.whareu;

import android.app.Activity;
import android.os.Bundle;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;


public class MainActivity extends Activity {
	
	private SlidingMenu slidingmenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // roubo:add and set the SlidingMenu
        slidingmenu = new SlidingMenu(this);
        slidingmenu.setMode(SlidingMenu.LEFT);
        slidingmenu.setShadowDrawable(R.drawable.topslidingmenu_shadow);
        slidingmenu.setShadowWidthRes(R.dimen.topslidingmenu_shadow);
        slidingmenu.setBehindOffset(R.dimen.topslidingmenu_offset);
        slidingmenu.setBehindWidth(300);
        slidingmenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        slidingmenu.attachToActivity(this,SlidingMenu.SLIDING_CONTENT);
        slidingmenu.setMenu(R.layout.slidingmenu);
    }

}
