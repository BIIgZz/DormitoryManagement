package com.dormitoryManage.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Announcement {

	private String announcementId;
	private String title;
	private String content;
	private String createTime;
	static public String getTime(){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sdf.format(date);
		return time;
	}
	
	public Announcement() {
		super();
	}
	
	public Announcement(String title, String content) {
		super();
		this.title = title;
		this.content = content;
		this.createTime = getTime();
	}
	public String getAnnouncementId() {
		return announcementId;
	}
	public void setAnnouncementId(String announcementId) {
		this.announcementId = announcementId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
}
