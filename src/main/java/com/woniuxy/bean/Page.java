package com.woniuxy.bean;

import java.util.List;

public class Page<T> {
	private int p;			//��ǰ ҳ��
	private int rowCount;	//������
	private int maxPage;	//��ҳ��
	private int prev;		//��һҳ
	private int next;		//��һҳ
	private int startline;	//��ʼ��
	private int size;		//ÿҳ��ʾ����
	private int startPage;	//��ʼҳ
	private int endPage;	//����ҳ
	private List<T> list; 	//��ҳ����
	
	public Page(int pg,int rc,int sz) {
		p = pg;
		rowCount = rc;
		size = sz;
		
		maxPage = (int) Math.ceil(rowCount*1.0/size);//�����ҳ��
		
		if(p>maxPage) p=maxPage;
		if(p<1) p=1;
		
		prev = p-1;
		next = p+1;
		//������ʼ��   (��ǰҳ��-1)*ÿҳ��ʾ����
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
