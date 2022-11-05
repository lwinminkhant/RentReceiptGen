package com.lmkhant.pdf.rentallist;

import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Div;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import com.lmkhant.myanmartext.MyanmarParagraph;
import com.lmkhant.myanmartext.ZawgyiParagraph;
import com.lmkhant.pdf.receipt.Receipt;
import com.lmkhant.sheet.SheetReader;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.IOException;

public class RentalList {
    private Table rootTable;
    private Table leftSide;
    private Table rightSide;
    private PageSize pageSize;

    public Div createPdf(PageSize pageSize, String excelPath, String date) throws IOException, InvalidFormatException {
        Div div = new Div();
        this.pageSize = pageSize;
        div.setMargins(70.0F, 0.0F, 0.0F, 0.0F);
        SheetReader sheetReader = new SheetReader(excelPath);
        int totalRoom = sheetReader.getTotalRentRoom();
        int side = 0;
        this.addDate(div, date);
        this.newPage();

        for (int i = 0; i < totalRoom; i++) {
            Receipt rr = sheetReader.getReceiptList().get(i);
            if (side < 25) {
                if (side == 0) {
                    this.addHead(this.leftSide);
                }
                this.createRow(this.leftSide, rr.getRoomNo(), rr.getName(), rr.getAmount(), "");
            } else {
                if (side == 25) {
                    this.addHead(this.rightSide);
                }

                this.createRow(this.rightSide, rr.getRoomNo(), rr.getName(), rr.getAmount(), "");

                if (side == 49) { //More than 50 rows
                    side = -1;
                    this.add2Page(div);
                    this.addDate(div, date);
                    this.newPage();
                }

                if (i == totalRoom - 1) {
                    this.add2Page(div);
                }
            }
            side++;
        }
        return div;
    }

    private void newPage() {
        this.rootTable = this.rootTable();
        this.leftSide = this.getSideTable();
        this.rightSide = this.getSideTable();
    }

    private void add2Page(Div page) {
        this.rootTable.addCell(this.getNoBorderCell(this.leftSide));
        this.rootTable.addCell(this.getNoBorderCell(this.rightSide));
        page.add(this.rootTable);
    }

    private Cell getNoBorderCell(Table table) {
        Cell c = new Cell();
        c.add(table);
        c.setBorder(Border.NO_BORDER);
        return c;
    }

    private Table rootTable() {
        float[] f = {200F, 200F};
        UnitValue[] rootTableColumn = UnitValue.createPercentArray(f);
        Table table = new Table(rootTableColumn);
        table.setWidth(pageSize.getWidth());
        table.setBorder(Border.NO_BORDER);
        return table;
    }

    private Table getSideTable() {
        float[] points = new float[]{10.0F, 30.0F, 20.0F, 10.0F};
        Table table = new Table(points);
        table.setBorder(Border.NO_BORDER);
        table.setWidth((pageSize.getWidth() / 2.0F) - 5);
        return table;
    }

    private void addHead(Table side) throws IOException{
        this.createRow(side, "No.", "အမည်", "အခန်းခ", "ပေးပြီး");
    }

    private MyanmarParagraph getParagraph(){
        MyanmarParagraph up = new ZawgyiParagraph();
        up.setFontSize(12.0F);
        up.setPaddings(-4.0F, 5.0F, -4.0F, 5.0F);
        return up;
    }

    private void addDate(Div sheet, String date) throws IOException{
        MyanmarParagraph dateText = this.getParagraph();
        dateText.add(date);
        dateText.setPaddingLeft(5.0F);
        dateText.setBold();
        sheet.add(dateText);
    }

    private void createRow(Table table, String noL, String name, String amount, String checkBoxL) throws IOException{

        table.addCell(getParagraph().setTextAlignment(TextAlignment.CENTER).add(noL));

        table.addCell(getParagraph().add(name));

        table.addCell(getParagraph().setTextAlignment(TextAlignment.RIGHT).add(amount));

        table.addCell(getParagraph().add(checkBoxL));
    }
}

