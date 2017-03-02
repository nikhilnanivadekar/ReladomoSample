package example.complex.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil
{
    private static SimpleDateFormat timestampFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static Date parseDate(String source)
    {
        try
        {
            return timestampFormat.parse(source);
        }
        catch (ParseException e)
        {
            throw new RuntimeException("Could not read date "+source, e);
        }
    }

}
