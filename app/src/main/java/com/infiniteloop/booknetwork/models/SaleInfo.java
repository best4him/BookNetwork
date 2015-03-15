
package com.infiniteloop.booknetwork.models;

import com.google.api.services.books.model.Volume;

import java.util.List;

public class SaleInfo{
   	private String country;
   	private boolean isEbook;
   	private String saleability;
    private ListPrice listPrice;
    private Volume.SaleInfo.RetailPrice retailPrice;
    private String buyLink;
    private List offers;

    public List getOffers() {
        return offers;
    }

    public void setOffers(List offers) {
        this.offers = offers;
    }

    public String getBuyLink() {
        return buyLink;
    }

    public void setBuyLink(String buyLink) {
        this.buyLink = buyLink;
    }

    public Volume.SaleInfo.RetailPrice getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(Volume.SaleInfo.RetailPrice retailPrice) {
        this.retailPrice = retailPrice;
    }


    public ListPrice getListPrice() {
        return listPrice;
    }

    public void setListPrice(ListPrice listPrice) {
        this.listPrice = listPrice;
    }

    public boolean isEbook() {
        return isEbook;
    }

    public void setEbook(boolean isEbook) {
        this.isEbook = isEbook;
    }



 	public String getCountry(){
		return this.country;
	}
	public void setCountry(String country){
		this.country = country;
	}
 	public boolean getIsEbook(){
		return this.isEbook;
	}
	public void setIsEbook(boolean isEbook){
		this.isEbook = isEbook;
	}
 	public String getSaleability(){
		return this.saleability;
	}
	public void setSaleability(String saleability){
		this.saleability = saleability;
	}
}
