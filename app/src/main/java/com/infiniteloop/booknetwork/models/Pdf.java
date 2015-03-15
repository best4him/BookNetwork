
package com.infiniteloop.booknetwork.models;

public class Pdf{
   	private boolean isAvailable;

    public String getAcsTokenLink() {
        return acsTokenLink;
    }

    public void setAcsTokenLink(String acsTokenLink) {
        this.acsTokenLink = acsTokenLink;
    }

    private String acsTokenLink;

 	public boolean getIsAvailable(){
		return this.isAvailable;
	}
	public void setIsAvailable(boolean isAvailable){
		this.isAvailable = isAvailable;
	}
}
