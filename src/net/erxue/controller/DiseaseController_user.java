package net.erxue.controller;

import java.util.ArrayList;
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
import net.erxue.vo.DiseaseSystemAndDiseaseVo;
import net.sf.json.JSON;

import org.apache.http.HttpResponse;
import org.json.JSONArray;
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
	 * http://111.230.236.54:8080/ErXueSSM/findAllDiseaseSystemWithDisease.action
	 * @description:查询你所有疾病系统和疾病
	 * @methodName:findAllDiseaseSystemWithDisease
	 * @return List DiseaseSystemAndDiseaseVo
	 */
	@RequestMapping(value="/findAllDiseaseSystemWithDisease.action", produces = "application/json; charset=utf-8",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody List<DiseaseSystemAndDiseaseVo>  findAllDiseaseSystemWithDisease(){
		//查询数据库
		List<DiseaseSystemAndDiseaseVo> list = new ArrayList<DiseaseSystemAndDiseaseVo>();
		try {
			list = diseaseServiceImpl.findDiseaseSystemAndDisease();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("查询疾病系统和疾病报错！");
		}
		//直接返回静态数据
	//	String str = "[{\"systemId\":1,\"systemName\":\"运动系统疾病\",\"diseaseCategoryList\":[{\"diseaseCategoryId\":1,\"diseaseCategoryName\":\"急性关节扭伤、挫伤\"},{\"diseaseCategoryId\":2,\"diseaseCategoryName\":\"落枕\"},{\"diseaseCategoryId\":3,\"diseaseCategoryName\":\"肩周炎\"},{\"diseaseCategoryId\":4,\"diseaseCategoryName\":\"风湿性关节炎\"},{\"diseaseCategoryId\":5,\"diseaseCategoryName\":\"类风湿关节炎\"},{\"diseaseCategoryId\":6,\"diseaseCategoryName\":\"骨关节炎\"},{\"diseaseCategoryId\":9,\"diseaseCategoryName\":\"肾虚腰痛\"},{\"diseaseCategoryId\":10,\"diseaseCategoryName\":\"腰痛（棘间韧带、椎旁韧带劳损）\"},{\"diseaseCategoryId\":11,\"diseaseCategoryName\":\"骶髂关节炎\"},{\"diseaseCategoryId\":12,\"diseaseCategoryName\":\"坐骨神经痛\"},{\"diseaseCategoryId\":13,\"diseaseCategoryName\":\"臀部肌纤维炎\"},{\"diseaseCategoryId\":14,\"diseaseCategoryName\":\"腓肠肌痉挛（小腿抽筋）\"},{\"diseaseCategoryId\":15,\"diseaseCategoryName\":\"足跟痛、跟骨骨质增生\"},{\"diseaseCategoryId\":16,\"diseaseCategoryName\":\"足底痛\"},{\"diseaseCategoryId\":17,\"diseaseCategoryName\":\"颈椎病\"},{\"diseaseCategoryId\":18,\"diseaseCategoryName\":\"多发性肌纤维炎\"},{\"diseaseCategoryId\":19,\"diseaseCategoryName\":\"肩背肌纤维炎\"},{\"diseaseCategoryId\":20,\"diseaseCategoryName\":\"网球肘（高尔夫球肘）\"},{\"diseaseCategoryId\":21,\"diseaseCategoryName\":\"腕管综合症\"},{\"diseaseCategoryId\":22,\"diseaseCategoryName\":\"狭窄性腱鞘炎\"},{\"diseaseCategoryId\":23,\"diseaseCategoryName\":\"腱鞘囊肿\"},{\"diseaseCategoryId\":27,\"diseaseCategoryName\":\"腰肌劳损\"},{\"diseaseCategoryId\":28,\"diseaseCategoryName\":\"膝关节痛\"},{\"diseaseCategoryId\":29,\"diseaseCategoryName\":\"肋软骨炎\"},{\"diseaseCategoryId\":30,\"diseaseCategoryName\":\"尾椎挫伤\"}]},{\"systemId\":2,\"systemName\":\"眼科疾病\",\"diseaseCategoryList\":[{\"diseaseCategoryId\":31,\"diseaseCategoryName\":\"急性结膜炎\"},{\"diseaseCategoryId\":32,\"diseaseCategoryName\":\"睑腺炎（麦粒肿、针眼）\"},{\"diseaseCategoryId\":33,\"diseaseCategoryName\":\"球结核膜出血\"},{\"diseaseCategoryId\":34,\"diseaseCategoryName\":\"近视\"},{\"diseaseCategoryId\":35,\"diseaseCategoryName\":\"青光眼\"},{\"diseaseCategoryId\":36,\"diseaseCategoryName\":\"中心性视网膜炎\"},{\"diseaseCategoryId\":37,\"diseaseCategoryName\":\"视神经炎、视神经萎缩\"},{\"diseaseCategoryId\":38,\"diseaseCategoryName\":\"眼睑痉挛\"},{\"diseaseCategoryId\":39,\"diseaseCategoryName\":\"弱视\"},{\"diseaseCategoryId\":40,\"diseaseCategoryName\":\"老年性白内障\"},{\"diseaseCategoryId\":41,\"diseaseCategoryName\":\"屈光不正、眉心痛\"},{\"diseaseCategoryId\":42,\"diseaseCategoryName\":\"角膜炎\"}]},{\"systemId\":3,\"systemName\":\"循环系统疾病\",\"diseaseCategoryList\":[{\"diseaseCategoryId\":43,\"diseaseCategoryName\":\"高血压病\"},{\"diseaseCategoryId\":44,\"diseaseCategoryName\":\"低血压病\"},{\"diseaseCategoryId\":45,\"diseaseCategoryName\":\"心血管神经官能症\"},{\"diseaseCategoryId\":46,\"diseaseCategoryName\":\"心肌炎\"}]},{\"systemId\":4,\"systemName\":\"血液系统疾病\",\"diseaseCategoryList\":[{\"diseaseCategoryId\":48,\"diseaseCategoryName\":\"缺铁性贫血\"}]},{\"systemId\":5,\"systemName\":\"消化系统疾病\",\"diseaseCategoryList\":[{\"diseaseCategoryId\":49,\"diseaseCategoryName\":\"慢性胃炎\"},{\"diseaseCategoryId\":50,\"diseaseCategoryName\":\"胃、十二指肠溃疡\"},{\"diseaseCategoryId\":51,\"diseaseCategoryName\":\"十二指肠球炎\"},{\"diseaseCategoryId\":52,\"diseaseCategoryName\":\"便秘\"},{\"diseaseCategoryId\":53,\"diseaseCategoryName\":\"反酸、恶心\"},{\"diseaseCategoryId\":54,\"diseaseCategoryName\":\"膈肌痉挛（呃逆、打呃）\"},{\"diseaseCategoryId\":55,\"diseaseCategoryName\":\"食管炎\"},{\"diseaseCategoryId\":56,\"diseaseCategoryName\":\"胃肠道功能紊乱（胃肠神经官能症）\"},{\"diseaseCategoryId\":57,\"diseaseCategoryName\":\"消化不良\"},{\"diseaseCategoryId\":58,\"diseaseCategoryName\":\"胃下垂\"},{\"diseaseCategoryId\":59,\"diseaseCategoryName\":\"呕吐\"},{\"diseaseCategoryId\":60,\"diseaseCategoryName\":\"慢性腹泻（慢性肠炎）\"},{\"diseaseCategoryId\":61,\"diseaseCategoryName\":\"急性胃肠炎\"},{\"diseaseCategoryId\":62,\"diseaseCategoryName\":\"慢性肝炎\"},{\"diseaseCategoryId\":63,\"diseaseCategoryName\":\"肝炎后综合征\"},{\"diseaseCategoryId\":64,\"diseaseCategoryName\":\"溃疡性结肠炎\"},{\"diseaseCategoryId\":65,\"diseaseCategoryName\":\"胆结石、胆囊炎、胆道系统感染\"}]},{\"systemId\":6,\"systemName\":\"五官科及口腔科疾病\",\"diseaseCategoryList\":[{\"diseaseCategoryId\":66,\"diseaseCategoryName\":\"内耳眩晕症\"},{\"diseaseCategoryId\":67,\"diseaseCategoryName\":\"耳鸣\"},{\"diseaseCategoryId\":68,\"diseaseCategoryName\":\"听力下降、耳聋\"},{\"diseaseCategoryId\":69,\"diseaseCategoryName\":\"慢性化脓性中耳炎\"},{\"diseaseCategoryId\":70,\"diseaseCategoryName\":\"耳痛\"},{\"diseaseCategoryId\":71,\"diseaseCategoryName\":\"耳痒\"},{\"diseaseCategoryId\":72,\"diseaseCategoryName\":\"耳堵塞感\"},{\"diseaseCategoryId\":73,\"diseaseCategoryName\":\"慢性鼻炎\"},{\"diseaseCategoryId\":74,\"diseaseCategoryName\":\"过敏性鼻炎\"},{\"diseaseCategoryId\":75,\"diseaseCategoryName\":\"鼻窦炎\"},{\"diseaseCategoryId\":76,\"diseaseCategoryName\":\"鼻咽炎\"},{\"diseaseCategoryId\":77,\"diseaseCategoryName\":\"嗅觉失灵\"},{\"diseaseCategoryId\":78,\"diseaseCategoryName\":\"鼻鼾\"},{\"diseaseCategoryId\":79,\"diseaseCategoryName\":\"扁桃体炎\"},{\"diseaseCategoryId\":80,\"diseaseCategoryName\":\"急性咽喉炎\"},{\"diseaseCategoryId\":81,\"diseaseCategoryName\":\"慢性咽喉炎\"},{\"diseaseCategoryId\":82,\"diseaseCategoryName\":\"喉炎\"},{\"diseaseCategoryId\":83,\"diseaseCategoryName\":\"声音嘶哑\"},{\"diseaseCategoryId\":84,\"diseaseCategoryName\":\"咽喉异物感（梅核气）\"},{\"diseaseCategoryId\":85,\"diseaseCategoryName\":\"复发性口腔溃疡（口疮）\"},{\"diseaseCategoryId\":86,\"diseaseCategoryName\":\"颞颌关节紊乱综合征\"},{\"diseaseCategoryId\":87,\"diseaseCategoryName\":\"牙周炎\"},{\"diseaseCategoryId\":88,\"diseaseCategoryName\":\"牙龈出血\"},{\"diseaseCategoryId\":89,\"diseaseCategoryName\":\"牙痛\"},{\"diseaseCategoryId\":90,\"diseaseCategoryName\":\"牙龈炎\"},{\"diseaseCategoryId\":91,\"diseaseCategoryName\":\"舌痛\"},{\"diseaseCategoryId\":92,\"diseaseCategoryName\":\"舌咽神经痛\"}]},{\"systemId\":7,\"systemName\":\"外科疾病\",\"diseaseCategoryList\":[{\"diseaseCategoryId\":94,\"diseaseCategoryName\":\"脱肛\"},{\"diseaseCategoryId\":95,\"diseaseCategoryName\":\"痔疮\"},{\"diseaseCategoryId\":96,\"diseaseCategoryName\":\"阑尾炎\"},{\"diseaseCategoryId\":99,\"diseaseCategoryName\":\"急性蜂窝（组）织炎\"},{\"diseaseCategoryId\":100,\"diseaseCategoryName\":\"疖痈\"},{\"diseaseCategoryId\":204,\"diseaseCategoryName\":\"丹毒\"},{\"diseaseCategoryId\":205,\"diseaseCategoryName\":\"淋巴结炎\"}]},{\"systemId\":8,\"systemName\":\"神经与精神系统疾病\",\"diseaseCategoryList\":[{\"diseaseCategoryId\":101,\"diseaseCategoryName\":\"神经衰弱（失眠）\"},{\"diseaseCategoryId\":102,\"diseaseCategoryName\":\"多梦\"},{\"diseaseCategoryId\":103,\"diseaseCategoryName\":\"头痛\"},{\"diseaseCategoryId\":104,\"diseaseCategoryName\":\"头晕\"},{\"diseaseCategoryId\":106,\"diseaseCategoryName\":\"三叉神经痛\"},{\"diseaseCategoryId\":107,\"diseaseCategoryName\":\"面肌痉挛\"},{\"diseaseCategoryId\":108,\"diseaseCategoryName\":\"面神经麻痹\"},{\"diseaseCategoryId\":109,\"diseaseCategoryName\":\"幻肢痛\"},{\"diseaseCategoryId\":112,\"diseaseCategoryName\":\"抑郁症\"},{\"diseaseCategoryId\":113,\"diseaseCategoryName\":\"疲劳综合征\"},{\"diseaseCategoryId\":114,\"diseaseCategoryName\":\"植物神经功能紊乱\"},{\"diseaseCategoryId\":115,\"diseaseCategoryName\":\"肋间神经痛\"},{\"diseaseCategoryId\":116,\"diseaseCategoryName\":\"多汗症\"},{\"diseaseCategoryId\":117,\"diseaseCategoryName\":\"多动症\"}]},{\"systemId\":9,\"systemName\":\"皮肤病\",\"diseaseCategoryList\":[{\"diseaseCategoryId\":119,\"diseaseCategoryName\":\"神经性皮炎\"},{\"diseaseCategoryId\":120,\"diseaseCategoryName\":\"荨麻疹\"},{\"diseaseCategoryId\":121,\"diseaseCategoryName\":\"带状疱疹\"},{\"diseaseCategoryId\":122,\"diseaseCategoryName\":\"黄褐斑\"},{\"diseaseCategoryId\":123,\"diseaseCategoryName\":\"痤疮（粉刺）\"},{\"diseaseCategoryId\":124,\"diseaseCategoryName\":\"扁平疣\"},{\"diseaseCategoryId\":126,\"diseaseCategoryName\":\"酒渣鼻\"},{\"diseaseCategoryId\":127,\"diseaseCategoryName\":\"湿疹\"},{\"diseaseCategoryId\":129,\"diseaseCategoryName\":\"单纯性疱疹（热疮）\"},{\"diseaseCategoryId\":130,\"diseaseCategoryName\":\"脱发\"},{\"diseaseCategoryId\":132,\"diseaseCategoryName\":\"接触性皮炎\"},{\"diseaseCategoryId\":133,\"diseaseCategoryName\":\"脂溢性皮炎\"},{\"diseaseCategoryId\":135,\"diseaseCategoryName\":\"结节性痒疹\"},{\"diseaseCategoryId\":206,\"diseaseCategoryName\":\"皮肤瘙痒症\"}]},{\"systemId\":10,\"systemName\":\"内分比和代谢系统疾病\",\"diseaseCategoryList\":[{\"diseaseCategoryId\":137,\"diseaseCategoryName\":\"糖尿病\"},{\"diseaseCategoryId\":138,\"diseaseCategoryName\":\"尿崩症\"},{\"diseaseCategoryId\":139,\"diseaseCategoryName\":\"甲状腺功能亢进\"},{\"diseaseCategoryId\":140,\"diseaseCategoryName\":\"甲状腺功能减退\"},{\"diseaseCategoryId\":141,\"diseaseCategoryName\":\"单纯性甲状腺肿\"},{\"diseaseCategoryId\":142,\"diseaseCategoryName\":\"高血脂症\"},{\"diseaseCategoryId\":207,\"diseaseCategoryName\":\"低血糖症\"}]},{\"systemId\":11,\"systemName\":\"泌尿与生殖系统疾病\",\"diseaseCategoryList\":[{\"diseaseCategoryId\":143,\"diseaseCategoryName\":\"肾结石\"},{\"diseaseCategoryId\":144,\"diseaseCategoryName\":\"输尿管结石\"},{\"diseaseCategoryId\":145,\"diseaseCategoryName\":\"膀胱结石\"},{\"diseaseCategoryId\":146,\"diseaseCategoryName\":\"尿道结石\"},{\"diseaseCategoryId\":147,\"diseaseCategoryName\":\"膀胱炎\"},{\"diseaseCategoryId\":148,\"diseaseCategoryName\":\"尿道炎\"},{\"diseaseCategoryId\":149,\"diseaseCategoryName\":\"遗尿症\"},{\"diseaseCategoryId\":150,\"diseaseCategoryName\":\"尿频\"},{\"diseaseCategoryId\":151,\"diseaseCategoryName\":\"尿失禁\"},{\"diseaseCategoryId\":152,\"diseaseCategoryName\":\"遗精\"},{\"diseaseCategoryId\":153,\"diseaseCategoryName\":\"阳痿、早泄\"},{\"diseaseCategoryId\":154,\"diseaseCategoryName\":\"睾丸炎、附睾丸炎\"},{\"diseaseCategoryId\":155,\"diseaseCategoryName\":\"前列腺炎\"},{\"diseaseCategoryId\":156,\"diseaseCategoryName\":\"前列腺肥大\"},{\"diseaseCategoryId\":208,\"diseaseCategoryName\":\"慢性肾炎\"},{\"diseaseCategoryId\":209,\"diseaseCategoryName\":\"肾盂肾炎\"}]},{\"systemId\":12,\"systemName\":\"呼吸系统疾病\",\"diseaseCategoryList\":[{\"diseaseCategoryId\":158,\"diseaseCategoryName\":\"支气管炎\"},{\"diseaseCategoryId\":159,\"diseaseCategoryName\":\"支气管哮喘\"},{\"diseaseCategoryId\":161,\"diseaseCategoryName\":\"感冒\"},{\"diseaseCategoryId\":162,\"diseaseCategoryName\":\"胸痛、胸闷、气短\"},{\"diseaseCategoryId\":163,\"diseaseCategoryName\":\"支气管扩张\"}]},{\"systemId\":13,\"systemName\":\"妇产科疾病\",\"diseaseCategoryList\":[{\"diseaseCategoryId\":164,\"diseaseCategoryName\":\"月经不调\"},{\"diseaseCategoryId\":165,\"diseaseCategoryName\":\"痛经\"},{\"diseaseCategoryId\":166,\"diseaseCategoryName\":\"月经过少、闭经\"},{\"diseaseCategoryId\":167,\"diseaseCategoryName\":\"月经过多、功能性子宫出血\"},{\"diseaseCategoryId\":168,\"diseaseCategoryName\":\"宫颈炎\"},{\"diseaseCategoryId\":169,\"diseaseCategoryName\":\"子宫内膜炎\"},{\"diseaseCategoryId\":170,\"diseaseCategoryName\":\"输卵管炎\"},{\"diseaseCategoryId\":171,\"diseaseCategoryName\":\"卵巢炎\"},{\"diseaseCategoryId\":172,\"diseaseCategoryName\":\"附件炎\"},{\"diseaseCategoryId\":173,\"diseaseCategoryName\":\"带症\"},{\"diseaseCategoryId\":174,\"diseaseCategoryName\":\"盆腔炎\"},{\"diseaseCategoryId\":175,\"diseaseCategoryName\":\"更年期综合症\"},{\"diseaseCategoryId\":176,\"diseaseCategoryName\":\"子宫脱垂\"},{\"diseaseCategoryId\":177,\"diseaseCategoryName\":\"缺乳\"},{\"diseaseCategoryId\":178,\"diseaseCategoryName\":\"妊娠呕吐\"},{\"diseaseCategoryId\":179,\"diseaseCategoryName\":\"乳腺小叶增生\"},{\"diseaseCategoryId\":180,\"diseaseCategoryName\":\"乳腺炎\"},{\"diseaseCategoryId\":181,\"diseaseCategoryName\":\"不孕症\"},{\"diseaseCategoryId\":182,\"diseaseCategoryName\":\"子宫肌瘤\"}]},{\"systemId\":14,\"systemName\":\"耳穴防病,美容,保健\",\"diseaseCategoryList\":[{\"diseaseCategoryId\":183,\"diseaseCategoryName\":\"预防感冒\"},{\"diseaseCategoryId\":184,\"diseaseCategoryName\":\"预防晕车、晕船、晕机\"},{\"diseaseCategoryId\":185,\"diseaseCategoryName\":\"戒烟\"},{\"diseaseCategoryId\":186,\"diseaseCategoryName\":\"戒酒\"},{\"diseaseCategoryId\":187,\"diseaseCategoryName\":\"竞技综合征\"},{\"diseaseCategoryId\":188,\"diseaseCategoryName\":\"抗衰老\"},{\"diseaseCategoryId\":189,\"diseaseCategoryName\":\"老年斑\"},{\"diseaseCategoryId\":210,\"diseaseCategoryName\":\"减肥（针对单纯性肥胖）\"},{\"diseaseCategoryId\":211,\"diseaseCategoryName\":\"流行性腮腺炎\"}]},{\"systemId\":15,\"systemName\":\"其他功能\",\"diseaseCategoryList\":[{\"diseaseCategoryId\":190,\"diseaseCategoryName\":\"助听\"},{\"diseaseCategoryId\":191,\"diseaseCategoryName\":\"补肾\"},{\"diseaseCategoryId\":192,\"diseaseCategoryName\":\"补血\"},{\"diseaseCategoryId\":193,\"diseaseCategoryName\":\"健脑\"},{\"diseaseCategoryId\":194,\"diseaseCategoryName\":\"活血\"},{\"diseaseCategoryId\":195,\"diseaseCategoryName\":\"止惊吓\"},{\"diseaseCategoryId\":196,\"diseaseCategoryName\":\"止瘙痒\"},{\"diseaseCategoryId\":197,\"diseaseCategoryName\":\"抗过敏\"},{\"diseaseCategoryId\":198,\"diseaseCategoryName\":\"抗风湿\"},{\"diseaseCategoryId\":199,\"diseaseCategoryName\":\"健脾助运\"},{\"diseaseCategoryId\":200,\"diseaseCategoryName\":\"理气消胀\"},{\"diseaseCategoryId\":201,\"diseaseCategoryName\":\"调整自主神经功能\"},{\"diseaseCategoryId\":202,\"diseaseCategoryName\":\"调整内分泌功能\"},{\"diseaseCategoryId\":203,\"diseaseCategoryName\":\"提高免疫力\"},{\"diseaseCategoryId\":212,\"diseaseCategoryName\":\"强心\"},{\"diseaseCategoryId\":213,\"diseaseCategoryName\":\"利尿\"},{\"diseaseCategoryId\":214,\"diseaseCategoryName\":\"明目\"},{\"diseaseCategoryId\":215,\"diseaseCategoryName\":\"鼻通\"},{\"diseaseCategoryId\":216,\"diseaseCategoryName\":\"美容\"},{\"diseaseCategoryId\":217,\"diseaseCategoryName\":\"退烧\"},{\"diseaseCategoryId\":218,\"diseaseCategoryName\":\"健肝血\"},{\"diseaseCategoryId\":219,\"diseaseCategoryName\":\"止咳\"},{\"diseaseCategoryId\":220,\"diseaseCategoryName\":\"止血\"},{\"diseaseCategoryId\":221,\"diseaseCategoryName\":\"止惊\"},{\"diseaseCategoryId\":222,\"diseaseCategoryName\":\"止痒\"},{\"diseaseCategoryId\":223,\"diseaseCategoryName\":\"止遗\"},{\"diseaseCategoryId\":224,\"diseaseCategoryName\":\"调整植物神经功能\"},{\"diseaseCategoryId\":225,\"diseaseCategoryName\":\"调整月经周期、经量\"}]}]";
		
//		return str;
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
			} 
//				else {
//				UserJurisdiction userJ = new UserJurisdiction();
//				User user = (User) session.getAttribute("user");
//				if(user==null){
//					return null;
//				}
//				userJ.setUid(user.getUid());
//				userJ.setDiseaseCategoryId(diseaseCategoryId);
//				// 判断是否有访问这个的权利
//				boolean flag = userService.isHaveAuthority(userJ);
//				if (flag == false) {
//						 response.setHeader("sessionStatus", "noAuthority");
//						 response.sendError(665, "You have no jurisdiction!");
//						return null;
//				} else {
//					return diseaseServiceImpl
//							.findDiseaseCategoryWithAcupointsById(diseaseCategoryId);
//				}
//			}
			return diseaseServiceImpl
			.findDiseaseCategoryWithAcupointsById(diseaseCategoryId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@RequestMapping(value ="/findDiseaseCategoryById.action" ,method={RequestMethod.GET,RequestMethod.POST}) 
	public @ResponseBody DiseaseCategory findDiseaseCategoryById(Integer diseaseCategoryId){
		DiseaseCategory diseaseCategory  = null;
		if(diseaseCategoryId==null){
			return null;
		}
		try {
			  diseaseCategory = diseaseServiceImpl.findDiseaseCategoryById(diseaseCategoryId);
		} catch (Exception e) {
			System.out.println("根据id查询出错了");
			e.printStackTrace();
		}
		return diseaseCategory;
	}
}
