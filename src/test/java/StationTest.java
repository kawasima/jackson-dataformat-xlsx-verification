import bean.Address;
import bean.Station;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SequenceWriter;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.github.sett4.dataformat.xlsx.XlsxFactory;
import com.github.sett4.dataformat.xlsx.XlsxMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class StationTest {
    private ObjectMapper mapper;

    @BeforeEach
    public void setup() {
        mapper = new ObjectMapper(new XlsxFactory());
    }

    @Test
    public void manuallyBuild() throws IOException, ParseException {
        CsvSchema schema =  CsvSchema.builder()
                .addColumn("駅名")
                .addColumn("乗降客数")
                .addColumn("開業日", CsvSchema.ColumnType.STRING)
                .build()
                .withHeader();

        writeXlsx(schema);
    }

    @Test
    public void javaClassSchema() throws IOException, ParseException {
        CsvSchema schema = new XlsxMapper().schemaFor(Station.class)
                .withHeader();
        writeXlsx(schema);
    }

    private void writeXlsx(CsvSchema schema) throws IOException, ParseException {
        File out = new File("station.xlsx");
        DateFormat df = new SimpleDateFormat("yyyy/mm/dd");
        try(SequenceWriter writer = mapper.writerFor(Station.class)
                .with(schema)
                .writeValues(out)) {

            writer.write(new Station("東京",     761_488, df.parse("1914/12/20")));
            writer.write(new Station("有楽町",   496_643, df.parse("1910/6/25")));
            writer.write(new Station("新橋",     661_224, df.parse("1909/12/16")));
            writer.write(new Station("浜松町",   418_352, df.parse("1909/12/16")));
            writer.write(new Station("田町",     351_836, df.parse("1909/12/16")));
            writer.write(new Station("品川",     810_164, df.parse("1872/6/12")));
            writer.write(new Station("大崎",     267_936, df.parse("1901/2/25")));
            writer.write(new Station("五反田",   295_511, df.parse("1911/10/15")));
            writer.write(new Station("目黒",     259_183, df.parse("1885/3/16")));
            writer.write(new Station("恵比寿",   337_010, df.parse("1901/2/25")));
            writer.write(new Station("渋谷",   1_459_721, df.parse("1885/3/1")));
            writer.write(new Station("原宿",     197_233, df.parse("1906/10/30")));
            writer.write(new Station("代々木",   157_294, df.parse("1906/9/23")));
            writer.write(new Station("新宿",   2_119_569, df.parse("1885/3/1")));
            writer.write(new Station("新大久保",  68_866, df.parse("1914/11/15")));
            writer.write(new Station("高田馬場", 500_681, df.parse("1910/9/15")));
            writer.write(new Station("目白",      76_486, df.parse("1885/3/16")));
            writer.write(new Station("池袋",   1_448_842, df.parse("1903/4/1")));
            writer.write(new Station("大塚",     105_964, df.parse("1903/4/1")));
            writer.write(new Station("巣鴨",     177_869, df.parse("1903/4/1")));
            writer.write(new Station("駒込",     109_970, df.parse("1910/11/15")));
            writer.write(new Station("田端",      86_800, df.parse("1896/4/1")));
            writer.write(new Station("西日暮里", 133_391, df.parse("1971/4/20")));
            writer.write(new Station("日暮里",   170_116, df.parse("1905/4/1")));
            writer.write(new Station("鶯谷",      46_473, df.parse("1912/7/11")));
            writer.write(new Station("上野",     444_280, df.parse("1883/7/28")));
            writer.write(new Station("御徒町",   169_143, df.parse("1925/11/1")));
            writer.write(new Station("秋葉原",   609_827, df.parse("1890/11/1")));
            writer.write(new Station("神田",     239_526, df.parse("1919/3/1")));
        }
    }

    @Test
    public void xtest() {
        System.out.println(new Locale("ja", "JP", "JP"));
    }
}
