package com.lmkhant.myanmartext;

/**
 * @author lwinminkhant
 */
public class NumTranslate {
    private static final String[] myNumbers = {"၁","၂","၃","၄","၅","၆","၇","၈","၉","၀"};
    private static final String[] enNumbers = {"1","2","3","4","5","6","7","8","9","0"};
    public enum LANG{ENG,MY}
    private static String translate(String[] from, String[] to,String text){
        for(int i=0; i < from.length;i++){
            text = text.replaceAll(from[i],to[i]);
        }
        return text;
    }
    public static String translate(LANG lang,String text){
        if (lang == LANG.ENG) {
            return translate(myNumbers, enNumbers,text);
        }else return translate(enNumbers, myNumbers,text);
    }
}
