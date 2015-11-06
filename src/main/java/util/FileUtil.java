package util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 文件的读写
 * 
 * @author xuchongying
 *
 */
public class FileUtil {

	private FileUtil() {
	}

	/**
	 * 追加内容
	 * @param fileName
	 * @param content
	 */
	public static void AppendContent(String fileName, String content) {
		BufferedWriter bw = null;
		try {

			bw = new BufferedWriter(new FileWriter(fileName, true));

			bw.write(content);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
	/**
	 * 追加内容
	 * @param fileName
	 * @param content
	 */
	public static void AppendContent(File file, String content) {
		BufferedWriter bw = null;
		try {

			bw = new BufferedWriter(new FileWriter(file, true));

			bw.write(content);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
	
}
