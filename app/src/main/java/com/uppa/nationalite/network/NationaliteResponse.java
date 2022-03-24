package com.uppa.nationalite.network;

import java.util.List;

public class NationaliteResponse{
	private List<CountryItem> country;
	private String name;

	public List<CountryItem> getCountry(){
		return country;
	}

	public String getName(){
		return name;
	}
}