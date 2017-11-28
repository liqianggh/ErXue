package net.erxue.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.codehaus.jackson.JsonParser;
import org.junit.Test;
import org.springframework.http.ResponseEntity;


import net.erxue.controller.UserController;
import net.erxue.others.ResponseMsg;
import net.erxue.others.message163.MessageUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;

public class OtherTest {
	
	@Test
	public void testJson(){
		//{"code":200,"msg":"2","obj":"6373"}
		String object = "{\"code\":200,\"msg\":\"2\",\"obj\":\"6373\"}";
		JSONObject jsonObject = JSONObject.fromObject(object);
		
		ResponseMsg msg = (ResponseMsg) jsonObject.toBean(jsonObject, ResponseMsg.class);
		
		System.out.println(msg);
	}
	
	@Test
	public void testClassLoader() throws FileNotFoundException, IOException{
		ClassLoader loader = OtherTest.class.getClassLoader();
		
		 Properties properties = new Properties();
		 properties.load(this.getClass().getResourceAsStream("/appConfig.properties"));
		System.out.println(properties.get("appKey"));
	}
	
	
	@Test
	public void testSendMessage() throws Exception{
		
		ResponseMsg msg = new MessageUtils().sendMessage("18846835210");
		System.out.println(msg+"返回结果");
	}

}
