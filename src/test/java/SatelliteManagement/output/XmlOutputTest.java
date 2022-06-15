package SatelliteManagement.output;

import SatelliteManagement.tree.Channel;
import SatelliteManagement.tree.Node;
import SatelliteManagement.tree.Root;
import SatelliteManagement.tree.Satellite;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.assertj.core.api.Assertions.assertThat;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class XmlOutputTest {
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
        iOutputVisitor outputVisitor = new XmlOutputVisitor();
        inputRoot.accept(outputVisitor);
        var actual = outputVisitor.getParsedData();
        var expected = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><channels>\n" +
                "  <channel name=\"Das Erste\">\n" +
                "    <satellites>\n" +
                "      <sat name=\"Astra 1N\" orbital=\"19.2° E\"/>\n" +
                "      <sat name=\"Intelsat 20\" orbital=\"68.5° E\"/>\n" +
                "    </satellites>\n" +
                "  </channel>\n" +
                "  <channel name=\"ZDF HD\">\n" +
                "    <satellites>\n" +
                "      <sat name=\"Astra 4A\" orbital=\"4.8 ° E\"/>\n" +
                "      <sat name=\"Astra 1KR\" orbital=\"4.8° E\"/>\n" +
                "    </satellites>\n" +
                "  </channel>\n" +
                "</channels>\n";
        assertThat(actual).isEqualToNormalizingNewlines(expected);
    }
}