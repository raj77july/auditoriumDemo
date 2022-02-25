package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Show {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int show_id;
	public int getShow_id() {
		return show_id;
	}
	public void setShow_id(int show_id) {
		this.show_id = show_id;
	}
	public String getShow_name() {
		return show_name;
	}
	public void setShow_name(String show_name) {
		this.show_name = show_name;
	}
	public int getNumberOfSeat() {
		return numberOfSeat;
	}
	public void setNumberOfSeat(int numberOfSeat) {
		this.numberOfSeat = numberOfSeat;
	}
	private String show_name;
	private int numberOfSeat;
	@Override
	public String toString() {
		return "Show [show_id=" + show_id + ", show_name=" + show_name + ", numberOfSeat=" + numberOfSeat + "]";
	}
	
	
	

}
