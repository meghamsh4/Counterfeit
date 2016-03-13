package com.paxport.data.collector;

/**
 * A Sample to read data from excel
 * @author meghanap
 *
 */
public class ReadExcelData {
	public static void main(String[] args) throws Exception {
		ParseExcelWorkBook parserObject = new ParseExcelWorkBook();
        DisplayData.showExelData(parserObject.extractSheetData("Resources/ItemData.xlsx"));
    }


}
