package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "branch_info")
public class BranchInfo extends BaseEntity{
	@Column(name = "room_quantity")
	private int roomQuantity;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hotel_id")
	private HotelInfo hotelInfo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "room_type")
	private RoomTypes roomType;
	
	public BranchInfo() {
		this.roomQuantity = 0;
	}

	public BranchInfo(int roomQuantity) {
		this.roomQuantity = roomQuantity;
	}

	public int getRoomQuantity() {
		return roomQuantity;
	}

	public void setRoomQuantity(int roomQuantity) {
		this.roomQuantity = roomQuantity;
	}

	public HotelInfo getHotelInfo() {
		return hotelInfo;
	}

	public void setHotelInfo(HotelInfo hotelInfo) {
		this.hotelInfo = hotelInfo;
	}

	public RoomTypes getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomTypes roomType) {
		this.roomType = roomType;
	}
	
	
}
