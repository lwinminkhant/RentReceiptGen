package com.lmkhant.pdf.receipt;

public class ReceiptLabels {
    private String title;
    private String nameLabel;
    private String roomNoLabel;
    private String amountLabel;

    private ReceiptLabels() {
    }

    public ReceiptLabels(String title, String nameLabel, String roomNoLabel, String amountLabel) {
        this.title = title;
        this.nameLabel = nameLabel;
        this.roomNoLabel = roomNoLabel;
        this.amountLabel = amountLabel;
    }

    public String getTitle() {
        return this.title;
    }

    public String getNameLabel() {
        return this.nameLabel;
    }

    public String getRoomNoLabel() {
        return this.roomNoLabel;
    }

    public String getAmountLabel() {
        return this.amountLabel;
    }
}

