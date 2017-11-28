package net.erxue.vo;


import java.util.List;

import net.erxue.po.Acupoint;


public class AcupointVo extends Acupoint{

	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "AcupointVo ["+super.toString()+"url=" + url + "]";
	}
	
}
