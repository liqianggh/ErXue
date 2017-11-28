package net.erxue.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import net.erxue.mapper.AcupointMapperCustom;
import net.erxue.po.Acupoint;
import net.erxue.po.AcupointCustom;
import net.erxue.po.Modules;
import net.erxue.service.AcupointService;
import net.erxue.vo.AcupointVo;

import org.apache.logging.log4j.core.helpers.UUIDUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;



public class AcupointServiceImpl implements AcupointService {

	@Autowired
	private AcupointMapperCustom acupointMapperCustom;

	 
	@Value("${video.urlPath}")
	private String video_urlPath;
	
	
	@Value("${video.uploadPath}")
	private String video_path;
	//添加穴位
	@Override
	public boolean addAcupoint(AcupointCustom acupointCustom,
			MultipartFile upload_filevideo) throws Exception {
		 if(upload_filevideo.isEmpty()){
			 return false;
		 }
		 
		//获取接收视频的名称
		String originalFilename = upload_filevideo.getOriginalFilename();
		//上传视频
		if(upload_filevideo!=null&&originalFilename!=null&&originalFilename.length()>0){
			//windows下的 
			//String video_path = "D:/develop/upload/video/";
			//linux下的
System.out.println(originalFilename+"文件名");
			String prefix = "";
			Calendar calendar = Calendar.getInstance();
			//给上传文件分包
			prefix+=calendar.get(Calendar.YEAR)+"/"+calendar.get(Calendar.MONTH)+"/"+calendar.get(Calendar.DAY_OF_MONTH)+"/";
			//如果文件夹不存子啊
			File file = new File(video_path+prefix);
			if(!file.exists()){
				file.mkdirs();
			}
			//拼接一个新视频的名称并存入数据库
			String newFileName = prefix+UUIDUtil.getTimeBasedUUID()+originalFilename.substring(originalFilename.lastIndexOf("."));
			//String newFileName=prefix+originalFilename;
			File newFile = new File(video_path+newFileName);
			
			if(!newFile.exists()){
				newFile.createNewFile();
			}
			try {
				  upload_filevideo.transferTo(newFile);
				acupointCustom.setVideolocation(newFileName);
System.out.println("上传文件");
acupointMapperCustom.addAcupoint(acupointCustom);
			} catch ( Exception e) {
				System.out.println("添加失败");
				e.printStackTrace();
				return false;
			}  
			
		}
		return false;
		
	}
	//添加模块
	@Override
	public void addModules(Modules modules) throws Exception {
		acupointMapperCustom.addModules(modules);
	}

	//查询所有模块
	@Override
	public List<Modules> findAllModulesByPage(Modules modules) throws Exception {
		
		return acupointMapperCustom.findAllModulesByPage(modules);
	}

	//查询所有穴位
	@Override
	public List<AcupointVo> findAllAcupointByPage(Acupoint acupoint) throws Exception {
		List<Acupoint> list = acupointMapperCustom.findAllAcupoinsByPage(acupoint);
		List<AcupointVo> result = new ArrayList<AcupointVo>();
		for(Acupoint  resultAcupoint:list){
			AcupointVo apvo = new AcupointVo();
			BeanUtils.copyProperties(resultAcupoint, apvo);
			apvo.setUrl(video_urlPath+resultAcupoint.getVideolocation());
			result.add(apvo);
		}
		return result;
	}
 
	//根据模块id查询穴位
	@Override
	public List<AcupointCustom> findAcupointsByModulesId(Integer modulesId)
			throws Exception {
		List<AcupointCustom> list = acupointMapperCustom.findAcupointsByModulesId(modulesId);
		for(AcupointCustom acu:list){
			acu.setUrl(video_urlPath+acu.getVideolocation());
		}
		
		return list;
	}
	//根据id查询穴位
	@Override
	public AcupointCustom findAcupointsById(Integer acupointId)
			throws Exception {
		AcupointCustom acupoint = acupointMapperCustom.findAcupointsById(acupointId);
				acupoint.setUrl(video_urlPath+acupoint.getVideolocation());
		return acupoint;
	}
	
	@Override
	public List<Acupoint> findAcupointsByName(Acupoint acupoint) throws Exception{
		
//		return acupointMapperCustom.findAcupointsByNameByPage(acupoint);
		return acupointMapperCustom.findAcupointsByName(acupoint);
		
	}
	
	//删除模块
	@Override
	public void deleteModulesById(Integer modulesId) throws Exception {

		acupointMapperCustom.deleteModulesById(modulesId);
	}
	@Override
	public void deleteAcupointByModulesId(Integer modulesId) throws Exception {

		acupointMapperCustom.deleteAcupointsByModulesId(modulesId);
	}
	@Override
	public void deleteAcupointById(Integer acupointId) throws Exception {
		acupointMapperCustom.deleteAcupointById(acupointId);
		
	}
	@Override
	public void deleteAllAcupoint() throws Exception {
		
		acupointMapperCustom.deleteAllAcupoint();
	}
	@Override
	public void updateModules(Modules modules) throws Exception {

		acupointMapperCustom.updateModules(modules);
	}
	@Override
	public void updateAcupoint(Acupoint acupoint) throws Exception {
		acupointMapperCustom.updateAcupoint(acupoint);
	}
	//根据模块id查询模块
	@Override
	public Modules findModulesById(Integer modulesId) throws Exception {

		return acupointMapperCustom.findModulesById(modulesId);
	}
	@Override
	public List<Modules> findAllModules() throws Exception {
		
		return acupointMapperCustom.findAllModules();
	}
	
	@Override
	public List<Acupoint> findAllAcupoints() throws Exception {

		return acupointMapperCustom.findAllAcupoints();
	}
 
}
