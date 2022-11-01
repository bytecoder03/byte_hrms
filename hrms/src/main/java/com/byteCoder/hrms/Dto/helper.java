package com.byteCoder.hrms.Dto;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;







public class helper 
{
	public static boolean checkExcelFormat(MultipartFile file)
	{
		String CType= file.getContentType();
		
		if(CType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public  static List<StudentDetails> convertExcelToList(InputStream is)
	{
		List<StudentDetails> list = new ArrayList<>();
		try {
			XSSFWorkbook workbook=new XSSFWorkbook(is);
			XSSFSheet sheet=workbook.getSheet("data1");
			
			int rowNumber = 0;
			
			Iterator<Row> iterator	=sheet.iterator();

            while (iterator.hasNext()) {
                Row row = iterator.next();

                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cells = row.iterator();

                int cid = 0;

                StudentDetails s = new StudentDetails();

                while (cells.hasNext()) {
                    Cell cell = cells.next();

                    switch (cid) {
                        case 0:
                            s.setId((int) cell.getNumericCellValue());
                            break;
                        case 1:
                            s.setName(cell.getStringCellValue());
                            break;
                        case 2:
                            s.setEmail(cell.getStringCellValue());
                            break;
                        case 3:
                            s.setPass(cell.getStringCellValue());
                            break;
                        default:
                            break;
                    }
                    cid++;

                }

                list.add(s);


            }
			
			
		}
		catch (Exception e) {
			
		}
		return list;
	}

}
