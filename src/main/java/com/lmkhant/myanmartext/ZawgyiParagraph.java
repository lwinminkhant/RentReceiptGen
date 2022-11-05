package com.lmkhant.myanmartext;

import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.layout.element.Paragraph;
import com.lmkhant.controller.MainController;

import java.io.IOException;
import java.util.Objects;

public class ZawgyiParagraph extends MyanmarParagraph {
    private static PdfFont zawgyi;

    public PdfFont getFont() {
        if (zawgyi == null) {
            try {
                byte[] font = Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(MainController.getPathOSIndependent("fonts/zawgyione.ttf"))).readAllBytes();

                zawgyi = PdfFontFactory.createFont(font, "Identity-H", true);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        return zawgyi;
    }

    public ZawgyiParagraph() {
        this.setFont(getFont());
        this.setPaddings(0.0F, 5.0F, 0.0F, 5.0F);
        int fontSize = 13;
        this.setFontSize((float) fontSize);
    }

    public Paragraph add(String text) {
        return super.add(Rabbit.uni2zg(text));
    }
}

