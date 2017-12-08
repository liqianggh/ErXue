package net.erxue.po;

public class AcupointCustom extends Acupoint {

	private String url;
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	//穴位类型如：主穴
	private String acupointType;

	public String getAcupointType() {
		return acupointType;
	}

	public void setAcupointType(String acupointType) {
		this.acupointType = acupointType;
	} 
	
	@Override
	public String toString() {
		return "AcupointCustom ["+super.toString()+"url=" + url + ", acupointType=" + acupointType
				+ "]";
	}

}
