package com.yinkee.whareu;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.MapView;

public class MapFragment extends Fragment {
	MapView mMapView = null;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//roubo:Init the baidu map SDK, before setContentView
		SDKInitializer.initialize(getActivity().getApplicationContext());
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		mMapView.onDestroy();
	}
	
	@Override
	public void onResume() {
		super.onResume();
		mMapView.onResume();
	}
	
	@Override
	public void onPause() {
		super.onPause();
		mMapView.onPause();
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View mapLayout = inflater.inflate(R.layout.activity_baidu_map, container, false);
		mMapView = (MapView) mapLayout.findViewById(R.id.baidumapview);
		mMapView.refreshDrawableState();
		return mapLayout;
	}

}
