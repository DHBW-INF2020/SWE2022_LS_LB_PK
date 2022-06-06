import input.InputChannel;
import input.InputTransponder;
import org.junit.jupiter.api.Test;
import tree.Channel;
import tree.Node;
import tree.Satellite;
import tree.Transponder;

import java.util.ArrayList;

class InputHandlerTest {


    @Test
    void getSatellitesFromInputFormat() {
        InputTransponder[] inputTransponders = new InputTransponder[2];
        ArrayList<InputChannel> channels = new ArrayList<>();
        channels.add(new InputChannel("607", "Discovery Science HD"));
        channels.add(new InputChannel("608", "Discovery Science SD"));
        inputTransponders[0] = new InputTransponder("BulgariaSat-1", "1.9° E", "H", "12072", "30000", channels);
        inputTransponders[1] = new InputTransponder("BulgariaSat-1", "1.9° E", "V", "13072", "40000", channels);

        ArrayList<Node> satellites = new ArrayList<>();

        Satellite sat = new Satellite("BulgariaSat-1", "1.9° E");
        Transponder transponder1 = new Transponder("H", 12072, "30000");
        transponder1.addChild(new Channel("Discovery Science HD", 607));
        transponder1.addChild(new Channel("Discovery Science SD", 608));

        Transponder transponder2 = new Transponder("H", 12072, "30000");
        transponder2.addChild(new Channel("Discovery Science HD", 607));
        transponder2.addChild(new Channel("Discovery Science SD", 608));

        sat.addChild(transponder1);
        sat.addChild(transponder2);
        satellites.add(sat);

    }
}