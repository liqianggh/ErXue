package net.erxue.controller;

import java.util.List;

import net.erxue.po.Acupoint;
import net.erxue.service.AcupointService;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AcupointController_user {
	
	@Autowired
	private AcupointService acupointService;
	/**
	 * 根据name模糊查询穴位
	 * @param acupointName
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAcupointsByName.action",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody List<Acupoint>  findAcupointsByDiseaseId( Acupoint acupoint)throws Exception{
		List<Acupoint> list = acupointService.findAcupointsByName(acupoint);
		return list;
	}
	

}
