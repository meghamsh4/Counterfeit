package com.paxport.data.collector;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ParseExcelWorkBook {
	
	/**
	 * Extracts Data from Excel Sheet and Converts to Nested Java List.
	 * @param fileName String
	 * @return NestedList of XSSFCell
	 * @throws IOException Exception
	 */
	public List<List<XSSFCell>> extractSheetData(String fileName) throws IOException{
        //
        // Create an ArrayList to store the data read from excel sheet.
        //
        List<List<XSSFCell>> sheetData = new ArrayList<List<XSSFCell>>();

        FileInputStream fis = null;
        try {
            //
            // Create a FileInputStream that will be use to read the excel file.
            //
            fis = new FileInputStream(fileName);

            //
            // Create an excel workbook from the file system.
            //
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            //
            // Get the first sheet on the workbook.
            //
            XSSFSheet sheet = workbook.getSheetAt(0);

            //
            // When we have a sheet object in hand we can iterator on each
            // sheet's rows and on each row's cells. We store the data read
            // on an ArrayList so that we can printed the content of the excel
            // to the console.
            //
            Iterator<Row> rows = sheet.rowIterator();
            while (rows.hasNext()) {
                XSSFRow row = (XSSFRow) rows.next();
                Iterator<Cell> cells = row.cellIterator();

                List<XSSFCell> data = new ArrayList<XSSFCell>();
                while (cells.hasNext()) {
                	XSSFCell cell = (XSSFCell) cells.next();
                    data.add(cell);
                }

                sheetData.add(data);
            }
            return sheetData;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (fis != null) {
                fis.close();
                
            }
        }

	}

}
