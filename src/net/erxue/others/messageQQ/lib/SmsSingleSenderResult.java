package net.erxue.others.messageQQ.lib;

public class SmsSingleSenderResult {
/*
{
    "result": 0,
    "errmsg": "OK", 
    "ext": "", 
    "sid": "xxxxxxx", 
    "fee": 1
}
 */
	public int result;//结果码 0发送成功 
	public String errMsg = "";//错误信息提示
	public String ext = "";//验证码
	public String sid = "";//短信编号
	public int fee;//是否收费（0没有，1收费）
	
	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	public String toString() {
		return String.format(
				"SmsSingleSenderResult\nresult %d\nerrMsg %s\next %s\nsid %s\nfee %d",
				result, errMsg, ext, sid, fee);		
	}
}
