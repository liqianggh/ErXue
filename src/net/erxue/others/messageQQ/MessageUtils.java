package net.erxue.others.messageQQ;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import net.erxue.others.Utils;
import net.erxue.others.messageQQ.lib.SmsMultiSender;
import net.erxue.others.messageQQ.lib.SmsMultiSenderResult;
import net.erxue.others.messageQQ.lib.SmsSingleSender;
import net.erxue.others.messageQQ.lib.SmsSingleSenderResult;
import net.erxue.others.messageQQ.lib.SmsStatusPullCallbackResult;
import net.erxue.others.messageQQ.lib.SmsStatusPullReplyResult;
import net.erxue.others.messageQQ.lib.SmsStatusPuller;
import net.erxue.others.messageQQ.lib.SmsVoicePromptSender;
import net.erxue.others.messageQQ.lib.SmsVoicePromptSenderResult;
import net.erxue.others.messageQQ.lib.SmsVoiceVerifyCodeSender;
import net.erxue.others.messageQQ.lib.SmsVoiceVerifyCodeSenderResult;

public class MessageUtils {

	public static SmsSingleSenderResult sendMessage(String phoneNumber){

		try {
			// 加载配置文件中的参数
			Properties properties = new Properties();
			properties.load(MessageUtils.class
					.getResourceAsStream("/appConfigQQ.properties"));
			//应用相关配置
			int appid =  Integer.parseInt(properties.getProperty("appid"));
			String appkey =  properties.getProperty("appkey");
			// 模版id
			int tmplId = Integer.parseInt(properties.getProperty("templId"));
			//验证码长度
			int codeLen = Integer.parseInt(properties.getProperty("codeLen"));
			//生成验证码
			String code = Utils.getRandom(codeLen);
			// 初始化单发
			SmsSingleSender singleSender = new SmsSingleSender(appid, appkey);
			SmsSingleSenderResult singleSenderResult;
			
			String timeout =properties.getProperty("timeout");
			// // 普通单发
			// singleSenderResult = singleSender.send(0, "86", phoneNumber,
			// "您注册的验证码：1234", "", "");
			//
			// System.out.println(singleSenderResult);
			
			
			// 模板内容为：测试短信
			//{1}验证码，{2}过期时间提示 
			 ArrayList<String> params = new ArrayList<>();
			params.add(code);
			params.add(timeout);
			
			singleSenderResult = singleSender.sendWithParam("86", phoneNumber,
					tmplId, params, "", "", code);
			
			System.out.println(singleSenderResult);
			return singleSenderResult;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
