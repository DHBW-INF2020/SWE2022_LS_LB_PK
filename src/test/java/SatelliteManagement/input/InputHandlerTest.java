package SatelliteManagement.input;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import SatelliteManagement.tree.*;

import org.junit.jupiter.api.TestInstance;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

import java.util.ArrayList;

/**
 * Class to test InputHandler
 * @author Lea Soffel
 * @version 1.0
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class InputHandlerTest {
    
/**
 * Testcases for method getSatellitesFromInputFormat
 */
	
    /**
     * Testcase 1: emptyInputTransponders = empty
     */
    @Test
    public void testcase1_getSatellitesFromInputFormat() {
    	
    	// build the inputTransponder-Array
    	ArrayList<InputTransponder> emptyInputTransponders = new ArrayList<>();

    	// build the expected Satellite-Array
        ArrayList<Node> expected = new ArrayList<>(); //empty array list
        
        // generate Satellite-Array by calling the tested method with test input 
        var actual = InputHandler.getSatellitesFromInputFormat(emptyInputTransponders);
        
        // check if expected Satellite equals actual generated Satellite (both empty)
        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }
    
    /**
     * Testcase 2: oneInputTransponders = [ Transponder ]
     */
    @Test
    public void testcase2_getSatellitesFromInputFormat() {
    	
    	// build the inputTransponder-Array
    	ArrayList<InputTransponder> oneInputTransponders = new ArrayList<>();
        ArrayList<InputChannel> channels = new ArrayList<>();
        // add one Channel to the channel array
        channels.add(new InputChannel("607", "Discovery Science HD"));
        // add one Transponder with one Channel
        oneInputTransponders.add(new InputTransponder("BulgariaSat-1", "1.9° E", "H", "12072", "30000", channels));

    	// build the expected Satellite-Array
        ArrayList<Node> expectedOneSatellite = new ArrayList<>();
        // create one satellite
        Satellite sat = new Satellite("BulgariaSat-1", "1.9° E");
        // create one Transponder
        Transponder transponder1 = new Transponder("H", "12072", "30000");
        // add one Channel as child
        transponder1.addChild(new Channel("Discovery Science HD", 607));
        // add Transponder to Satellite
        sat.addChild(transponder1);
        // add Satellite to Satellite-Array
        expectedOneSatellite.add(sat);
        
        // generate Satellite-Array by calling the tested method with test input 
        var actual = InputHandler.getSatellitesFromInputFormat(oneInputTransponders);
        
        // check if expected Satellite equals actual generated Satellite (both one Satellite)
        assertThat(actual).usingRecursiveComparison().isEqualTo(expectedOneSatellite);
    }
    
    
    /**
     * Testcase 2: twoInputTransponders = [ Transponder1, Transponder2 ] (test for multiple)
     */
    @Test
    public void testcase3_getSatellitesFromInputFormat() {
    	
    	// build the inputTransponder-Array
    	ArrayList<InputTransponder> twoInputTransponders = new ArrayList<>();
        ArrayList<InputChannel> channels = new ArrayList<>();
        // add one Channel to the channel array
        channels.add(new InputChannel("607", "Discovery Science HD"));
        // add first Transponder with one Channel
        twoInputTransponders.add(new InputTransponder("BulgariaSat-1", "1.9° E", "H", "12072", "30000", channels));
        // add second Transponder with one Channel
        twoInputTransponders.add(new InputTransponder("BulgariaSat-2", "1.9° E", "V", "12072", "30000", channels));

    	// build the expected Satellite-Array
        ArrayList<Node> expectedTwoSatellites = new ArrayList<>();
        // create first satellite
        Satellite sat1 = new Satellite("BulgariaSat-1", "1.9° E");
        // create one Transponder
        Transponder transponder1 = new Transponder("H", "12072", "30000");
        // add one Channel as child
        transponder1.addChild(new Channel("Discovery Science HD", 607));
        // add Transponder1 to Satellite1
        sat1.addChild(transponder1);
        
        // create second satellite
        Satellite sat2 = new Satellite("BulgariaSat-2", "1.9° E");
        // create one Transponder
        Transponder transponder2 = new Transponder("V", "12072", "30000");
        // add one Channel as child
        transponder2.addChild(new Channel("Discovery Science HD", 607));
        // add Transponder2 to Satellite2
        sat2.addChild(transponder2);
        // add Satellite1 and Satellite2 to Satellite-Array
        expectedTwoSatellites.add(sat1);
        expectedTwoSatellites.add(sat2);
        
        // generate Satellite-Array by calling the tested method with test input 
        var actual = InputHandler.getSatellitesFromInputFormat(twoInputTransponders);
        
        // check if expected Satellite equals actual generated Satellite (both two satellites)
        assertThat(actual).usingRecursiveComparison().isEqualTo(expectedTwoSatellites);
    }
    
    /**
     * Testcase 4: nullInputTransponders = null
     */
    @Test
    public void testcase4_getSatellitesFromInputFormat() {
    	
    	//TODOOOO
    	
/*    	// build the inputTransponder-Array
    	ArrayList<InputTransponder> nullInputTransponders = null;

    	// build the expected Satellite-Array
        ArrayList<Node> expected = new ArrayList<>(); //empty array list
        
        // generate Satellite-Array by calling the tested method with test input 
        var actual = InputHandler.getSatellitesFromInputFormat(emptyInputTransponders);
        
        // check if expected Satellite equals actual generated Satellite (both empty)
        assertThat(actual).usingRecursiveComparison().isEqualTo(expected); */
    }

    
/**
 * Testcases for method parseJsonToTreeThrowExceptionTest
 */
    

    /**
     * Testcase 1: emptyFilename = ""
     */
    @Test
    void testcase1_parseJsonToTreeThrowExceptionTest(){
        try{
            InputHandler.parseJsonToTree("");
            fail("Did not throw an IO Exception");
        }
        catch (RuntimeException e){
        	// irgendwas, dass Test gut verlief
        }
    }
    
    /**
     * Testcase 2: correctFilename = ""
     */
    @Test
    void testcase2_parseJsonToTreeThrowExceptionTest(){
        try{
            InputHandler.parseJsonToTree("input.json");
        }
        catch (RuntimeException e){
        	fail("Did throw an Exception, but should not");
        }
    }
    
    
    /**
     * Testcase 3: nullFilename = null
     */
    @Test
    void testcase3_parseJsonToTreeThrowExceptionTest(){
        try{
            InputHandler.parseJsonToTree(null);
            fail("Did not throw an IO Exception");
        }
        catch (RuntimeException e){
        	// irgendwas, dass Test gut verlief
        }
    }
    
    
    /**
     * Testcase 4: notExistFilename = "input.xml" 
     */
    @Test
    void testcase4_parseJsonToTreeThrowExceptionTest(){
        try{
            InputHandler.parseJsonToTree("input.xml");
            fail("Did not throw an IO Exception");
        }
        catch (RuntimeException e){
        	// irgendwas, dass Test gut verlief
        }
    }



}