package com.yinkee.whareu;

import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.MapView;

import android.app.Activity;
import android.os.Bundle;

public class ActivityBaiduMap extends Activity {
	
	MapView mMapView = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//roubo:Init the baidu map SDK, before setContentView
		SDKInitializer.initialize(getApplicationContext());

		setContentView(R.layout.activity_baidu_map);
		mMapView = (MapView) findViewById(R.id.baidumapview);
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		mMapView.onDestroy();
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		mMapView.onResume();
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		mMapView.onPause();
	}

}
