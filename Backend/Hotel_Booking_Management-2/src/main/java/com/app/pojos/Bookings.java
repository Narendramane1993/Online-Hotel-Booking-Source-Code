package com.app.pojos;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Proxy;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Proxy(lazy = false)
public class Bookings extends BaseEntity{
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user")
	private User user;
	private int quantity;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date start_date;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date end_date;
	
	private int adults;
	private int childs;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "transaction_id")
	private Transaction transaction;
	
	private String city;
	
	public Bookings() {
		this.quantity  	= 0;
		this.start_date = null;
		this.end_date   = null;
		this.adults    	= 0;
		this.childs    	= 0;
		this.city 		= "";
	}

	public Bookings(int quantity, Date startDate, Date endDate, int adults, int childs, String city) {
		this.quantity  	= quantity;
		this.start_date = startDate;
		this.end_date   = endDate;
		this.adults    	= adults;
		this.childs    	= childs;
		this.city 		= city;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public int getAdults() {
		return adults;
	}

	public void setAdults(int adults) {
		this.adults = adults;
	}

	public int getChilds() {
		return childs;
	}

	public void setChilds(int childs) {
		this.childs = childs;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}
	
}
