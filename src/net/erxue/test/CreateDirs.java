package net.erxue.test;

import java.io.File;
import java.io.IOException;

public class CreateDirs {

	public static void main(String[] args) throws IOException {
		File file = new File("d:/uploadfile/video/2017/a.txt");
		if (!file.exists()) {
			file.createNewFile();
		}
	}

}
