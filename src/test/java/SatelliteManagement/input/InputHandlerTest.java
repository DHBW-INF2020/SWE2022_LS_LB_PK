package SatelliteManagement.input;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import SatelliteManagement.tree.*;

import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.beans.SamePropertyValuesAs.samePropertyValuesAs;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class InputHandlerTest {
    private final ArrayList<InputTransponder> inputTransponders = new ArrayList<>();
    @BeforeAll
    public void init(){
        ArrayList<InputChannel> channels = new ArrayList<>();
        channels.add(new InputChannel("607", "Discovery Science HD"));
        channels.add(new InputChannel("608", "Discovery Science SD"));
        inputTransponders.add(new InputTransponder("BulgariaSat-1", "1.9° E", "H", "12072", "30000", channels));
        inputTransponders.add(new InputTransponder("BulgariaSat-1", "1.9° E", "V", "13072", "40000", channels));
    }

    @Test
    public void getSatellitesFromInputFormatTest1() {

        ArrayList<Node> expected = new ArrayList<>();
        Satellite sat = new Satellite("BulgariaSat-1", "1.9° E");
        Transponder transponder1 = new Transponder("H", "12072", "30000");
        transponder1.addChild(new Channel("Discovery Science HD", 607));
        transponder1.addChild(new Channel("Discovery Science SD", 608));

        Transponder transponder2 = new Transponder("H", "12072", "30000");
        transponder2.addChild(new Channel("Discovery Science HD", 607));
        transponder2.addChild(new Channel("Discovery Science SD", 608));
        sat.addChild(transponder1);
        sat.addChild(transponder2);
        expected.add(sat);

        var actual = InputHandler.getSatellitesFromInputFormat(inputTransponders);
        assertThat(actual, samePropertyValuesAs(expected));
    }

    @Test
    public void getSatellitesFromInputFormatTest2() {

        ArrayList<Node> expected = new ArrayList<>();
        Satellite sat = new Satellite("BulgariaSat-1", "1.9° E");
        Transponder transponder1 = new Transponder("H", "12072", "30000");
        transponder1.addChild(new Channel("Discovery Science HD", 607));
        transponder1.addChild(new Channel("Discovery Science SD", 608));

        Transponder transponder2 = new Transponder("H", "12072", "30000");
        transponder2.addChild(new Channel("Discovery Science HD", 607));
        transponder2.addChild(new Channel("Discovery Science SD", 608));
        sat.addChild(transponder1);
        sat.addChild(transponder2);
        expected.add(sat);

        ArrayList<InputChannel> channels = new ArrayList<>();
        channels.add(new InputChannel("608", "Discovery Science 4K"));
        inputTransponders.add(new InputTransponder("BulgariaSat-2", "1.9° E", "H", "12072", "30000", channels));
        Satellite sat2 = new Satellite("BulgariaSat-2", "1.9° E");
        Transponder transponder3 = new Transponder("H", "12072", "30000");
        transponder3.addChild(new Channel("Discovery Science 4K", 608));
        sat2.addChild(transponder3);
        expected.add(sat2);

        var actual = InputHandler.getSatellitesFromInputFormat(inputTransponders);
        assertThat(actual, is(samePropertyValuesAs(expected)));
    }


    @Test
    void parseJsonToTreeThrowExceptionTest(){
        try{
            InputHandler.parseJsonToTree("doesNotExist");
            fail("Did not throw an IO Exception");
        }
        catch (RuntimeException e){
        }
    }

}