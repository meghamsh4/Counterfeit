package com.paxport.data.collector;

import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;

public class DisplayData {
	
    public static void showExelData(List<List<XSSFCell>> sheetData) {
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
