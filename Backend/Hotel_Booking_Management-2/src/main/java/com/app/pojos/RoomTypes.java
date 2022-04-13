package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "room_types")
public class RoomTypes extends BaseEntity{
	@Column(name = "room_type", length = 20)
	private String roomType;
	
	private double price;
	
	public RoomTypes() {
		this.roomType = null;
		this.price    = 0.0;
	}

	public RoomTypes(String roomType, double price) {
		this.roomType = roomType;
		this.price    = price;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
