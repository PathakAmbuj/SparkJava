import org.apache.spark.sql.types.StructType;

import java.io.Serializable;
import java.util.Date;

public class Emp implements Serializable {


    public String NAME;
    public Integer EMP_ID;
    public String JOIN_DATE;


    public Emp(String NAME, Integer EMP_ID, String JOIN_DATE) {
        this.NAME = NAME;
        this.EMP_ID = EMP_ID;
        this.JOIN_DATE = JOIN_DATE;
    }

    public Emp() {
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public Integer getEMP_ID() {
        return EMP_ID;
    }

    public void setEMP_ID(Integer EMP_ID) {
        this.EMP_ID = EMP_ID;
    }

    public String getJOIN_DATE() {
        return JOIN_DATE;
    }

    public void setJOIN_DATE(String JOIN_DATE) {
        this.JOIN_DATE = JOIN_DATE;
    }
}
