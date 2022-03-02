package blood4life.commons.infra;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

public class Utilities {

    public static String loadProperty(String key) {
        Properties prop = new Properties();
        InputStream is;

        try {
            is = new FileInputStream("./config.properties");
            prop.load(is);
        } catch (IOException e) {
            System.out.println("Error al cargar el archivo");
        }

        return prop.getProperty(key);
    }
    
    public static boolean isNumeric(String str) {

        boolean resultado;

        try {
            Integer.parseInt(str);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }

        return resultado;
    }
    
    public static java.sql.Date DateToDateSQL(Date dateToConvert) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String sdate = simpleDateFormat.format(dateToConvert);
        return java.sql.Date.valueOf(sdate);
    }
    
    
    public static java.sql.Date ActualDateToDateSQL() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String sdate = simpleDateFormat.format(Calendar.getInstance().getTime());
        return java.sql.Date.valueOf(sdate);
    }
    
    public static boolean fun(Object obj, String c)
                    throws ClassNotFoundException
    {
        return Class.forName(c).isInstance(obj);
    }

}
