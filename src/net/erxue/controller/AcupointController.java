package net.erxue.controller;

import java.io.File;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.erxue.others.exception.UserException;
import net.erxue.po.Acupoint;
import net.erxue.po.AcupointCustom;
import net.erxue.po.Modules;
import net.erxue.service.AcupointService;
import net.erxue.vo.AcupointVo;
import net.erxue.vo.ModulesVo;

import org.apache.logging.log4j.core.helpers.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;



@Controller
@RequestMapping("/admin")
public class AcupointController {
	
	@Autowired
	private AcupointService acupointService;

	/**
	 * 添加穴位
	 * @param acupointCustom
	 * @param upload_filevideo
	 * @return boolean
	 * @throws Exception 
	 */
	@RequestMapping(value="/addAcupoint.action",method={RequestMethod.POST,RequestMethod.GET})
	public @ResponseBody boolean addAcupoint(HttpServletRequest request,
			AcupointCustom acupointCustom, 
			MultipartFile upload_filevideo,
			HttpServletResponse response
			) throws Exception{

		return acupointService.addAcupoint(acupointCustom, upload_filevideo);
	}
	
	/**
	 * 查询所有部位
	 * findAllModules
	 * @return  Modules数组
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllModules.action",method={RequestMethod.GET})
	public @ResponseBody ModulesVo findAllModules(HttpServletResponse response,Modules modules)throws Exception{
//		List<Modules> modulesList = acupointService.findAllModulesByPage(modules);
		List<Modules> modulesList = acupointService.findAllModules();
		ModulesVo vo = new ModulesVo();
		vo.setModulesList(modulesList);
//		vo.setPage(modules.getPage());
		return vo;
	}
	
	/**
	 * 查询所有穴位
	 * findAllAcupoints
	 * @return Acupoint数组
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllAcupoints.action",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody  List<Acupoint> findAllAcupoints(Acupoint acupoint)throws Exception{
		//TODO 无分类
		List<Acupoint> list = acupointService.findAllAcupoints();
//		 List<AcupointVo> list = acupointService.findAllAcupointByPage( acupoint);
		return list;
	}

	/**
	 * 添加部位
	 * addModules
	 * @param modules
	 * @return boolean
	 */
	@RequestMapping(value="/addModules.action",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody boolean addModules(Modules modules){
		try {
			acupointService.addModules(modules);
		} catch (Exception e) {
			return false;
		}
		return  true;
	}
	/**
	 * 删除穴位根据id
	 * @param acupointId
	 * @return boolean
	 */
	@RequestMapping(value="/deleteAcupointById")
	public @ResponseBody boolean deleteAcupointById(Integer acupointId) {
		if(acupointId==null){
			return false;
		}
		try {
			acupointService.deleteAcupointById(acupointId);
		} catch (Exception e) {
			System.out.println("报错"+e.getMessage());
			return false;
		}
		return true;
	}
	
	/**
	 * 跳转到更新穴位页面
	 * @param acupointId
	 * @return acupoint
	 * @throws UserException
	 */
	@RequestMapping(value="/updateAcupoint")
	public @ResponseBody Acupoint updateAcupoint(Integer acupointId) throws UserException{
		if(acupointId==null){
			throw new UserException("acupointId参数为空");
		}
		try {
			return acupointService.findAcupointsById(acupointId);
		} catch (Exception e) {
		System.out.println("报错：查询数据库失败！");
			return null;
		}
	}
	
	/**
	 * 提交更新的穴位
	 * 
	 * updateAcupointSubmit
	 * @param acupoint
	 * @return acupoint
	 */
	@RequestMapping(value="/updateAcupointSubmit" ,method={RequestMethod.POST})
	public @ResponseBody Acupoint updateAcupointSubmit(Acupoint acupoint){
		try {
			acupointService.updateAcupoint(acupoint);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("报错：更新失败！");
		}
		return acupoint;
	}
	
	/**
	 * 跳转到更新模块页面
	 * updateModules
	 * @param modulesId
	 * @return modules
	 */
	@RequestMapping(value="/updateModules",method={RequestMethod.GET})
	public @ResponseBody Modules updateModules(Integer modulesId){
		Modules modules=null;
		try {
			modules = acupointService.findModulesById(modulesId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return modules;
	}
	
	/**
	 * 提交更新部位
	 * updateModulesSubmit
	 * @param modules
	 * @return
	 */
	@RequestMapping(value="updateModulesSubmit",method={RequestMethod.POST})
	public @ResponseBody Modules updateModulesSubmit(Modules modules){
		
		try {
			acupointService.updateModules(modules);
		} catch (Exception e) {
			return null;
		}
		return modules;
	}
	
	/**
	 * 根据模块id查询穴位
	 * findAcupointsByModulesId
	 * @param modulesId
	 * @return  AcupointCustom数组
	 */
	@RequestMapping(value="findAcupointsByModulesId" ,method={RequestMethod.GET})
	public @ResponseBody List<AcupointCustom> findAcupointsByModulesId(Integer modulesId){
		try {
			return acupointService.findAcupointsByModulesId(modulesId);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("根据模块id查询穴位报错");
			return null;
		}
		
	}
	
}
