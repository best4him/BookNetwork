
package com.infiniteloop.booknetwork.models;

public class Epub{
   	private boolean isAvailable;
    private String acsTokenLink;

    public String getAcsTokenLink() {
        return acsTokenLink;
    }

    public void setAcsTokenLink(String acsTokenLink) {
        this.acsTokenLink = acsTokenLink;
    }

    public boolean getIsAvailable(){
		return this.isAvailable;
	}
	public void setIsAvailable(boolean isAvailable){
		this.isAvailable = isAvailable;
	}
}
