package net.erxue.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.erxue.po.DiseaseCategory;
import net.erxue.po.DiseaseCategoryCustom;
import net.erxue.po.DiseaseSystem;
import net.erxue.po.User;
import net.erxue.po.UserJurisdiction;
import net.erxue.service.DiseaseService;
import net.erxue.service.UserService;

import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.mail.iap.Response;

@Controller
public class DiseaseController_user {

	@Autowired
	private DiseaseService diseaseServiceImpl;
	@Autowired
	private UserService userService;

	/**
	 * 查询所有疾病系统 findAllDiseaseSystem.action
	 * 
	 * @return DiseaseSystem
	 * @throws Exception
	 */
	@RequestMapping(value = "/findAllDiseaseSystem.action", method = {
			RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	List<DiseaseSystem> findAllAcupoints() throws Exception {
		List<DiseaseSystem> list = diseaseServiceImpl.findAllDiseaseSystem();
		return list;
	}

	/**
	 * 根据系统id查询所有分类 findDiseaseCategoryBySystemId.action
	 * 
	 * @param systemId
	 */
	@RequestMapping(value = "/findDiseaseCategoryBySystemId.action", method = {
			RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	List<DiseaseCategory> findDiseaseCategoryBySystemId(Integer systemId)
			throws Exception {
		List<DiseaseCategory> list = diseaseServiceImpl
				.findDiseaseCategoryBySystemId(systemId);
		return list;
	}

	/**
	 * 根据疾病分类id查询疾病对应的穴位 findDiseaseCategoryWithAcupointsById.action
	 * 
	 * @param diseaseCategoryId
	 * @return
	 */
	@RequestMapping(value = "/user/findDiseaseCategoryWithAcupointsById.action", method = {
			RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	DiseaseCategoryCustom findDiseaseCategoryWithAcupointsById(
			Integer diseaseCategoryId, HttpSession session,HttpServletResponse response) {
		try {
			if (diseaseCategoryId == null) {
				return null;
			} else {
				UserJurisdiction userJ = new UserJurisdiction();
				User user = (User) session.getAttribute("user");
				if(user==null){
					return null;
				}
				userJ.setUid(user.getUid());
				userJ.setDiseaseCategoryId(diseaseCategoryId);

				// 判断是否有访问这个的权利
				boolean flag = userService.isHaveAuthority(userJ);
				if (flag == false) {
						 response.setHeader("sessionStatus", "noAuthority");
						 response.sendError(665, "You have no jurisdiction!");
						return null;
				} else {
					return diseaseServiceImpl
							.findDiseaseCategoryWithAcupointsById(diseaseCategoryId);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
