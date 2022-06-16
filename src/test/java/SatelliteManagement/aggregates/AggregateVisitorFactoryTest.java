package SatelliteManagement.aggregates;

import org.junit.jupiter.api.Test;
import SatelliteManagement.tree.*;
import SatelliteManagement.aggregates.*;
import SatelliteManagement.visitor.iVisitor;
import org.junit.jupiter.api.TestInstance;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

import java.util.ArrayList;

/**
 * Class to test AggregateVisitorFactory
 * @author Lea Soffel
 * @version 1.0
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AggregateVisitorFactoryTest {
    
/**
 * Testcases for method produceVisitor
 */
	
    /**
     * Testcase 1: channelSatAggregate = Aggregate.CHANNEL_SAT 
     */
    @Test
    public void testcase1_produceVisitor() {
    	// build inputAggregate
    	Aggregate inputAggregate = Aggregate.CHANNEL_SAT;
    	
    	// build expectedVisitor
    	iVisitor expectedVisitor = new ChannelsOverSatellitesVisitor();
    	
    	// create actualVisitor by calling tested method
    	iVisitor actualVisitor = AggregateVisitorFactory.produceVisitor(inputAggregate);
    	
    	// check if expected Visitor equals actual Visitor (both should be ChannelsOverSatellitesVisitor())
        assertThat(actualVisitor).usingRecursiveComparison().isEqualTo(expectedVisitor);
    }
    
    /**
     * Testcase 2: satTransponderAggregate = Aggregate.SAT_TRANSPONDER
     */
    @Test
    public void testcase2_produceVisitor() {
    	// build inputAggregate
    	Aggregate inputAggregate = Aggregate.SAT_TRANSPONDER;
    	
    	// build expectedVisitor
    	iVisitor expectedVisitor = new SatellitesOverTranspondersVisitor();
    	
    	// create actualVisitor by calling tested method
    	iVisitor actualVisitor = AggregateVisitorFactory.produceVisitor(inputAggregate);
    	
    	// check if expected Visitor equals actual Visitor (both should be SatellitesOverTranspondersVisitor())
        assertThat(actualVisitor).usingRecursiveComparison().isEqualTo(expectedVisitor);
    }

    
    /**
     * Testcase 3: nullAggregate = null
     */
    @Test
    public void testcase4_getSatellitesFromInputFormat() {

    	// build the inputAggregate
    	Aggregate inputAggregate = null;

        try{

        	AggregateVisitorFactory.produceVisitor(inputAggregate);
            fail("Did not throw an Exception");
        }
        catch (RuntimeException e){
        	// Test ok
        }
    }

}