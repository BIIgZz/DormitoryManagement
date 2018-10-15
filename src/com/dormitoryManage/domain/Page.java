package com.dormitoryManage.domain;

import java.util.ArrayList;
import java.util.List;

public class Page<E> {
	private List<E> pageList =new ArrayList<E>();
	private int pageTotal;
	private int pageNo;
	private int TotalCount;
	private int totalPage;
	
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalCount() {
		return TotalCount;
	}
	public void setTotalCount(int totalCount) {
		TotalCount = totalCount;
	}
	public List<E> getPageList() {
		return pageList;
	}
	public void setPageList(List<E> pageList) {
		this.pageList = pageList;
	}
	public int getPageTotal() {
		return pageTotal;
	}
	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	

}
