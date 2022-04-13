package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "hotel_info")
public class HotelInfo extends BaseEntity{
	@Column(name = "city_name", length = 20)
	private String cityName;
	
	@Column(name = "city_code", length = 6)
	private String cityCode;
	
	public HotelInfo() {
		this.cityName = null;
		this.cityCode = null;
	}

	public HotelInfo(String cityName, String cityCode) {
		this.cityName = cityName;
		this.cityCode = cityCode;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	
	
}
