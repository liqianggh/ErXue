package net.erxue.others.message163;
import net.erxue.messageidentify.CheckSumBuilder;
import net.erxue.others.ResponseMsg;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class MessageUtils {

	
	
	/**
	 * 网易短信sdk开发
	 * @param mobile
	 * @return
	 * @throws Exception
	 */
	public  ResponseMsg sendMessage(String mobile) throws Exception {
		//接在配置文件
		 Properties properties = new Properties();
		 properties.load(MessageUtils.class.getResourceAsStream("/appConfig.properties"));
		
		
		 DefaultHttpClient httpClient = new DefaultHttpClient();
		String url = "https://api.netease.im/sms/sendcode.action";
		HttpPost httpPost = new HttpPost(url);
		
		String appKey = properties.getProperty("appKey");
		String appSecret = properties.getProperty("appSecret");
		String nonce = "123456";
		String curTime = String.valueOf((new Date()).getTime() / 1000L);
		String checkSum = CheckSumBuilder
				.getCheckSum(appSecret, nonce, curTime);// 参考 计算CheckSum的java代码

		String MOULD_ID = properties.getProperty("MOULD_ID");
		String phone = mobile;
		String msg = "这是验证消息";
		String codeLen = properties.getProperty("codeLen");// 验证码长度

		// 设置请求的header
		httpPost.addHeader("AppKey", appKey);
		httpPost.addHeader("Nonce", nonce);
		httpPost.addHeader("CurTime", curTime);
		httpPost.addHeader("CheckSum", checkSum);
		httpPost.addHeader("Content-Type",
				"application/x-www-form-urlencoded;charset=utf-8");

		// 设置请求的参数
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		// nvps.add(new BasicNameValuePair("accid", "helloworld"));
		nvps.add(new BasicNameValuePair("templateid", MOULD_ID));
		nvps.add(new BasicNameValuePair("mobile", phone));
		nvps.add(new BasicNameValuePair("params", "['" + msg + "']"));
		nvps.add(new BasicNameValuePair("codeLen", codeLen));
		httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));

		// 执行请求
		HttpResponse response = httpClient.execute(httpPost);
		// 打印执行结果
		// System.out.println(EntityUtils.toString(response.getEntity(),
		// "utf-8"));
		// {"code":200,"msg":"2","obj":"6373"}

		// 将云信服务器返回的数据接受
		JSONObject jsonObject = JSONObject.fromObject(EntityUtils.toString(
				response.getEntity(), "utf-8"));
		ResponseMsg responseMsg = (ResponseMsg) jsonObject.toBean(jsonObject,
				ResponseMsg.class);
		
		/*
		 * 对状态码进行判断
		 * */

		return responseMsg;
	}

}
