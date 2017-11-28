package net.erxue.vo;

import java.util.ArrayList;
import java.util.List;

public class DiseaseCategoryAndAcupointUpload {
	private Integer diseaseCategoryId;
	private List<Integer> mainAcupointList=new ArrayList<Integer>();
	private List<Integer> sideAcupointList=new ArrayList<Integer>();
	public DiseaseCategoryAndAcupointUpload() {
		super();
	}
	public Integer getDiseaseCategoryId() {
		return diseaseCategoryId;
	}
	public void setDiseaseCategoryId(Integer diseaseCategoryId) {
		this.diseaseCategoryId = diseaseCategoryId;
	}
	public List<Integer> getMainAcupointList() {
		return mainAcupointList;
	}
	public void setMainAcupointList(List<Integer> mainAcupointList) {
		this.mainAcupointList = mainAcupointList;
	}
	public List<Integer> getSideAcupointList() {
		return sideAcupointList;
	}
	public void setSideAcupointList(List<Integer> sideAcupointList) {
		this.sideAcupointList = sideAcupointList;
	}
	@Override
	public String toString() {
		return "DiseaseCategoryAndAcupointUpload [diseaseCategoryId="
				+ diseaseCategoryId + ", mainAcupointList=" + mainAcupointList
				+ ", sideAcupointList=" + sideAcupointList + "]";
	}

	
}
