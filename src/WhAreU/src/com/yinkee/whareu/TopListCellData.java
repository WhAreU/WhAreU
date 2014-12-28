package com.yinkee.whareu;

import android.content.Context;
import android.content.Intent;

public class TopListCellData {
	
	private Context context  = null;
	private String  cellName = "";
	private Intent  relatedIntent = null;
	public TopListCellData(Context context, String cellName, Intent relatedIntent) {
		this.context = context;
		this.cellName = cellName;
		this.relatedIntent = relatedIntent;
	}
	
	public Context getContext() {
		return context;
	}
	
	public String getCellName() {
		return cellName;
	}

	public Intent getRelatedIntent() {
		return relatedIntent;
	}
	
	public void startActiviy() {
		getContext().startActivity(getRelatedIntent());
	}
	
	@Override
	public String toString() {
		return getCellName();
	}
}
