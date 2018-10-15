package com.dormitoryManage.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Visitor {

	private String visitorId;
	private String visitorName;
	private String visitorSex;
	private String visitorCall;
	private String bedroomName;
	private String reason;
	private String visitorDate;
	static public String getDate(){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String time = sdf.format(date);
		return time;
	}
	
	public Visitor(){
		super();
	}
	
	public Visitor(String visitorName, String visitorCall, String visitorSex, String bedroomName, String reason) {
		super();
		this.visitorName = visitorName;
		this.visitorSex = visitorSex;
		this.visitorCall = visitorCall;
		this.bedroomName = bedroomName;
		this.reason = reason;
		this.visitorDate = getDate();
	}
	public String getVisitorId() {
		return visitorId;
	}
	public void setVisitorId(String visitorId) {
		this.visitorId = visitorId;
	}
	public String getVisitorName() {
		return visitorName;
	}
	public void setVisitorName(String visitorName) {
		this.visitorName = visitorName;
	}
	public String getVisitorSex() {
		return visitorSex;
	}
	public void setVisitorSex(String visitorSex) {
		this.visitorSex = visitorSex;
	}
	public String getVisitorCall() {
		return visitorCall;
	}
	public void setVisitorCall(String visitorCall) {
		this.visitorCall = visitorCall;
	}
	public String getBedroomName() {
		return bedroomName;
	}
	public void setBedroomName(String bedroomName) {
		this.bedroomName = bedroomName;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getVisitorDate() {
		return visitorDate;
	}
	public void setVisitorDate(String visitorDate) {
		this.visitorDate = visitorDate;
	}

	
}
