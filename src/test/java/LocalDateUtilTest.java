import com.lmkhant.myanmartext.NumTranslate;
import org.junit.Test;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;

public class LocalDateUtilTest {

    @Test
    public void monthYear(){
        Calendar calendar = Calendar.getInstance();
        LocalDate localDate = calendar.getTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        if(calendar.get(Calendar.DAY_OF_MONTH) > 20){
            localDate = localDate.plusMonths(1);
        }
        System.out.println(getMYMonthYear(localDate.getMonthValue(), localDate.getYear()));
    }

    private String getMYMonthYear(int month, int year){
        return String.format("%s လပိုင်း %s", NumTranslate.translate(NumTranslate.LANG.MY,month+""), NumTranslate.translate(NumTranslate.LANG.MY,year+""));
    }
    @Test
    public void osName(){
        //System.out.println(System.getProperty("os.name"));
        System.out.println(getPathOfWindows("a/b/1/7.com"));
    }

    private String getPathOfWindows(String path){
        return path.replaceAll("/","\\\\");
    }
}
