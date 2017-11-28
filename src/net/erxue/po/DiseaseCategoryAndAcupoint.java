package net.erxue.po;

import java.util.List;

public class DiseaseCategoryAndAcupoint {
	//疾病与穴位
	private Integer id;
	 //疾病id与穴位id
	private Integer diseaseCategoryId;
	private Integer acupointId;
	private String acupointType;
	private Integer modulesId;
	private String description;
	private String videoLocation;
	private String acupointName;
	
	
	
 
	public String getAcupointName() {
		return acupointName;
	}
	public void setAcupointName(String acupointName) {
		this.acupointName = acupointName;
	}
	public String getVideoLocation() {
		return videoLocation;
	}
	public void setVideoLocation(String videoLocation) {
		this.videoLocation = videoLocation;
	}
	public Integer getModulesId() {
		return modulesId;
	}
	public void setModulesId(Integer modulesId) {
		this.modulesId = modulesId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getDiseaseCategoryId() {
		return diseaseCategoryId;
	}
	public void setDiseaseCategoryId(Integer diseaseCategoryId) {
		this.diseaseCategoryId = diseaseCategoryId;
	}
	public Integer getAcupointId() {
		return acupointId;
	}
	public void setAcupointId(Integer acupointId) {
		this.acupointId = acupointId;
	}
	public String getAcupointType() {
		return acupointType;
	}
	public void setAcupointType(String acupointType) {
		this.acupointType = acupointType;
	}
	@Override
	public String toString() {
		return "DiseaseCategoryAndAcupoint [id=" + id + ", diseaseCategoryId="
				+ diseaseCategoryId + ", acupointId=" + acupointId
				+ ", acupointType=" + acupointType + ", modulesId=" + modulesId
				+ ", description=" + description + ", videoLocation="
				+ videoLocation + ", acupointName=" + acupointName + "]";
	}
}
