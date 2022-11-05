package com.lmkhant.pdf.receipt;

import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Div;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import com.lmkhant.myanmartext.MyanmarParagraph;
import com.lmkhant.myanmartext.ZawgyiParagraph;
import com.lmkhant.sheet.SheetReader;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.IOException;

public class ReceiptDiv {
    private final ReceiptLabels receiptLabels;

    public ReceiptDiv() {
        this.receiptLabels = new ReceiptLabels("အခန်းလခ လက်ခံဖြတ်ပိုင်း", "ငှားသူအမည်", "အခန်းအမှတ်", "အခန်းခ");
    }

    public Div createPdf(String excelPath, String date) throws IOException, InvalidFormatException {
        Div div = new Div();
        div.setMargins(0,0,0,0);
        float[] f = {200F, 200F};
        UnitValue[] rootTableColumn = UnitValue.createPercentArray(f);
        Table rootTable = new Table(rootTableColumn);

        SheetReader sheetReader = new SheetReader(excelPath);
        for (int i = 0; i < sheetReader.getTotalRentRoom(); ++i) {
            rootTable.addCell(createReceipt(date, this.receiptLabels, sheetReader.getReceiptList().get(i)));
        }
        div.add(rootTable);

        return div;
    }

    private Cell createReceipt(String date, ReceiptLabels receiptLabels, Receipt receipt) {
        float[] pointColumnWidths = new float[]{100.0F, 150.0F};
        Table table = new Table(pointColumnWidths);
        table.setMargins(0.0F, 20.0F, 0.0F, 20.0F);

        Cell titleCell = new Cell(1, 2);
        titleCell.add(getParagraph().setTextAlignment(TextAlignment.CENTER).add(String.format("%s\n%s", date, receiptLabels.getTitle())));
        table.addCell(titleCell);


        table.addCell(getParagraph().add(receiptLabels.getNameLabel()));

        table.addCell(getParagraph().add(receipt.getName()));

        table.addCell(getParagraph().add(receiptLabels.getRoomNoLabel()));

        table.addCell(getParagraph().add(receipt.getRoomNo()));

        table.addCell(getParagraph().add(receiptLabels.getAmountLabel()));

        table.addCell(getParagraph().add(receipt.getAmount()));

        Cell borderLessTable = new Cell();
        borderLessTable.setBorder(Border.NO_BORDER);
        borderLessTable.setPadding(10.0F);
        borderLessTable.add(table);
        return borderLessTable;
    }

    private MyanmarParagraph getParagraph() {
        return new ZawgyiParagraph();
    }
}

