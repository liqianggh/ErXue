package net.erxue.vo;


import java.util.List;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import net.erxue.po.Acupoint;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
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
