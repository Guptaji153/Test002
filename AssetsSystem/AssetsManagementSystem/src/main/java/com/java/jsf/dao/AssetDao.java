package com.java.jsf.dao;

import java.util.List;

import com.java.jsf.model.Asset;

public interface AssetDao {

	List<Asset> showAsset();
	String addAsset(Asset asset);
	public List<Asset> getAssetByName(Asset asset);
}
