package com.java.jsf.controller;

import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import com.java.jsf.dao.AdminDao;
import com.java.jsf.dao.AssetDao;
import com.java.jsf.dao.UserDao;
import com.java.jsf.model.Admin;
import com.java.jsf.model.Asset;
import com.java.jsf.model.User;

public class AssetsController {

	private UserDao userDao;
	private User user;
	
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	// admin............
	private Admin admin;
	private AdminDao adminDao;
	
	
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public AdminDao getAdminDao() {
		return adminDao;
	}
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}
	
	// assets.........
	private Asset asset;
	private AssetDao assetDao;
	

	public Asset getAsset() {
		return asset;
	}
	public void setAsset(Asset asset) {
		this.asset = asset;
	}
	public AssetDao getAssetDao() {
		return assetDao;
	}
	public void setAssetDao(AssetDao assetDao) {
		this.assetDao = assetDao;
	}
	
	//..........Users.........

	private List<User> userList;
	public List<User> getUserList() {
		return userList;
	}
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	
	public List<User> showUser(){
		userList = userDao.showUsers();
		return userList;
	}

	public String addUser(User user) {
		return userDao.addUser(user);
	}
	public String validateUser(User user) {
		FacesContext context = FacesContext.getCurrentInstance();
	    context.getExternalContext().getSessionMap().remove("error");
	    return userDao.authenticate(user);
	}
	
	//add admin....
	public String addAdmin(Admin admin) {
		return adminDao.addAdmin(admin);
	}
	//login........
     	public String validateAdmin(Admin admin) {
        FacesContext context = FacesContext.getCurrentInstance();
	    context.getExternalContext().getSessionMap().remove("error");
	    return adminDao.authenticate(admin);
	}
	public String logout() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        // Invalidate the current user session to clear all session data
        facesContext.getExternalContext().invalidateSession();

        // Redirect user to login page 
        // The "?faces-redirect=true" ensures a redirect instead of forward
        return "adminLogin.jsf?faces-redirect=true";
    }
// Assets functions.............
	private List<Asset> assestList;

	public List<Asset> getAssestList() {
		return assestList;
	}
	public void setAssestList(List<Asset> assestList) {
		this.assestList = assestList;
	}

	public List<Asset> showAsset(){
		assestList = assetDao.showAsset();
		return assestList;
	}
	public String addAsset(Asset asset) {
	    return assetDao.addAsset(asset);  
	}
	
	private List<Asset> filteredAssets;

	public List<Asset> getFilteredAssets() {
	    return filteredAssets;
	}

	public void searchAssetsByName() {
	    filteredAssets = assetDao.getAssetByName(asset); 
	}



}
