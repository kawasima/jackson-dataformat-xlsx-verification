import bean.Address;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SequenceWriter;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.github.sett4.dataformat.xlsx.XlsxFactory;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class PrefectureTest {
    @Test
    public void prefecture() throws IOException {
        ObjectMapper mapper = new ObjectMapper(new XlsxFactory());
        File out = new File("out.xlsx");
        CsvSchema schema = CsvSchema.builder()
                .addColumn("prefecture")
                .addColumn("city")
                .build()
                .withoutHeader();
        try(SequenceWriter writer = mapper.writerFor(Address.class)
                .with(schema)
                .writeValues(out)) {

            writer.write(new Address("Tokyo", "Suginami"));
            writer.write(new Address("Tokyo", "Taitou"));
            writer.write(new Address("Tokyo", "Chuo"));
        }
    }
}
