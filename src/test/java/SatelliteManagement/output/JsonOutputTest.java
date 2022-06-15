package SatelliteManagement.output;

import SatelliteManagement.tree.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class JsonOutputTest {

    private Root inputRoot;

    @BeforeAll
    public void init(){
        inputRoot = new Root();
        Node channel1 = new Channel("Das Erste", 100);
        Node sat1 = new Satellite("Astra 1N", "19.2° E");
        Node sat2 = new Satellite("Intelsat 20", "68.5° E");
        channel1.addChild(sat1);
        channel1.addChild(sat2);
        Node channel2 = new Channel("ZDF HD", 100);
        Node sat3 = new Satellite("Astra 4A", "4.8 ° E");
        Node sat4 = new Satellite("Astra 1KR", "4.8° E");
        channel2.addChild(sat3);
        channel2.addChild(sat4);
        inputRoot.addChild(channel1);
        inputRoot.addChild(channel2);
    }

    @Test
    public void getParsedDataTest(){
        iOutputVisitor outputVisitor = new JsonOutputVisitor();
        inputRoot.accept(outputVisitor);
        var actual = outputVisitor.getParsedData();
        var expected = "[\n" +
                "  {\n" +
                "    \"channel\": \"Das Erste\",\n" +
                "    \"satellites\": [\n" +
                "      {\n" +
                "        \"sat\": \"Astra 1N\",\n" +
                "        \"orbital\": \"19.2° E\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"sat\": \"Intelsat 20\",\n" +
                "        \"orbital\": \"68.5° E\"\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    \"channel\": \"ZDF HD\",\n" +
                "    \"satellites\": [\n" +
                "      {\n" +
                "        \"sat\": \"Astra 4A\",\n" +
                "        \"orbital\": \"4.8 ° E\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"sat\": \"Astra 1KR\",\n" +
                "        \"orbital\": \"4.8° E\"\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "]";
        assertThat(actual).isEqualTo(expected);
    }
}
