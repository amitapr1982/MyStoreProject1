package com.mystore.utility;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.*;
import org.testng.annotations.Test;

import java.io.*;

public class NewExcelLibrary {
        public static String path = System.getProperty("user.dir") + "\\src\\test\\resources\\TestData.xlsx";
        public FileInputStream fis = null;
        public FileOutputStream fileOut=null;
        private XSSFWorkbook workbook = null;
        private XSSFSheet sheet = null;
        private XSSFRow row=null;
        private XSSFCell cell = null;

        public NewExcelLibrary(){
            this.path =path;
            try{
                fis = new FileInputStream(path);
                workbook = new XSSFWorkbook(fis);
                sheet = workbook.getSheetAt(0);
                fis.close();

            }catch (Exception e){
                e.printStackTrace();
            }
        }
        public NewExcelLibrary(String path){
            this.path = path;
            try{
                fis = new FileInputStream(path);
                workbook = new XSSFWorkbook(fis);
                sheet = workbook.getSheetAt(0);
                fis.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        public String readData(String sheetname,int row,int col){
            workbook = new XSSFWorkbook();
            sheet = workbook.getSheet(sheetname);
            String data = sheet.getRow(row).getCell(col).getStringCellValue();
            return data;
        }
        public int getrowcount(String sheetName){
            sheet = workbook.getSheet(sheetName);
            int totalrowcount = sheet.getLastRowNum();
            return totalrowcount;
        }
        public int getcolumncount(String sheetname){
            int totalcolumcount = 0;
            sheet = workbook.getSheet(sheetname);
            int totalrow = sheet.getLastRowNum();

            for (int i=0; i<=totalrow;i++){
                Row sheetrow = sheet.getRow(i);
                for(int j=0; j<sheetrow.getLastCellNum();j++){
                    totalcolumcount = sheet.getRow(i).getCell(j).getColumnIndex();
                }
            }
            return totalcolumcount;
        }
        @Test
        public void readExcel() throws IOException {

        String excelPath= "C:\\Project\\PraticeProject\\TestData\\TestData.xlsx";

        String fileName="TestData";
        String sheetName ="Test";
        //Create object of file class
        File file = new File(excelPath);
        fis = new FileInputStream(file);

        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet(sheetName);

        int totalrowcount = sheet.getLastRowNum();
        String data = sheet.getRow(0).getCell(1).getStringCellValue();

        for (int i=0; i<=totalrowcount;i++){
            Row sheetrow = sheet.getRow(i);
            for(int j=0; j<sheetrow.getLastCellNum();j++){
                String data1 = sheet.getRow(i).getCell(j).getStringCellValue();
                System.out.print(data1 + " ");
            }
            System.out.println();
        }
        workbook.close();
    }
}
