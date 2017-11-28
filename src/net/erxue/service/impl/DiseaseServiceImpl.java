package net.erxue.service.impl;

import java.util.List;

import net.erxue.mapper.DiseaseMapperCustom;
import net.erxue.po.DiseaseCategory;
import net.erxue.po.DiseaseCategoryAndAcupoint;
import net.erxue.po.DiseaseCategoryCustom;
import net.erxue.po.DiseaseSystem;
import net.erxue.po.DiseaseSystemCustom;
import net.erxue.service.DiseaseService;
import net.erxue.vo.DiseaseCategoryAndAcupointUpload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
public class DiseaseServiceImpl implements DiseaseService {

	@Autowired
	private DiseaseMapperCustom diseaseMapper;
	@Value("${video.urlPath}")
	private String url;
	 
	@Override
	public List<DiseaseSystem> findAllDiseaseSystem() throws Exception {
		return diseaseMapper.findAllDiseaseSystems();
	}

	// 添加疾病系统
	@Override
	public void addDiseaseSystem(DiseaseSystemCustom diseaseSystemCustom)
			throws Exception {
		diseaseMapper.addDiseaseSystem(diseaseSystemCustom);
	}

	// 添加疾病分类
	@Override
	public void addDiseaseCategory(DiseaseCategory  diseaCategory )
			throws Exception {
		diseaseMapper.addDiseaseCategory(diseaCategory );
	}

	// 查询所有疾病系统
	@Override
	public List<DiseaseCategory> fidnAllDiseaseCategory() throws Exception {
		return diseaseMapper.findAllDiseaseCategory();
	}
 

	// 修改疾病系统
	@Override
	public void updateDiseaseSystem(DiseaseSystem diseaseSystem)
			throws Exception {
		diseaseMapper.updateDiseaseSystem(diseaseSystem);
	}

	// 修改疾病分类
	@Override
	public void updateDiseaseCategory(DiseaseCategory diseaseCategory)
			throws Exception {
		diseaseMapper.updateDiseaseCategory(diseaseCategory);
	}

	
	@Override
	public DiseaseCategory findDiseaseCategoryById(Integer diseaseCategoryId)
			throws Exception {
		return diseaseMapper.findDiseaseCategoryById(diseaseCategoryId);
	}

	// 修改疾病系统
	@Override
	public DiseaseSystem findDiseaseSystemByid(Integer diseaseSystemId)
			throws Exception {
		return diseaseMapper.findDiseaseSystemById(diseaseSystemId);
	}

	// 删除
	@Override
	public void deleteDiseaseSystemById(Integer systemsId) throws Exception {
		diseaseMapper.deleteDiseaseSystemById(systemsId);

	}

	//删除疾病分类
	@Override
	public void deleteDiseaseCategoryById(Integer diseaseCategoryId)
			throws Exception {
		diseaseMapper.deleteDiseaseCategoryById(diseaseCategoryId);
	}
 

	//根据系统分类id查询疾病分类
	@Override
	public List<DiseaseCategory> findDiseaseCategoryBySystemId(Integer systemId)
			throws Exception {
		return diseaseMapper.findDiseaseCategoryBySystemId(systemId);
	}

	//查询疾病和所对应学位
	@Override
	public DiseaseCategoryCustom findDiseaseCategoryWithAcupointsById(
			Integer diseaseCategoryId) throws Exception {
		DiseaseCategoryCustom diseaseCategoryCustom=diseaseMapper.findDiseaseCategoryWithAcupointsById(diseaseCategoryId);
		List<DiseaseCategoryAndAcupoint> dcaList = diseaseCategoryCustom.getDiseaseCategoryAndAcupointList();
		if(!dcaList.isEmpty()){
			for(DiseaseCategoryAndAcupoint dca :dcaList){
				dca.setVideoLocation(url+dca.getVideoLocation());
			}
		}
	
		
		return diseaseCategoryCustom;
	}

	@Override
	public boolean addAcupointsToDisease(
			DiseaseCategoryAndAcupointUpload diseaseAcupoints) throws Exception {
		int result = diseaseMapper.addAcupointsToDisease(diseaseAcupoints);
		if(result>0){
			return true;
		}else{

			return false;
		}
	}

	@Override
	public List<DiseaseCategoryCustom> fidnAllDiseaseCategorySim(Integer systemId)
			throws Exception {
		
		return diseaseMapper.findAllDiseaseCategorySim(systemId);
	}

	@Override
	public boolean deleteDiseaseCategory(Integer diseaseCategoryId) throws Exception {
		int x = diseaseMapper.deleteDiseaseCategoryById(diseaseCategoryId);
		if(x==1){
			return true;
		}
		
		return false;
	}

	@Override
	public boolean deleteAcupointOfDisease(Integer id)
			throws Exception {
		
		int x = diseaseMapper.deleteAcupointOfDisease(id);
		if(x==1){
			return true;
		}
		return false;
	}

}
