package net.erxue.po;

import java.util.HashSet;
import java.util.Set;

 
//位置  模块 （穴位所属的模块）

public class Modules extends BaseBean{
	//模块编号
	private Integer modulesId;
	//模块/部位名称
	private String modulesName;
	//模块/部位描述
	private String description;
	public Integer getModulesId() {
		return modulesId;
	}
	public void setModulesId(Integer modulesId) {
		this.modulesId = modulesId;
	}
	public String getModulesName() {
		return modulesName;
	}
	public void setModulesName(String modulesName) {
		this.modulesName = modulesName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Modules [modulesId=" + modulesId + ", modulesName="
				+ modulesName + ", description=" + description + "]";
	}
 
}
