package com.lmkhant.myanmartext;

import com.itextpdf.layout.element.Paragraph;

public abstract class MyanmarParagraph extends Paragraph {
    public MyanmarParagraph() {
    }

    public Paragraph add(String text) {
        return super.add(text);
    }
}
