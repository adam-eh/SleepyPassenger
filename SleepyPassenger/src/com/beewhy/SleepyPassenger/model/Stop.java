package com.beewhy.SleepyPassenger.model;

public class Stop {
	
	int id_a;
	int id_b;
	int pre_a;
	int pre_b;
	String desc;
	double lat;
	double lng;
	boolean terminus;
	
	public int getId_a() {
		return id_a;
	}
	public void setId_a(int id_a) {
		this.id_a = id_a;
	}
	public int getId_b() {
		return id_b;
	}
	public void setId_b(int id_b) {
		this.id_b = id_b;
	}
	public int getPre_a() {
		return pre_a;
	}
	public void setPre_a(int pre_a) {
		this.pre_a = pre_a;
	}
	public int getPre_b() {
		return pre_b;
	}
	public void setPre_b(int pre_b) {
		this.pre_b = pre_b;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	public boolean isTerminus() {
		return terminus;
	}
	public void setTerminus(boolean terminus) {
		this.terminus = terminus;
	}
	

}
