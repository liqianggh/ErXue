package net.erxue.test;

import java.util.ArrayList;
import java.util.List;

import net.erxue.mapper.DiseaseMapperCustom;
import net.erxue.po.DiseaseCategoryCustom;
import net.erxue.vo.DiseaseCategoryAndAcupointUpload;
import net.erxue.vo.DiseaseSystemAndDiseaseVo;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DiseaseTest {
	ApplicationContext context;
	@Before
	public void setUp() throws Exception {
	
		context =new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
	}
	@Test
	public void test() throws Exception {
		DiseaseMapperCustom diseaseMapper = context.getBean(DiseaseMapperCustom.class);
		
//		List<DiseaseSystem> list = diseaseMapper.findAllDiseaseSystems();
//		List<DiseaseCategory> list = diseaseMapper.findAllDiseaseCategory();
//DiseaseCategory list=		diseaseMapper.findDiseaseCategoryById(1);
//List<DiseaseCategoryCustom> list = diseaseMapper.findAllDiseaseCategoryWithAcupoints();
//		DiseaseCategory dc = new DiseaseCategory();
//		dc.setAttention("主穴：锁骨、肩关节、肩、轮3或轮4放血配穴：耳大神经点【按语】肩前痛取耳前肩三点（锁骨、肩关节、肩），肩后痛取耳背肩三点，必要时对贴。耳穴治疗期间，患者应适当活动患肢，但不宜过度，以免造成肌肉韧带拉伤。急性肩周炎治疗效果较");
//		dc.setDiseaseDescription("肩周炎又称肩关节周围炎，俗称凝肩、五十肩。以肩部逐渐产生疼痛，夜间为甚，逐渐加重，肩关节活动功能受限而且日益加重，达到某种程度后逐渐缓解，直至最后完全复原为主要表现的肩关节囊及其周围韧带、肌腱和滑囊的慢性特异性炎症。肩周炎是以肩关节疼痛和活动不便为主要症状的常见病症。本病的好发年龄在50岁左右，女性发病率略高于男性，多见于体力劳动者。如得不到有效的治疗，有可能严重影响肩关节的功能活动。肩关节可有广泛压痛，并向颈部及肘部放射，还可出现不同程度的三角肌的萎缩");
//		dc.setDiseaseSystemId(1);
//		dc.setDiseaseCategoryName("肩周炎");
//		
//		int x = diseaseMapper.addDiseaseCategory(dc);
//		System.out.println(x);
//		DiseaseCategoryCustom list=diseaseMapper.findDiseaseCategoryWithAcupointsById(1);
////		System.out.println(list);
//		
//		DiseaseCategoryAndAcupointUpload dc = new DiseaseCategoryAndAcupointUpload();
//		dc.setDiseaseCategoryId(5);
//		List<Integer> list1 = new ArrayList<>();
//		list1.add(5);
//		list1.add(6);
//		list1.add(7);
//		List<Integer> list2 = new ArrayList<>();
//		list2.add(9);
//		list2.add(10);
//		
//		dc.setMainAcupointList(list1);
//		dc.setSideAcupointList(list2);
//		
//		int x = diseaseMapper.addAcupointsToDisease(dc);
//		System.out.println(x);
//		List<DiseaseCategoryCustom> list = diseaseMapper.findAllDiseaseCategorySim(1);
		List<DiseaseSystemAndDiseaseVo> list2 = diseaseMapper.findAllDiseaseSystemAndDisease();
		
		System.out.println(list2.size());
	}

}
