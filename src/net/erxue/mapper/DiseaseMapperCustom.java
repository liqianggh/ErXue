package net.erxue.mapper;

import java.util.List;

import net.erxue.po.DiseaseCategory;
import net.erxue.po.DiseaseCategoryAndAcupoint;
import net.erxue.po.DiseaseCategoryCustom;
//import net.erxue.po.DiseaseCustom;
import net.erxue.po.DiseaseSystem;
import net.erxue.po.DiseaseSystemCustom;
import net.erxue.vo.DiseaseCategoryAndAcupointUpload;
import net.erxue.vo.DiseaseSystemAndDiseaseVo;

public interface DiseaseMapperCustom {
	
	//添加疾病系统、疾病分类、疾病
	public void addDiseaseSystem(DiseaseSystem diseaseSystem)throws Exception;
	public int addDiseaseCategory(DiseaseCategory diseaseCategory)throws Exception;
	
//	
//	//添加疾病穴位
//	public void addDiseaseAndAcupointList(DiseaseCustom diseaseCustom)throws Exception;
//	
//	//根据疾病的id查询穴位
//	public DiseaseCustom findAcupointsByDiseaseId(Integer id)throws Exception;
	//查询疾病所有系统 
	public List<DiseaseSystem> findAllDiseaseSystems()throws Exception;
	//根据系统id查询分类List<DiseaseCategory>
	public List<DiseaseCategory> findDiseaseCategoryBySystemId(int systemId)throws Exception;
	//查询所有疾病系统分类
	public List<DiseaseCategory> findAllDiseaseCategory()throws Exception;
	//根据id查询疾病分类
	public DiseaseCategory findDiseaseCategoryById(Integer diseaseCategoryId)throws Exception;
	//查询所有疾病（含穴位）
	public List<DiseaseCategoryCustom> findAllDiseaseCategoryWithAcupoints()throws Exception;
	//根据疾病分类查询疾病和它所对应的穴位
	public  DiseaseCategoryCustom findDiseaseCategoryWithAcupointsById(Integer diseaseCategoryId)throws Exception;
	
	public List<DiseaseSystemAndDiseaseVo> findAllDiseaseSystemAndDisease()throws Exception;
	
	//修改疾病系统
	public void updateDiseaseSystem(DiseaseSystem diseaseSystem )throws Exception;
	//修改疾病分类
	public void updateDiseaseCategory(DiseaseCategory diseaseCategory)throws Exception;
	
	//根据id查询疾病系统
	public DiseaseSystem findDiseaseSystemById(Integer diseaseSystemId) throws Exception;
	//删除
	public void deleteDiseaseSystemById(Integer systemId)throws Exception;
	public int deleteDiseaseCategoryById(Integer diseaseCategoryId)throws Exception;
//	public DiseaseCustom findDiseaseById(int diseaseId)throws Exception;
	public int addAcupointsToDisease(
			DiseaseCategoryAndAcupointUpload diseaseAcupoints) throws Exception;
	public List<DiseaseCategoryCustom> findAllDiseaseCategorySim(Integer systemId);
	public int deleteAcupointOfDisease(Integer  id) throws Exception;
	
	
}
