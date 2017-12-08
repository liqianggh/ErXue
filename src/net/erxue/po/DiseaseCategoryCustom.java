package net.erxue.po;

import java.util.ArrayList;
import java.util.List;

public class DiseaseCategoryCustom extends DiseaseCategory {
	private String systemName;
	private List<DiseaseCategoryAndAcupoint> diseaseCategoryAndAcupointList=new ArrayList<DiseaseCategoryAndAcupoint>();

	public String getSystemName() {
		return systemName;
	}
	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}

	public List<DiseaseCategoryAndAcupoint> getDiseaseCategoryAndAcupointList() {
		return diseaseCategoryAndAcupointList;
	}

	public void setDiseaseCategoryAndAcupointList(
			List<DiseaseCategoryAndAcupoint> diseaseCategoryAndAcupointList) {
		this.diseaseCategoryAndAcupointList = diseaseCategoryAndAcupointList;
	}

	@Override
	public String toString() {
		return super.toString()+ "DiseaseCategoryCustom [systemName=" + systemName
				+ ", diseaseCategoryAndAcupointList="
				+ diseaseCategoryAndAcupointList + "]";
	}
	
 

}
