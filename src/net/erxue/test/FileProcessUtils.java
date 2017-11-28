package net.erxue.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.core.helpers.UUIDUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.erxue.mapper.AcupointMapperCustom;
import net.erxue.po.Acupoint;
import net.erxue.po.AcupointCustom;

public class FileProcessUtils {
	static ApplicationContext context = null;
	AcupointMapperCustom mapper = context.getBean(AcupointMapperCustom.class);
	static {
		context = new ClassPathXmlApplicationContext(
				"classpath:spring/applicationContext-*.xml");

	}

	public boolean ChangeNameSavetomysql(String url, String dicName,
			Integer modulesId) {
		List<Acupoint> list = new ArrayList<Acupoint>();
		File file = new File(url);
		String filename = "";
		if (!file.isDirectory()) {
			return false;
		} else {
			File[] arr = file.listFiles();
			for (File fi : arr) {
				Acupoint acupoint = new Acupoint();
				filename = fi.getName();
				// 新名称
				String newFileName= UUIDUtil.getTimeBasedUUID()
						+ filename.substring(filename.indexOf("."));
				String newName = dicName + "/" + newFileName;
				File newFile = new File(url + newName);
				acupoint.setAcupointName(filename.substring(0,
						filename.indexOf(".")));
				acupoint.setVideolocation(newName);
				acupoint.setModulesId(modulesId);
				
				
				Boolean flag = fi.renameTo(new File(fi.getParent() + "/"
						+ newFileName));
				System.out.println(flag + "更改成功了么");
				list.add(acupoint);
			}
			try {
				mapper.addAcupoinForBatch(list);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}

	}

	public static void main(String[] args) { 
//		  new FileProcessUtils().ChangeNameSavetomysql("H:/video/","erchui",1);
		new FileProcessUtils().ChangeNameSavetomysql("H:/videotransformed/17","erbei",17);

		// TODO 自动生成方法存根
//		File f = new File("d:/1.mp4");
//		String c = f.getParent();
//		File mm = new File(c + File.pathSeparator + "hah.mp4");
//		if (f.renameTo(mm)) {
//			System.out.println("修改成功!");
//		} else {
//			System.out.println("修改失败");
//		}

	}

}
