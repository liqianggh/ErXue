package net.erxue.po;

/**
 * @description:用户权限，即每个用户可以查看疾病穴位的权限
 * @author Administrator
 * @date 2017-11-29:下午5:22:19
 */
public class UserJurisdiction {
	//用户id
	private Integer uid;
	//疾病id
	private Integer diseaseCategoryId;
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Integer getDiseaseCategoryId() {
		return diseaseCategoryId;
	}
	public void setDiseaseCategoryId(Integer diseaseCategoryId) {
		this.diseaseCategoryId = diseaseCategoryId;
	}
	
	@Override
	public String toString() {
		return "UserJurisdiction [uid=" + uid + ", diseaseCategoryId="
				+ diseaseCategoryId + "]";
	}

}
