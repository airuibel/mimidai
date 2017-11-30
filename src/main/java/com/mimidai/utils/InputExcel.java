package com.mimidai.utils;

import com.mimidai.entity.Excel;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static javax.xml.bind.JAXBIntrospector.getValue;

/**
 * Created by zhangyu on 2017/8/16.
 */
public class InputExcel {
    private static List<Excel> readXls() throws IOException {
        File file = new File("D:\\2.xls");
        InputStream is = new FileInputStream(file);
        XSSFWorkbook hssfWorkbook = new XSSFWorkbook(is);
        Excel xlsDto = null;
        List<Excel> list = new ArrayList<Excel>();
        // 循环工作表Sheet
        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
            XSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);

            if (hssfSheet == null) {
                continue;
            }
            // 循环行Row
            for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                XSSFRow hssfRow = hssfSheet.getRow(rowNum);
                if (hssfRow == null) {
                    continue;
                }
                xlsDto = new Excel();
                XSSFCell xh = hssfRow.getCell(0);
                if (xh == null) {
                    continue;
                }
                int a = Integer.parseInt(xh.toString());
                xlsDto.setUserId((long)Integer.parseInt(xh.toString()));
                XSSFCell xm = hssfRow.getCell(1);
                if (xm == null) {
                    continue;
                }
                xlsDto.setPhone(getValue(xm).toString());
                XSSFCell yxsmc = hssfRow.getCell(6);
                if (yxsmc == null) {
                    continue;
                }
                xlsDto.setState(getValue(yxsmc).toString());
                XSSFCell kcm = hssfRow.getCell(55);
                if (kcm == null) {
                    continue;
                }
                xlsDto.setOtherPhone(getValue(kcm).toString());
                XSSFCell cj = hssfRow.getCell(79);
                if (cj == null) {
                    continue;
                }
                xlsDto.setOtherPhone2((getValue(cj)).toString());
                list.add(xlsDto);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        try {
            List<Excel> excelList = readXls();
            System.out.println(excelList.size());
            System.out.println(excelList.get(0).getUserId()+","+excelList.get(0).getPhone()+","+excelList.get(0).getState()+","+excelList.get(0).getOtherPhone()+","+excelList.get(0).getOtherPhone2());
        } catch (Exception e) {
            System.out.println("读取异常" + e.toString());
        }
    }

}
