package com.uppa.nationalite.network;

import com.google.gson.annotations.SerializedName;

public class CountryItem{
	private double probability;
	@SerializedName("country_id")
	private String countryId;

	public double getProbability(){
		return probability;
	}

	public String getCountryId(){
		return countryId;
	}
}
