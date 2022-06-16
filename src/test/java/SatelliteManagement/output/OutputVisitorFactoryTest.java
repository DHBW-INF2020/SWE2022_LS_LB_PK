package SatelliteManagement.output;

import org.junit.jupiter.api.Test;
import SatelliteManagement.tree.*;
import SatelliteManagement.output.*;
import org.junit.jupiter.api.TestInstance;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

import java.util.ArrayList;

/**
 * Class to test OutputVisitorFactory
 * @author Lea Soffel
 * @version 1.0
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class OutputVisitorFactoryTest {
    
/**
 * Testcases for method produceVisitor
 */
	
    /**
     * Testcase 1: xmlFormat = Format.XML (inputFormat)
     */
    @Test
    public void testcase1_produceVisitor() {
    	// build inputFormat
    	Format inputFormat = Format.XML;
    	
    	// build expectedVisitor
    	iOutputVisitor expectedVisitor = new XmlOutputVisitor();
    	
    	// create actualVisitor by calling tested method
    	iOutputVisitor actualVisitor = OutputVisitorFactory.produceVisitor(inputFormat);
    	
    	// check if expected Visitor equals actual Visitor (both should be XmlOutputVisitor())
        assertThat(actualVisitor).usingRecursiveComparison().isEqualTo(expectedVisitor);
    }
    
    /**
     * Testcase 2: jsonFormat = Format.JSON (inputFormat)
     */
    @Test
    public void testcase2_produceVisitor() {
    	// build inputFormat
    	Format inputFormat = Format.JSON;
    	
    	// build expectedVisitor
    	iOutputVisitor expectedVisitor = new JsonOutputVisitor();
    	
    	// create actualVisitor by calling tested method
    	iOutputVisitor actualVisitor = OutputVisitorFactory.produceVisitor(inputFormat);
    	
    	// check if expected Visitor equals actual Visitor (both should be JsonOutputVisitor())
        assertThat(actualVisitor).usingRecursiveComparison().isEqualTo(expectedVisitor);
    }

    
    /**
     * Testcase 3: nullFormat = null (inputFormat)
     */
    @Test
    public void testcase3_produceVisitor() {

    	// build the inputFormat
    	Format inputFormat = null;

        try{
        	
        	OutputVisitorFactory.produceVisitor(inputFormat);
            fail("Did not throw an Exception");
        }
        catch (RuntimeException e){
        	// Test ok
        }
    }

}