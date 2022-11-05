package com.lmkhant.utils;

import com.lmkhant.myanmartext.NumTranslate;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;

public class LocalDateUtil {
    LocalDate localDate;
    public LocalDateUtil(){
        Calendar calendar = Calendar.getInstance();
        localDate = calendar.getTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        if(calendar.get(Calendar.DAY_OF_MONTH) > 20){
            localDate = localDate.plusMonths(1);
        }
    }
    public String dirByDate(){
        return String.format("%d_%d",localDate.getMonthValue(), localDate.getYear());
    }
    public String receiptTitleByDate(){
        return monthlyReceiptTitle(localDate.getMonthValue(), localDate.getYear());
    }

    private String monthlyReceiptTitle(int month, int year){
        return String.format("%s လပိုင်း %s", NumTranslate.translate(NumTranslate.LANG.MY,month+""), NumTranslate.translate(NumTranslate.LANG.MY,year+""));
    }
}
