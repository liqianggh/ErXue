package net.erxue.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.erxue.po.DiseaseCategory;
import net.erxue.po.DiseaseCategoryAndAcupoint;
import net.erxue.po.DiseaseCategoryCustom;
import net.erxue.po.DiseaseSystem;
import net.erxue.po.DiseaseSystemCustom;
import net.erxue.service.DiseaseService;
import net.erxue.vo.DiseaseCategoryAndAcupointUpload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/admin")
@Controller
public class DiseaseController {

	@Autowired
	private DiseaseService diseaseServiceImpl;

	/**
	 * 添加疾病系统  
	 * addDiseaseSystem.action
	 * @param diseaseSytem
	 * @return true/false
	 */
	@RequestMapping(value="/addDiseaseSystem.action",method={RequestMethod.POST})
	public @ResponseBody boolean addDiseaseSytem(DiseaseSystemCustom diseaseSytem,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");

		try {
			diseaseServiceImpl.addDiseaseSystem(diseaseSytem);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return false;
		}
		return true;
	}
	
	
	//添加疾病分类
	@RequestMapping(value="/addDiseaseCategory.action",method={RequestMethod.POST})
	public @ResponseBody boolean addDiseaseCategeory(DiseaseCategory  diseaCategory ,HttpServletResponse response){
System.out.println(diseaCategory+"接收到的数据");
		response.setHeader("Access-Control-Allow-Origin", "*");
		if(diseaCategory==null){
			return false;
		}
		try {
			diseaseServiceImpl.addDiseaseCategory(diseaCategory);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	/**添加治疗疾病所需要的穴位疾病（主穴或配穴）
	 * addAcupointsToDisease.action
	 * @param diseaseCustom 
	 * @return  true/false
	 */
	@RequestMapping(value="/addAcupointsToDisease.action",method={RequestMethod.POST})
	public @ResponseBody boolean addAcupointsToDisease(DiseaseCategoryAndAcupointUpload diseaseAcupoints ){
		if(diseaseAcupoints==null||diseaseAcupoints.getMainAcupointList().isEmpty()){
			return false;
		}else{
			try {
				return diseaseServiceImpl.addAcupointsToDisease(diseaseAcupoints);
			} catch (Exception e) {
				System.out.println("添加疾病对应学位报错了");
				e.printStackTrace();
				return false;
			}
		}
	}
	
	//查询所有疾病系统
	@RequestMapping(value="/findAllDiseaseSystem.action",method={RequestMethod.GET})
	public @ResponseBody List<DiseaseSystem> findAllDiseaseSystem() throws Exception{
		List<DiseaseSystem> diseaseSytemList=diseaseServiceImpl.findAllDiseaseSystem();
		return diseaseSytemList;
	}
	//查询所有疾病分类
	@RequestMapping(value="/findAllDiseaseCategory",method={RequestMethod.GET})
	public @ResponseBody List<DiseaseCategoryCustom> findAllDiseaseCategory(HttpServletResponse response,Integer systemId){
		response.setHeader("Access-Control-Allow-Origin", "*");

		try {
			return diseaseServiceImpl.fidnAllDiseaseCategorySim(systemId);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("报错：查询疾病分类出错");
			return null;
		}
		
	}	
	/**
	 * 根据疾病分类id查询疾病对应的穴位
	 * findDiseaseCategoryWithAcupointsById.action
	 * @param diseaseCategoryId
	 * @return
	 */
	@RequestMapping(value="/findDiseaseCategoryWithAcupointsById.action",method={RequestMethod.GET,RequestMethod.POST})
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
	
	//修改疾病分类(返回疾病分类信息)
	@RequestMapping(value="/updateDiseaseCategory.action",method={RequestMethod.GET})
	public @ResponseBody DiseaseCategory updateDiseaseCategory(Integer diseaseCategoryId){
		
		try {
			return diseaseServiceImpl.findDiseaseCategoryById(diseaseCategoryId);
		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}
	}
	@RequestMapping(value="/updateDiseaseCategorySubmit",method={RequestMethod.POST})
	public @ResponseBody DiseaseCategory updateDiseaseCategorySubmit(DiseaseCategory diseaseCategory){
		
		try {
			 diseaseServiceImpl.updateDiseaseCategory(diseaseCategory);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return diseaseCategory;
	}
	/**
	 * 修改疾病系统
	 * updateDiseaseSystem.action
	 * @param diseaseSystemId 接收参数
	 * @return DiseaseSystem 返回所要修改的疾病系统对象
	 */
	@RequestMapping(value="/updateDiseaseSystem",method={RequestMethod.GET})
	public @ResponseBody DiseaseSystem updateDiseaseSystem(Integer diseaseSystemId){
		
		try {
			return diseaseServiceImpl.findDiseaseSystemByid(diseaseSystemId);
		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 提交修改疾病系统信息
	 * updateDiseaseSystemSubmit.action
	 * @param diseaseSystem 接收的参数
	 * @return true/false 返回值
	 */
	@RequestMapping(value="/updateDiseaseSystemSubmit",method={RequestMethod.POST })
	public @ResponseBody DiseaseSystem updateDiseaseSystemSubmit(DiseaseSystem diseaseSystem ){
		
		try {
			diseaseServiceImpl.updateDiseaseSystem(diseaseSystem);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return diseaseSystem;
	}
	
	/**删除疾病系统
	 * deleteDiseaseSystemById.action
	 * @param systemsId
	 * @return true/false 返回值
	 */
	@RequestMapping(value="/deleteDiseaseSystemById",method={RequestMethod.POST ,RequestMethod.GET})
	public @ResponseBody boolean updateDiseaseSystemSubmit(Integer systemsId ){
		
		try {
			diseaseServiceImpl.deleteDiseaseSystemById(systemsId);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**删除疾病系统
	 * deleteDiseaseCategory.action
	 * @param diseaseCategoryId
	 * @return true/false 返回值
	 */
	@RequestMapping(value="/deleteDiseaseCategory.action",method={RequestMethod.POST ,RequestMethod.GET})
	public @ResponseBody boolean deleteDiseaseCategory(Integer diseaseCategoryId ){
		
		if(diseaseCategoryId==null){
			return false;
		}
		
		try {
			return diseaseServiceImpl.deleteDiseaseCategory(diseaseCategoryId);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 删除疾病的某个穴位
	 * deleteAcupointOfDisease.ation
	 * @param id
	 * return true/false
	 */
	@RequestMapping(value="/deleteAcupointOfDisease.action",method={RequestMethod.POST ,RequestMethod.GET})
	public @ResponseBody boolean deleteAcupointOfDisease(Integer id){
		if(id==null){
			return false;
		}
		
		try {
			return diseaseServiceImpl.deleteAcupointOfDisease(id);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
