package net.erxue.service;

import java.util.List;

//import net.erxue.po.Disease;
import net.erxue.po.DiseaseCategory;
import net.erxue.po.DiseaseCategoryAndAcupoint;
import net.erxue.po.DiseaseCategoryCustom;
//import net.erxue.po.DiseaseCustom;
import net.erxue.po.DiseaseSystem;
import net.erxue.po.DiseaseSystemCustom;
import net.erxue.vo.DiseaseCategoryAndAcupointUpload;
import net.erxue.vo.DiseaseSystemAndDiseaseVo;

public interface DiseaseService {

	//查询所有疾病系统
	public List<DiseaseSystem> findAllDiseaseSystem() throws Exception;
	//查询所有疾病分类
	public List<DiseaseCategory> fidnAllDiseaseCategory()throws Exception;
	public List<DiseaseCategoryCustom> fidnAllDiseaseCategorySim(Integer systemId)throws Exception;

	//根据系统id查询疾病分类
	public List<DiseaseCategory> findDiseaseCategoryBySystemId(Integer systemId)throws  Exception;
	//根据疾病分类id查询所对应的学位
	public DiseaseCategoryCustom findDiseaseCategoryWithAcupointsById(Integer DiseaseCategoryId)throws Exception;
	public List<DiseaseSystemAndDiseaseVo> findDiseaseSystemAndDisease()throws Exception;

	//添加疾病系统
	public void addDiseaseSystem(DiseaseSystemCustom diseaseSytem) throws Exception;
	//添加疾病分类
	public void addDiseaseCategory(DiseaseCategory  diseaCategory )throws Exception;
	//添加疾病穴位
//	public void addDiseaseAcupoints(DiseaseCustom diseaseCustom)throws Exception;
	
	
	//修改疾病系统
	public void updateDiseaseSystem(DiseaseSystem diseaseSystem)throws Exception;
	//修改疾病分类
	public void updateDiseaseCategory(DiseaseCategory diseaseCategory)throws Exception;
	public DiseaseCategory findDiseaseCategoryById(Integer diseaseCategoryId)throws Exception;
	//修改疾病系统
	public DiseaseSystem findDiseaseSystemByid(Integer diseaseSystemId) throws Exception;

	
	//删除疾病系统
	public void deleteDiseaseSystemById(Integer systemsId)throws  Exception;
	//删除疾病分类
	public void deleteDiseaseCategoryById(Integer diseaseCategoryId)throws  Exception;
	public boolean addAcupointsToDisease(
			DiseaseCategoryAndAcupointUpload diseaseAcupoints)throws Exception;
	public boolean deleteDiseaseCategory(Integer diseaseCategoryId)throws Exception;
	public boolean deleteAcupointOfDisease(Integer id) throws Exception;
	
	
	
	
}
