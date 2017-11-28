package net.erxue.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import net.erxue.po.Acupoint;
import net.erxue.po.AcupointCustom;
import net.erxue.po.Modules;
import net.erxue.vo.AcupointVo;

public interface AcupointService {
	
	//添加穴位
	public boolean addAcupoint(AcupointCustom acupointCustom,MultipartFile upload_filevideo)throws Exception;
	//添加模块
	public void addModules(Modules modules)throws Exception;
	
	//查询所有模块
	public List<Modules> findAllModulesByPage(Modules modules)throws Exception;
	public List<Modules> findAllModules()throws Exception;

	//查询所有穴位
	public  List<AcupointVo> findAllAcupointByPage(Acupoint acupoint)throws Exception;
	public  List<Acupoint> findAllAcupoints()throws Exception;

	//根据模块id查穴位
	public List<AcupointCustom> findAcupointsByModulesId(Integer modulesId)throws Exception;
	//根据id查询穴位
	public AcupointCustom findAcupointsById(Integer acupointId)throws Exception;
	public Modules findModulesById(Integer modulesId)throws Exception;
	public List<Acupoint> findAcupointsByName(Acupoint acupoint) throws Exception;
	
	//删除
	public void deleteModulesById(Integer modulesId)throws Exception;
	public void deleteAcupointByModulesId(Integer ModulesId)throws Exception;
	public void deleteAcupointById(Integer acupointId)throws Exception;
	public void deleteAllAcupoint()throws Exception;
	
	//更新
	public void updateModules(Modules modules)throws Exception;
	public void updateAcupoint(Acupoint acupoint)throws Exception;
	
	
	
	
	
	

}
