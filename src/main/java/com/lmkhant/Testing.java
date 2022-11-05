package com.lmkhant;

import java.io.File;

public class Testing {
    private String excelPath;
    private String getExcelPath(){
        return excelPath;
    }
    public static void main(String[] args) {
        new Testing().start();
    }
    private void start(){
        excelPath = getClass().getResource("/t.txt").getPath();
        System.out.println(excelPath);
        String pd = "၆ လပိုင်း ၂၀၂၀";
        String DIR = String.format("src/main/resources/export/%s/", pd);
        (new File(DIR)).mkdir();
        String RENT_ROOM = "src/main/resources/RentRoom.com.lmkhant.pdf";
        String RECEIPT = "src/main/resources/RentReceipt.com.lmkhant.pdf";
        String DATA = "src/main/resources/Data.com.lmkhant.pdf";
        //RentReceipt rentReceipt = new RentReceipt(pd);

        //rentReceipt.createPdf(RECEIPT,main.getExcelPath());

        /*try{
            RentRoomPDF rentRoomPDF = new RentRoomPDF(RENT_ROOM, this.excelPath ,pd);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }*/
    }
}
