package net.erxue.vo;


import java.util.List;

import net.erxue.po.Modules;
import net.erxue.po.Page;

public class ModulesVo {
	
	private List<Modules> modulesList;
	
	 private Page page ;

	public List<Modules> getModulesList() {
		return modulesList;
	}

	public void setModulesList(List<Modules> modulesList) {
		this.modulesList = modulesList;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	@Override
	public String toString() {
		return "ModulesVo [modulesList=" + modulesList + "]";
	}
	 

}
