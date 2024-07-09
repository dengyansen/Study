package excel;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.text.html.parser.Parser;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class TestExcel {
	public static class ColumnEntity {
		private String columnName;
		private String key;
		private int columnType;

		public String getKey() {
			return key;
		}

		public ColumnEntity(String key, int columnType){
			this.key = key;
			this.columnType = columnType;
		}
		public String getColumnName() {
			return columnName;
		}
		public int getColumnType() {
			return columnType;
		}

	}
	public static class Column {
		private ArrayList<ColumnEntity> columnList = new ArrayList<ColumnEntity>(5);
		Column addColumn(ColumnEntity entity){
			this.columnList.add(entity);
			return this;
		}
	}
	public static void main(String[] args) throws IOException {
		String name = "导入会员列表.xlsx";
		//得到Excel工作簿对象
		int rt = 0;
		if(name.endsWith("xlsx")){
			XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream("d:/导入会员列表.xlsx"));
			XSSFSheet sheet = wb.getSheetAt(0);
			rt = getDataListFromSheet2007(sheet);
		}else{
			POIFSFileSystem fs= new POIFSFileSystem(new FileInputStream("d:/导入会员列表.xlsx"));
			HSSFWorkbook wb = new HSSFWorkbook(fs);
			HSSFSheet sheet = wb.getSheetAt(0);
			System.out.println("xls");
			System.out.println(sheet);
		}
		//得到Excel工作表对象

//		sheet.
//		//得到Excel工作表的行
//		HSSFRow row = sheet.getRow(i);
//		//得到Excel工作表指定行的单元格
//		HSSFCell cell = row.getCell((short) j);
//		cellStyle = cell.getCellStyle();//得到单元格样式
	}
	private static int getDataListFromSheet2007(XSSFSheet sheet) {
			int rt = 0;
			String msg = "";
			int total = sheet.getLastRowNum()+1;//总行数
			int firstRowNum = sheet.getFirstRowNum()+1;
			if(total >5000){
				msg = "每次导入不能大于5000条数据";
				System.out.println("每次导入不能大于5000条数据");
			}
			System.out.println("xlsx");
			System.out.println(sheet);
			System.out.println(sheet.getSheetName());
			System.out.println(sheet.getFirstRowNum());
			System.out.println(sheet.getLastRowNum());
			Column column = new Column();
			//姓名（必填）	手机号（必填）	性别（选填）	生日（选填，格式：1990-01-01）	联系地址（选填）	备注（选填）	剩余余额（选填）	可用积分（选填）	会员等级（选填，不填则默认为最低等级）	归属门店（选填，不填则默认为首个门店）

			column.addColumn(new ColumnEntity("name",Cell.CELL_TYPE_STRING))
					.addColumn(new ColumnEntity("phone",Cell.CELL_TYPE_STRING))
					.addColumn(new ColumnEntity("sex",Cell.CELL_TYPE_STRING))
					.addColumn(new ColumnEntity("birthDay",Cell.CELL_TYPE_STRING))
					.addColumn(new ColumnEntity("address",Cell.CELL_TYPE_STRING))
					.addColumn(new ColumnEntity("remark",Cell.CELL_TYPE_STRING))
					.addColumn(new ColumnEntity("money",Cell.CELL_TYPE_STRING))
					.addColumn(new ColumnEntity("integral",Cell.CELL_TYPE_STRING))
					.addColumn(new ColumnEntity("level",Cell.CELL_TYPE_STRING))
					.addColumn(new ColumnEntity("storeId",Cell.CELL_TYPE_STRING));
			// 解析每一行的数据，构造数据对象
			int rowStart = firstRowNum + 1;
			int rowEnd = sheet.getPhysicalNumberOfRows();
			for (int rowNum = rowStart; rowNum < rowEnd; rowNum++) {
				Row row = sheet.getRow(rowNum);
				if (null == row) {
					System.out.println("第"+row.getRowNum()+"行数据不合法，已忽略");
					continue;
				}
				int cellNum = column.columnList.size();
				// 获取姓名
				for(int i = 0;i<column.columnList.size();i++){
					ColumnEntity entity = column.columnList.get(i);
					Cell cell = row.getCell(i);
					if(cell == null){
						System.out.println("this cell null");
						continue;
					}else{
						String value = convertCellValueToString(cell).trim();
						System.out.println("value="+value+" i="+i);
						if(i == 0 ){//姓名校验
							if(value == null || value.length() == 0){
								msg = "未填姓名：未填写姓名，位置：";
								return rt;
							}
							if(value.length() >10){
								msg = "大于10个字：姓名超出10字，位置：";
								System.out.println(msg);
								return rt;
							}
						}
						if(i == 1 ){//手机校验
							if(value == null || value.length() == 0){
								msg = "未填手机：未填写手机号码，位置：";
								return rt;
							}
						}
						if(value != null){
							if(i == 2){//性别
								if(!(value.equals("男") || value.equals("女"))){
									msg = "性别填写错误，位置：第XX行，位置：";
									return rt;
								}
							}else if(i == 3){//生日
								//1990-01-01
								if(!(value.equals("男") || value.equals("女"))){
									msg = "生日格式错误，位置：第XX行，位置：";
									return rt;
								}
							}else if(i == 4){//联系地址
								if(value.trim().length()>50){
									msg = "联系地址超出50字，位置：第XX行，位置：";
									return rt;
								}
							}else if(i == 5){//备注
								if(value.trim().length()>200){
									msg = "备注超出200字，位置：第XX行，位置：第";
									return rt;
								}
							}else if(i == 6){//剩余余额
//								if(){
//									msg = "剩余余额格式错误，位置：第XX行，位置：第"+i+"行";
//									return;
//								}
							}else if(i == 7){//可用积分选填，必须为数字
//								if(!(value.equals("男") || value.equals("女"))){
//									msg = "可用积分格式错误，位置：第XX行，位置：第"+i+"行";
//									return;
//								}
							}else if(i == 8){//会员等级 选填，需校验是否与店铺中的等级名称匹配
								if(!(value.equals("男") || value.equals("女"))){
									msg = "会员等级不存在，位置：第XX行，位置：第"+i+"行";
									return rt;
								}
							}else if(i == 9){//归属门店 需校验是否与店铺中的门店名称匹配
//								if(!(value.equals("男") || value.equals("女"))){
//									msg = "门店不存在，位置：第XX行，位置：第"+i+"行";
//									return;
//								}
							}
						}
						System.out.println("key="+entity.getKey()+" value="+value);
					}
				}
			}
			return  rt;
	}

	/**
	 * 将单元格内容转换为字符串
	 * @param cell
	 * @return
	 */
	private static String convertCellValueToString(Cell cell) {
		if(cell==null){
			return null;
		}
		String returnValue = null;
		switch (cell.getCellType()) {
			case Cell.CELL_TYPE_NUMERIC:   //数字
				Double doubleValue = cell.getNumericCellValue();
				// 格式化科学计数法，取一位整数
				DecimalFormat df = new DecimalFormat("0");
				returnValue = df.format(doubleValue);
				break;
			case Cell.CELL_TYPE_STRING:    //字符串
				returnValue = cell.getStringCellValue();
				break;
			case Cell.CELL_TYPE_BOOLEAN:   //布尔
				Boolean booleanValue = cell.getBooleanCellValue();
				returnValue = booleanValue.toString();
				break;
			case Cell.CELL_TYPE_BLANK:     // 空值
				break;
			case Cell.CELL_TYPE_FORMULA:   // 公式
				returnValue = cell.getCellFormula();
				break;
			case -1:     // 故障
				return null;
			default:
				break;
		}
		return returnValue;
	}
}
