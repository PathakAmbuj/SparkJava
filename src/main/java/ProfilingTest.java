import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.broadcast.Broadcast;
import org.apache.spark.sql.*;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;
import scala.reflect.ClassTag;
import org.apache.spark.sql.Row;
import scala.reflect.api.TypeTags;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class ProfilingTest extends ProfilingAbstract {

    public static void main(String[] args) {

        setLogging("src/main/resources/appLog", "src/main/resources/log4j.properties");

        SparkSession spark = SparkSession.builder().appName("profiling").master("local").getOrCreate();


        List<StructField> fields = new ArrayList<>();
        fields.add(DataTypes.createStructField("NAME", DataTypes.StringType, true));
        fields.add(DataTypes.createStructField("EMP_ID", DataTypes.IntegerType, true));
        fields.add(DataTypes.createStructField("JOIN_DATE", DataTypes.StringType, true));
        StructType primarySchema = DataTypes.createStructType(fields);

        Dataset<Row> schemads = spark.read().format("csv").schema(primarySchema).option("delimiter", "|").load("testdata.csv");


        List<Row> list = new ArrayList<>();
        List<String> coldata = new ArrayList<>();
        coldata.add("a");
        coldata.add("b");
        coldata.add("c");
        List<Emp> empList= new ArrayList<>();
        Emp e1 = new Emp("Ambuj", 12345, "12/10/20");
        empList.add(e1);

        //Dataset<Row> emptyDS = spark.createDataFrame(list, primarySchema);
        Dataset<Row> brdDS = spark.createDataFrame(empList, Emp.class);
        brdDS.show();
        //brdDS.withColumn("arrCol", functions.typedLit(convertListToSeq(coldata), TypeTags.TypeTag.Object())).show();
        //Dataset <Row> ds =emptyDS.union(schemads);


     /*  String[] result = schemads.collectAsList().stream().map(row -> row.mkString(","))
                .toArray(String[]::new);

        //ds.map(x -> x.mkString("")).collect()

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

        List<Row> schemaList = schemads.collectAsList();

        List<StructField> fields = new ArrayList<>();

        for (int i = 0; i < schemaList.size(); i++) {
            String str = schemaList.get(i).mkString(",");
            String[] type = str.split(",");
            if (type[1].equalsIgnoreCase("string")) {
                fields.add(DataTypes.createStructField(type[0], DataTypes.StringType, true));
            } else if (type[1].equalsIgnoreCase("int")) {
                fields.add(DataTypes.createStructField(type[0], DataTypes.IntegerType, true));
            } else if (type[1].equalsIgnoreCase("date")) {
                fields.add(DataTypes.createStructField(type[0], DataTypes.DateType, true));
            }
        }

        StructType primarySchema = DataTypes.createStructType(fields);

        fields.forEach(x -> System.out.println(x));

        JavaRDD<String> rdd = spark.read().textFile("testdata.csv").toJavaRDD();*/

        // rdd.map(line -> line.split("\\|\\|")).foreach(x -> System.out.println(x));

      /*  Dataset<Row> customDS = spark.read().format("csv").option("delimiter", "|").option("delimiter", "\t")
                .csv(spark.sqlContext().read().textFile("filename")
                        .map(line -> line.split("\\|").mkString("\t")));

        JavaRDD<Row> rdd1 = rdd.map((Function<String, Row>) RowFactory::create);

        JavaRDD<Row> rdd2 = spark.read().textFile("testdata.csv").javaRDD()
                .map(new Function<String, Row>() {
                    @Override
                    public Row call(String arg0) {
                        String[] data = arg0.split("|");
                        return RowFactory.create(data[0], data[1], data[2]);
                    }
                });

        rdd2.foreach(l -> System.out.println(l));

        String schemaStr = "columnToSplit|,ambuj|,suraj";

        String replaced = replaceString(schemaStr, ",");
        System.out.println(replaced);
        List<StructField> scmList = new ArrayList<>();

        for (int i = 0; i < schemaList.size(); i++) {
            String scmaField = schemaList.get(i).mkString(",");
            String[] type = scmaField.split(",");
            scmList.add(DataTypes.createStructField(type[0], DataTypes.StringType, true));
        }
        StructType schema = DataTypes.createStructType(scmList);

        // Dataset<Row> ds1 = spark.createDataFrame(rdd1, schema);

        Dataset<Row> ds = spark.read().format("csv").option("mode", "DROPMALFORMED")
                .schema(primarySchema).option("delimiter", "|").load("testdata.csv");
        ds.show();
        ds.printSchema();

        ds.createOrReplaceTempView("temp");
        Dataset<Row> ds1 = spark.sql("Select *, NAME= " +
                "CASE WHEN NAME IS NULL THEN 'I am NULL' " +
                "WHEN NAME='' THEN 'I am Blank' " +
                "ELSE NAME " +
                "END" +
                "from temp");
        ds1.show();*/
        //ds1.selectExpr("explode(split(columnToSplit, '|')) as temp").show();

        // ds1.withColumn("temp", functions.split(functions.col("columnToSplit"), "\\|")).show();

    }

}