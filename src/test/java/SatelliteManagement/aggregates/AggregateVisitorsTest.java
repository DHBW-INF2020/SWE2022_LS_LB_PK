package SatelliteManagement.aggregates;

import SatelliteManagement.tree.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

/**
 * Class to test both aggregates
 * @author Lukas Benner
 *
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AggregateVisitorsTest {
	
	// define root for test tree
    private final Node inputroot = new Root();

    /**
     * Build test tree as input for the aggregate tests
     */
    @BeforeAll
    public void init(){
        Node sat1 = new Satellite("BulgariaSat-1", "1.9° E");
        Node trans1 = new Transponder("H", "30000", "30");
        Node channel = new Channel("RTL", 100);
        Node sat2 = new Satellite("BulgariaSat-2", "1.9° N");
        Node trans2 = new Transponder("V", "30000", "10");
        trans1.addChild(channel);
        trans2.addChild(channel);
        sat1.addChild(trans1);
        sat2.addChild(trans2);
        inputroot.addChild(sat1);
        inputroot.addChild(sat2);
    }

    /**
     * Method to test aggregate ChannelsOverSatelittes
     */
    @Test
    public void ChannelsOverSatellitesTest(){
    	// build expected output tree
        Node expectedRoot = new Root();
        Node channel = new Channel("RTL", 100);
        Node sat1 = new Satellite("BulgariaSat-1", "1.9° E");
        Node sat2 = new Satellite("BulgariaSat-2", "1.9° N");
        channel.addChild(sat1);
        channel.addChild(sat2);
        expectedRoot.addChild(channel);

        // generate output tree by calling the tested method 
        Node actualRoot = inputroot.accept(new ChannelsOverSatellitesVisitor());
        // check if expected output tree equals actual output tree
        assertThat(actualRoot).usingRecursiveComparison().isEqualTo(expectedRoot);
    }

    /**
     * Method to test aggregate SatellitesOverTransponders
     */
    @Test
    public void SatellitesOverTranspondersTest(){
    	// build expected output tree
        Node expectedRoot = new Root();
        Node sat1 = new Satellite("BulgariaSat-1", "1.9° E");
        Node trans1 = new Transponder("H", "30000", "30");
        Node sat2 = new Satellite("BulgariaSat-2", "1.9° N");
        Node trans2 = new Transponder("V", "30000", "10");
        sat1.addChild(trans1);
        sat2.addChild(trans2);
        expectedRoot.addChild(sat1);
        expectedRoot.addChild(sat2);

        // generate output tree by calling the tested method 
        Node actualRoot = inputroot.accept(new SatellitesOverTranspondersVisitor());
        // check if expected output tree equals actual output tree
        assertThat(actualRoot).usingRecursiveComparison().isEqualTo(expectedRoot);
    }

}
