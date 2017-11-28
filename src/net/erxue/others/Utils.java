package net.erxue.others;

import java.util.Random;

import org.junit.Test;

public class Utils {
	
	public static String getRandom(int length){
		Random random = new Random();
		String  x =   "";
		for(int i = 0; i < length; i ++){
			x+=random.nextInt(9);
		}
		return x;
	}
}
