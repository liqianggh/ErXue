package net.erxue.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.erxue.po.DiseaseCategory;
import net.erxue.po.DiseaseCategoryAndAcupoint;
import net.erxue.po.DiseaseCategoryCustom;
import net.erxue.po.DiseaseSystem;
import net.erxue.service.DiseaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DiseaseController_user {
	
	
	@Autowired
	private DiseaseService diseaseServiceImpl;
	
	/**
	 * 查询所有疾病系统
	 * findAllDiseaseSystem.action
 	 * @return DiseaseSystem
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllDiseaseSystem.action",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody List<DiseaseSystem > findAllAcupoints()throws Exception{
		List<DiseaseSystem> list = diseaseServiceImpl.findAllDiseaseSystem();
		return list;
	}
	
	/**
	 * 根据系统id查询所有分类
	 * findDiseaseCategoryBySystemId.action
	 * @param systemId
	 */
	@RequestMapping(value="/findDiseaseCategoryBySystemId.action",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody List<DiseaseCategory > findDiseaseCategoryBySystemId(Integer systemId)throws Exception{
		List<DiseaseCategory> list = diseaseServiceImpl.findDiseaseCategoryBySystemId(systemId);
		return list;
	}
	
	/**
	 * 根据疾病分类id查询疾病对应的穴位
	 * findDiseaseCategoryWithAcupointsById.action
	 * @param diseaseCategoryId
	 * @return
	 */
	@RequestMapping(value="/user/findDiseaseCategoryWithAcupointsById.action",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody DiseaseCategoryCustom findDiseaseCategoryWithAcupointsById( Integer diseaseCategoryId,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
		try {
			return diseaseServiceImpl.findDiseaseCategoryWithAcupointsById(diseaseCategoryId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	

	
}
