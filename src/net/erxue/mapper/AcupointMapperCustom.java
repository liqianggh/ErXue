package net.erxue.mapper;

import java.util.List;

import net.erxue.po.Acupoint;
import net.erxue.po.AcupointCustom;
import net.erxue.po.Modules;

public interface AcupointMapperCustom {

	//添加模块
	public void addModules(Modules modules)throws Exception;
	//添加穴位
	public void addAcupoint(AcupointCustom acupointCustom)throws Exception;
	//批量添加穴位
	public void addAcupoinForBatch(List<Acupoint> list )throws Exception;
	
	//根据模块id查询
	public List<AcupointCustom> findAcupointsByModulesId(int modulesId)throws Exception;
	//根据id查询
	public AcupointCustom findAcupointsById(int acupointId) throws Exception;
	//根据id集合批量查询
	public List<AcupointCustom> findAcupointsByIdList(List<Integer> idList)throws Exception;
	//查询所有
	public List<Acupoint> findAllAcupoinsByPage(Acupoint acupoint)throws Exception;
	public List<Acupoint> findAllAcupoints()throws Exception;
	//查询所有模块
	public List<Modules> findAllModulesByPage(Modules modules)throws Exception;
	public List<Modules> findAllModules()throws Exception;
	//查询部位
	public Modules findModulesById(Integer modulesId)throws Exception;
	//根据name查询学位
	public List<Acupoint> findAcupointsByNameByPage(Acupoint acupoint)throws Exception;
	public List<Acupoint> findAcupointsByName(Acupoint acupoint)throws Exception;

	
	//根据模块id删除穴位
	public void deleteAcupointsByModulesId(Integer modulesId)throws Exception;
	//根据id删除穴位
	public void deleteAcupointById(Integer acupointId)throws Exception;
	//根据模块id删模块
	public void deleteModulesById(Integer ModulesId) throws Exception;
	//删除所有穴位
	public void deleteAllAcupoint()throws Exception;
	
	//更新模块
	public void updateModules(Modules modules) throws Exception;
	//更新穴位
	public void updateAcupoint(Acupoint acupoint )throws Exception;
	
}
