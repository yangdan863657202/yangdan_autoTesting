package util;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Properties;

public class ExcelUtil {

	public static void main(String[] args) {

		String s = "E:\\历史资料\\测试问题调研表-汇总.xlsx";
		Object[][] dataForTestNG = getDataForTestNGWithUrl(s, "总计");
		for (Object[] objects : dataForTestNG) {
			for (Object object : objects) {
				System.out.print(object + "\t");
			}
			System.out.println();
		}
	}

	private ExcelUtil() {
	}

	/**
	 * 获取excel表格中的数据,并且组合webdriver-rul.properties中的参数，主要用于浏览器兼容性测试的数据准备
	 * 
	 * @param excelName
	 *            名称全路径
	 * @param sheetName
	 *            也签的名称
	 * @return 表格中从第二行开始的所有数据组成的二维数据
	 */
	public static Object[][] getDataForTestNGWithUrl(String excelName, String sheetName) {
		
		Object[][] objArr=getDataForTestNG(excelName, sheetName);
		
		String firefox = "firefox";
		String chrome = "chrome";
		String IE = "IE";
		Properties properties=new Properties();
		try {
			properties.load(ExcelUtil.class.getClassLoader().getResourceAsStream("webdriver-rul.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Object[][] newArr = null;

		
		String[][] urls = { { firefox, properties.getProperty(firefox) },
				{ chrome, properties.getProperty(chrome) },
				{ IE, properties.getProperty(IE) }
		// ,{ "safari", "http://192.168.150.1:8888/wd/hub" }
		};

		if (objArr.length <= 0 || objArr == null) {
			newArr = urls;

			return newArr;
		}
		newArr = new Object[objArr.length * urls.length][objArr[0].length
				+ urls[0].length];

		for (int i = 0; i < newArr.length; i++) {
			for (int j = 0; j < newArr[i].length; j++) {
				int columnObjArr = objArr[0].length;
				int rowUrls = urls.length;
				if (j < columnObjArr) {
					newArr[i][j] = objArr[i / rowUrls][j];
				} else {

					newArr[i][j] = urls[i % rowUrls][j - columnObjArr];
				}
			}

		}
		
		return newArr;

	}

	/**
	 * 获取excel表格中的数据
	 * 
	 * @param excelName
	 *            名称全路径
	 * @param sheetName
	 *            也签的名称
	 * @return 表格中从第二行开始的所有数据组成的二维数据
	 */
	public static Object[][] getDataForTestNG(String excelName, String sheetName) {
		Object[][] dataArr = null;
		Sheet sheet = null;

		Workbook workbook = getWorkbook(excelName);
		if (workbook == null) {
			System.out.println("文件格式有问题！请使用标准Excel文件！");
			return null;
		}

		sheet = workbook.getSheet(sheetName);
		int firstRowNum = sheet.getFirstRowNum();
		int lastRowNum = sheet.getLastRowNum();
		short firstCellNum = sheet.getRow(firstRowNum).getFirstCellNum();
		short lastCellNum = sheet.getRow(firstRowNum).getLastCellNum();
		dataArr = new Object[lastRowNum][lastCellNum];

		for (int i = firstRowNum + 1; i <= lastRowNum; i++) {
			Row row = sheet.getRow(i);

			if (row != null) {
				for (int j = firstCellNum; j < lastCellNum; j++) {
					Cell cell = row.getCell(j);
					if (cell != null) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_BLANK:
							dataArr[i - 1][j] = null;
							break;
						case Cell.CELL_TYPE_BOOLEAN:
							dataArr[i - 1][j] = cell.getBooleanCellValue();
							break;
						case Cell.CELL_TYPE_ERROR:
							dataArr[i - 1][j] = cell.getErrorCellValue();
							break;
						case Cell.CELL_TYPE_FORMULA:
							dataArr[i - 1][j] = cell.getCellFormula();
							break;
						case Cell.CELL_TYPE_NUMERIC:

							boolean isCellDateFormatted = DateUtil
									.isCellDateFormatted(cell);
							if (isCellDateFormatted) {
								dataArr[i - 1][j] = new SimpleDateFormat(
										"yyyy-MM-dd")
										.format(DateUtil.getJavaDate(cell
												.getNumericCellValue()));
							} else {
								dataArr[i - 1][j] = cell.getNumericCellValue();
							}
							break;
						case Cell.CELL_TYPE_STRING:
							dataArr[i - 1][j] = cell.getStringCellValue();
							break;
						default:
							break;
						}
					} else {
						dataArr[i - 1][j] = null;
					}

				}
			} else {
				for (int j = firstCellNum; j < lastCellNum; j++) {
					dataArr[i - 1][j] = null;
				}

			}
		}
		return dataArr;

	}

	private static Workbook getWorkbook(String excelName) {
		Workbook workbook = null;
		try {
			if (excelName != null
					&& !"".equals(excelName)
					&& excelName.endsWith(".xls")
					&& POIFSFileSystem.hasPOIFSHeader(new FileInputStream(
							new File(excelName)))) {

				workbook = new HSSFWorkbook(new FileInputStream(new File(
						excelName)));
			}

			if (excelName != null && !"".equals(excelName)
					&& excelName.endsWith(".xlsx")) {
				workbook = new XSSFWorkbook(new FileInputStream(new File(
						excelName)));
			}
			return workbook;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
