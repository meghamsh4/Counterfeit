package com.paxport.data.collector;

import java.io.File;
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
/**
 * A Sample to read data from excel
 * @author meghanap
 *
 */
public class ReadExcelData {
	public static void main(String[] args) throws Exception {
        //
        // An excel file name. You can create a file name with a full path
        // information.
        //
		String filename = "Resources/ItemData.xlsx";


        //
        // Create an ArrayList to store the data read from excel sheet.
        //
        List<List<XSSFCell>> sheetData = new ArrayList<List<XSSFCell>>();

        FileInputStream fis = null;
        try {
            //
            // Create a FileInputStream that will be use to read the excel file.
            //
            fis = new FileInputStream(filename);

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
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                fis.close();
            }
        }

        showExelData(sheetData);
    }

    private static void showExelData(List<List<XSSFCell>> sheetData) {
        //
        // Iterates the data and print it out to the console.
        //
        for (int i = 0; i < sheetData.size(); i++) {
            List<XSSFCell> list = (List<XSSFCell>) sheetData.get(i);
            for (int j = 0; j < list.size(); j++) {
                XSSFCell cell = (XSSFCell) list.get(j);
                System.out.print(cell);
                if (j < list.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("");
        }
    }

}
