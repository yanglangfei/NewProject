package com.ylf.jucaipen.newproject.been;

public class ImageInfo {
	
	private String imgUrl;
	private String imgTitle;
	private String imgDesc;
	
		
	public ImageInfo() {
		super();
	}

	public ImageInfo(String imgUrl, String imgTitle, String imgDesc) {
		super();
		this.imgUrl = imgUrl;
		this.imgTitle = imgTitle;
		this.imgDesc = imgDesc;
	}



	public String getImgUrl() {
		return imgUrl;
	}



	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}



	public String getImgTitle() {
		return imgTitle;
	}



	public void setImgTitle(String imgTitle) {
		this.imgTitle = imgTitle;
	}



	public String getImgDesc() {
		return imgDesc;
	}



	public void setImgDesc(String imgDesc) {
		this.imgDesc = imgDesc;
	}
	
	
}
