package com.lmkhant.sheet;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import com.lmkhant.pdf.receipt.Receipt;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SheetReader {
    private final List<Receipt> receiptList = new ArrayList<>();

    public SheetReader(String path) throws IOException, EncryptedDocumentException, InvalidFormatException  {
        FileInputStream ip = new FileInputStream(path);

        Workbook wb = WorkbookFactory.create(ip);
        Sheet sheet = wb.getSheet("Sheet1");
        int rowCount = sheet.getLastRowNum();
        int cellCount = 3;

        for(int i = 0; i <= rowCount; ++i) {
            Receipt receipt = new Receipt();

            for(int ii = 0; ii < cellCount; ++ii) {
                Row row = sheet.getRow(i);
                Cell cell = row.getCell(ii);
                switch(ii) {
                    case 0:
                        receipt.setRoomNo(cell.getStringCellValue());
                        break;
                    case 1:
                        receipt.setTenantName(cell.getStringCellValue());
                        break;
                    case 2:
                        receipt.setAmount(cell.getStringCellValue());
                }
            }

            this.receiptList.add(receipt);
        }

        ip.close();
    }

    public List<Receipt> getReceiptList() {
        return this.receiptList;
    }

    public int getTotalRentRoom() {
        return this.receiptList.size();
    }
}
