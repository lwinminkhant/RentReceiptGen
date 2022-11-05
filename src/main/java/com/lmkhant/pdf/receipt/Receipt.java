package com.lmkhant.pdf.receipt;

public class Receipt {
    private String roomNo = "";
    private String tenantName = "";
    private String amount = "";

    public Receipt() {
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getRoomNo() {
        return this.roomNo;
    }

    public String getName() {
        return this.tenantName;
    }

    public String getAmount() {
        return this.amount;
    }
}
