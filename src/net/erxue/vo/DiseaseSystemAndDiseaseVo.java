package net.erxue.vo;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import net.erxue.po.DiseaseCategory;
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class DiseaseSystemAndDiseaseVo {
	private Integer systemId;
	private String systemName;
	
	private List<DiseaseCategory> diseaseCategoryList = new ArrayList<DiseaseCategory>();

	public DiseaseSystemAndDiseaseVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DiseaseSystemAndDiseaseVo(Integer systemId, String systemName,
			List<DiseaseCategory> diseaseCategoryList) {
		super();
		this.systemId = systemId;
		this.systemName = systemName;
		this.diseaseCategoryList = diseaseCategoryList;
	}

	public Integer getSystemId() {
		return systemId;
	}

	public void setSystemId(Integer systemId) {
		this.systemId = systemId;
	}

	public String getSystemName() {
		return systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}

	public List<DiseaseCategory> getDiseaseCategoryList() {
		return diseaseCategoryList;
	}

	public void setDiseaseCategoryList(List<DiseaseCategory> diseaseCategoryList) {
		this.diseaseCategoryList = diseaseCategoryList;
	}

	@Override
	public String toString() {
		return "DiseaseSystemAndDiseaseVo [systemId=" + systemId
				+ ", systemName=" + systemName + ", diseaseCategoryList="
				+ diseaseCategoryList + "]";
	}
	
}
