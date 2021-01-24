/**
 * 
 */
package com.wechat_server.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.wechat_server.DTO.Lduser;

import lombok.extern.slf4j.Slf4j;

/** @version:1.0
* @Description:
* @author:spy
* @date: 
*/
@RestController
@Slf4j
public class FileController {


	 SimpleDateFormat sd = new SimpleDateFormat("yyyy/MM/dd");
	    @PostMapping(value="/upload")
	    public String upload(MultipartFile uploadFile, HttpServletRequest req){
	    String fileName=uploadFile.getOriginalFilename();
	    if(!fileName.matches("^.+\\.(?i)(xls)$")&&!fileName.matches("^.+\\.(?i)(xlsx)$")) {
	    	return "文件格式错误";
	    }
	    try {
			InputStream tInputStream=uploadFile.getInputStream();
			String[] tableHead= {"指标编码","指标名称","指标值"};
			Workbook workbook=WorkbookFactory.create(tInputStream);
		    Sheet sheet1=null;
		    sheet1 = workbook.getSheetAt(0);
		    Row rowHead=sheet1.getRow(0);
		    int cells=rowHead.getPhysicalNumberOfCells();
		    if(cells!=tableHead.length) {
		    	return "excel文件导入模板错误";
		    }
		    for(int i=1;i<tableHead.length;i++) {
		    	String cell=rowHead.getCell(i, Row.CREATE_NULL_AS_BLANK).getRichStringCellValue().getString().trim();
		    	if(!tableHead[i].equals(cell)) {
		    		return "表头内容错误！";
		    	}
		    }
		    for(int r=1;r<sheet1.getPhysicalNumberOfRows();r++) {
		    	Row row=sheet1.getRow(r);
		    	Lduser tLduser=new Lduser();
		    	tLduser.setUserCode(Integer.valueOf(getCellValue(row.getCell(0))));
		    }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return "处理成功";
	    }
	    
	    @RequestMapping("/download")
	    public void downloadFile(HttpServletResponse response) throws IOException {
			 try {
				 	Resource resource = new ClassPathResource("poi/运费模板.xlsx");
		    		File file = resource.getFile();
		    		String filename = resource.getFilename();
		    		InputStream inputStream = new FileInputStream(file);
	                //强制下载不打开
		    		response.setContentType("application/force-download");
		            OutputStream out = response.getOutputStream();
	                //使用URLEncoder来防止文件名乱码或者读取错误
		            response.setHeader("Content-Disposition", "attachment; filename="+URLEncoder.encode(filename, "UTF-8"));
		            int b = 0;
		            byte[] buffer = new byte[1000000];
		            while (b != -1) {
		                b = inputStream.read(buffer);
		                if(b!=-1) out.write(buffer, 0, b);
		            }
		            inputStream.close();
		            out.close();
		            out.flush();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
	    }
	    		
	    	
	    
         @SuppressWarnings("deprecation")
		public static String getCellValue(Cell cell) {
        	 String value="";
        	 if(cell!=null) {
        		 switch(cell.getCellType()) {
        		 case HSSFCell.CELL_TYPE_NUMERIC:
        			 if(HSSFDateUtil.isCellDateFormatted(cell)) {
        				 SimpleDateFormat tSimpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        				 value=tSimpleDateFormat.format(HSSFDateUtil.getJavaDate(cell.getNumericCellValue()));
        				 break;
        			 }else {
        				 value=new DecimalFormat("0").format(cell.getNumericCellValue());
        				 break;
        			 }
        		 case HSSFCell.CELL_TYPE_STRING:
        			 value=cell.getStringCellValue();
        			 break;
        		 
        		 
        		 case HSSFCell.CELL_TYPE_BLANK:
        			 value="";
        			 break;
        		 case HSSFCell.CELL_TYPE_ERROR:
        			 value="";
        			 break;
        		default :
        			value=cell.getStringCellValue();
        	 }
         }
        	 return value;

}
         
}