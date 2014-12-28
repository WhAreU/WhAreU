package com.yinkee.whareu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

public class MainActivity extends Activity implements OnItemClickListener {
	
	private ArrayAdapter<TopListCellData> adapter;
	private SlidingMenu slidingmenu;
	private ListView  topListView;

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
        slidingmenu.setMenu(R.layout.activity_sliding_menu);
        
        
        // roubo:show the top list
        topListView = (ListView) findViewById(R.id.topListView);
        adapter = new ArrayAdapter<TopListCellData>(this, android.R.layout.simple_list_item_1);
        topListView.setAdapter(adapter);
        // roubo:Item1: show the map
        adapter.add(new TopListCellData(this, "œ‘ æµÿÕº", new Intent(this, ActivityBaiduMap.class)));
        topListView.setOnItemClickListener(this);
        
    }


	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		TopListCellData data = adapter.getItem(position);
		data.startActiviy();
	}
    

}
