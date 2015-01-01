package com.yinkee.whareu;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

public class MainActivity extends Activity implements OnItemClickListener, OnClickListener {
	
	// roubo: fragment as framework
	// roubo: 3 fragments
	private TopFragment     topFragment;
	private ContactFragment contactFragment;
	private MapFragment     mapFragment;
	// roubo: 3 layout
	private View topLayout;
	private View contactLayout;
	private View mapLayout;
	// roubo: 3 image
	private ImageView topImage;
	private ImageView contactImage;
	private ImageView mapImage;
	// roubo: 3 text
	private TextView topText;
	private TextView contactText;
	private TextView mapText;
	// roubo: 1 fragment manger
	private FragmentManager fragmentManager;
	
	
	private ArrayAdapter<TopListCellData> adapter;
	private SlidingMenu slidingmenu;
	private ListView  topListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragmentView();
        fragmentManager = getFragmentManager();
        setTabSelection(0);

        
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
        //topListView = (ListView) findViewById(R.id.topListView);
        //adapter = new ArrayAdapter<TopListCellData>(this, android.R.layout.simple_list_item_1);
        //topListView.setAdapter(adapter);
        //// roubo:Item1: show the map
        //adapter.add(new TopListCellData(this, "œ‘ æµÿÕº", new Intent(this, ActivityBaiduMap.class)));
        //topListView.setOnItemClickListener(this);
        
    }


	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		TopListCellData data = adapter.getItem(position);
		data.startActiviy();
	}
    
	
	private void setTabSelection(int index) {

		clearSelection();
		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
		hideAllFragment(fragmentTransaction);
		switch (index) {
		case 0:
			topImage.setImageResource(R.drawable.message_selected);
			topText.setTextColor(Color.GREEN);
			if(topFragment == null) {
				topFragment = new TopFragment();
				fragmentTransaction.add(R.id.topContent, topFragment);
			} else {
				fragmentTransaction.show(topFragment);
			}
			break;
		case 1:
			contactImage.setImageResource(R.drawable.contact_selected);
			contactText.setTextColor(Color.GREEN);
			if(contactFragment == null) {
				contactFragment = new ContactFragment();
				fragmentTransaction.add(R.id.topContent, contactFragment);
			} else {
				fragmentTransaction.show(contactFragment);
			}
			break;
		default:
			mapImage.setImageResource(R.drawable.map_selected);
			mapText.setTextColor(Color.GREEN);
			if(mapFragment == null) {
				mapFragment = new MapFragment();
				fragmentTransaction.add(R.id.topContent, mapFragment);
			} else {
				fragmentTransaction.show(mapFragment);
			}
			break;
		}
		
		fragmentTransaction.commit();

	}
	
	private void clearSelection() {
		topImage.setImageResource(R.drawable.message);
		topText.setTextColor(Color.parseColor("#ffffffff"));
		contactImage.setImageResource(R.drawable.contact);
		contactText.setTextColor(Color.parseColor("#ffffffff"));
		mapImage.setImageResource(R.drawable.map);
		mapText.setTextColor(Color.parseColor("#ffffffff"));
	}
	
	
	private void hideAllFragment(FragmentTransaction transaction) {
		if(topFragment != null)
			transaction.hide(topFragment);
		if(contactFragment != null)
			transaction.hide(contactFragment);
		if(mapFragment != null)
			transaction.hide(mapFragment);
	}
	
	private void initFragmentView() { 
		
		topLayout = findViewById(R.id.message_layout);
		contactLayout = findViewById(R.id.contact_layout);
		mapLayout = findViewById(R.id.map_layout);
		
		topImage = (ImageView) findViewById(R.id.message_image);
		contactImage = (ImageView) findViewById(R.id.contact_image);
		mapImage = (ImageView) findViewById(R.id.map_image);
		
		topText = (TextView) findViewById(R.id.message_text);
		contactText = (TextView) findViewById(R.id.contact_text);
		mapText = (TextView) findViewById(R.id.map_text);
		
		topLayout.setOnClickListener(this);
		contactLayout.setOnClickListener(this);
		mapLayout.setOnClickListener(this);

	}


	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		case R.id.message_layout:
			setTabSelection(0);
			break;
		case R.id.contact_layout:
			setTabSelection(1);
			break;
		case R.id.map_layout:
			setTabSelection(2);
			break;

		default:
			break;
		}
	}

}
