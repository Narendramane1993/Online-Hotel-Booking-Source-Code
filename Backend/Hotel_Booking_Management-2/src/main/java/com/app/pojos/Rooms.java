package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Rooms extends BaseEntity{
	@Column(name = "room_number")
	private int roomNumber;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "room_type")
	private RoomTypes roomType;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "branch_id")
	private BranchInfo branchId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "booked_user")
	private User bookedUser;
	
	private int status;
	
	public Rooms() {
		this.roomNumber = 0;
		this.status     = 0;
	}

	public Rooms(int roomNumber, int status) {
		this.roomNumber = roomNumber;
		this.status     = status;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public RoomTypes getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomTypes roomType) {
		this.roomType = roomType;
	}

	public BranchInfo getBranchId() {
		return branchId;
	}

	public void setBranchId(BranchInfo branchId) {
		this.branchId = branchId;
	}

	public User getBookedUser() {
		return bookedUser;
	}

	public void setBookedUser(User bookedUser) {
		this.bookedUser = bookedUser;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
