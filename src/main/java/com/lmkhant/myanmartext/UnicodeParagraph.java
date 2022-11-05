package com.lmkhant.myanmartext;

import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.layout.element.Paragraph;

import java.io.IOException;

public class UnicodeParagraph extends MyanmarParagraph {
    public UnicodeParagraph() {
        byte fontSize = 13;

        try {
            PdfFont pyidaungsu = PdfFontFactory.createFont("/home/lwinminkhant/fonts/Pyidaungsu.ttf", "Identity-H", true);
            this.setFont(pyidaungsu);
        } catch (IOException var3) {
            var3.printStackTrace();
        }

        this.setPaddings(0.0F, 5.0F, 0.0F, 5.0F);
        this.setFontSize((float)fontSize);
    }

    public Paragraph add(String text) {
        return super.add(text);
    }
}
