package net.erxue.po;

//穴位
public class Acupoint extends BaseBean{
	//穴位编号
	private Integer AcupointId;
	private String acupointName;
	//穴位视频的地址
	private String videolocation;
	//穴位描述
	private String description;
	//穴位所属的模块id
	private Integer modulesId;
 
	public String getAcupointName() {
		return acupointName;
	}
	public void setAcupointName(String acupointName) {
		this.acupointName = acupointName;
	}
	public Integer getAcupointId() {
		return AcupointId;
	}
	public void setAcupointId(Integer acupointId) {
		AcupointId = acupointId;
	}
	public String getVideolocation() {
		return videolocation;
	}
	public void setVideolocation(String videolocation) {
		this.videolocation = videolocation;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getModulesId() {
		return modulesId;
	}
	public void setModulesId(Integer modulesId) {
		this.modulesId = modulesId;
	}
	@Override
	public String toString() {
		return "Acupoint [AcupointId=" + AcupointId + ", acupointName="
				+ acupointName + ", videolocation=" + videolocation
				+ ", description=" + description + ", modulesId=" + modulesId
				+ "]";
	}
 
}
