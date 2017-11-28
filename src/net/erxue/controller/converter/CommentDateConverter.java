package net.erxue.controller.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class CommentDateConverter implements Converter<String, Date> {

	@Override
	public Date convert(String source) {
		String pattern = "yyyy-MM-dd HH:mm:ss";

		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try {
			return sdf.parse(source);
		} catch (ParseException e) {
			System.out.println("时间转换出错了");
			return null;
		}

	}

}
