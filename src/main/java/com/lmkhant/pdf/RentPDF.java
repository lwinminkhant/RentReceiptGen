package com.lmkhant.pdf;

import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.lmkhant.pdf.rentallist.RentalList;
import com.lmkhant.pdf.receipt.ReceiptDiv;
import com.lmkhant.utils.LocalDateUtil;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.IOException;

public class RentPDF {
    public void createPdf(String dest, String excelPath) throws IOException, InvalidFormatException {
        PdfWriter writer = new PdfWriter(dest);
        PdfDocument pdf = new PdfDocument(writer);
        PageSize pageSize = PageSize.A4;
        Document document = new Document(pdf, pageSize);
        document.setMargins(0,0,0,0);

        RentalList data = new RentalList();
        ReceiptDiv receiptDiv = new ReceiptDiv();
        LocalDateUtil gen = new LocalDateUtil();

        document.add(data.createPdf(pageSize, excelPath, gen.receiptTitleByDate()));
        document.add(receiptDiv.createPdf(excelPath, gen.receiptTitleByDate()));
        document.close();

    }
}
