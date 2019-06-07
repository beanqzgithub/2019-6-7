package com.woniuxy.bean;

import java.util.List;

public class Page<T> {
	private int p;			//当前 页数
	private int rowCount;	//总行数
	private int maxPage;	//总页数
	private int prev;		//上一页
	private int next;		//下一页
	private int startline;	//起始行
	private int size;		//每页显示行数
	private int startPage;	//起始页
	private int endPage;	//结束页
	private List<T> list; 	//分页数据
	
	public Page(int pg,int rc,int sz) {
		p = pg;
		rowCount = rc;
		size = sz;
		
		maxPage = (int) Math.ceil(rowCount*1.0/size);//算出总页数
		
		if(p>maxPage) p=maxPage;
		if(p<1) p=1;
		
		prev = p-1;
		next = p+1;
		//计算起始行   (当前页数-1)*每页显示行数
		startline = (p-1)*size;
		
		if(maxPage<10) {
			startPage=1;
			endPage=maxPage;
		}else {
			startPage = p -5;
			endPage = p+4;
			
			if(startPage<1) {
				startPage=1;
				endPage=10;
			}
			if(endPage>maxPage) {
				startPage=maxPage-9;
				endPage=maxPage;
			}
		}
		
	}
	
	public int getP() {
		return p;
	}
	public void setP(int p) {
		this.p = p;
	}
	public int getRowCount() {
		return rowCount;
	}
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	public int getPrev() {
		return prev;
	}
	public void setPrev(int prev) {
		this.prev = prev;
	}
	public int getNext() {
		return next;
	}
	public void setNext(int next) {
		this.next = next;
	}
	public int getStartline() {
		return startline;
	}
	public void setStartline(int startline) {
		this.startline = startline;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
	
}
