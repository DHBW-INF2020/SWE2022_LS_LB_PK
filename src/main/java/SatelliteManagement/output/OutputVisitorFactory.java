package SatelliteManagement.output;

/**
 * Factory to produce the output visitors.
 *
 * @author Lukas Benner
 * @version 1.0
 */
public class OutputVisitorFactory {

    /**
     * Produces a visitor to output data
     *
     * @param format The format determines the visitor
     * @return A visitor
     * @exception RuntimeException if no matching format is found
     */
    public static iOutputVisitor produceVisitor(Format format){
        iOutputVisitor visitor = null;
        switch (format){
            case XML -> visitor = new XmlOutputVisitor();
            case JSON -> visitor = new JsonOutputVisitor();
            default -> throw new RuntimeException("No Format specified");
        }
        return visitor;
    }
}
