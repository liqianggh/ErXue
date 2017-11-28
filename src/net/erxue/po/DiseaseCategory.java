package net.erxue.po;

//疾病分类实体类
public class DiseaseCategory extends BaseBean{
	private Integer diseaseCategoryId;
	//类别名
	private String diseaseCategoryName;
	//疾病的症状描述
	private String diseaseDescription;
	//所属系统
	private Integer diseaseSystemId;
	
	//疾病治疗
	private String attention;
	
	 
	public DiseaseCategory() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getAttention() {
		return attention;
	}
	public void setAttention(String attention) {
		this.attention = attention;
	}
	public Integer getDiseaseCategoryId() {
		return diseaseCategoryId;
	}
	public void setDiseaseCategoryId(Integer diseaseCategoryId) {
		this.diseaseCategoryId = diseaseCategoryId;
	}
	public String getDiseaseCategoryName() {
		return diseaseCategoryName;
	}
	public void setDiseaseCategoryName(String diseaseCategoryName) {
		this.diseaseCategoryName = diseaseCategoryName;
	}
	public String getDiseaseDescription() {
		return diseaseDescription;
	}
	public void setDiseaseDescription(String diseaseDescription) {
		this.diseaseDescription = diseaseDescription;
	}
	public Integer getDiseaseSystemId() {
		return diseaseSystemId;
	}
	public void setDiseaseSystemId(Integer diseaseSystemId) {
		this.diseaseSystemId = diseaseSystemId;
	}
	@Override
	public String toString() {
		return "DiseaseCategory [diseaseCategoryId=" + diseaseCategoryId
				+ ", diseaseCategoryName=" + diseaseCategoryName
				+ ", diseaseDescription=" + diseaseDescription
				+ ", diseaseSystemId=" + diseaseSystemId + ", attention="
				+ attention + "]";
	}
 
	 
	
}
