package net.erxue.po;
//疾病所属系统实体类
public class DiseaseSystem {
	//系统id
	private Integer systemId;
	//系统名称
	private String systemName;
	
	
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
	
	
	@Override
	public String toString() {
		return "DiseaseSystem [systemId=" + systemId + ", systemName="
				+ systemName + "]";
	}
	
	

}
