import org.apache.log4j.PropertyConfigurator;
import scala.collection.JavaConverters;
import scala.collection.Seq;

import java.util.List;
import java.util.Properties;

public class ProfilingAbstract {

    public static String replaceString(String str, String delimiter){
        return str.replaceAll(delimiter, "");
    }

    public static Properties prop = System.getProperties();

    public static Seq<String> convertListToSeq(List<String> list){
        return JavaConverters.asScalaIteratorConverter(list.iterator()).asScala().toSeq();
    }

    public static void setLogging(String filePath, String log4jPropertyFilePath){
        String logFileName = filePath+".log";
        prop.setProperty("logPath", logFileName);
        PropertyConfigurator.configure(log4jPropertyFilePath);
    }
}
