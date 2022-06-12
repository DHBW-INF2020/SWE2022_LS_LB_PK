package SatelliteManagement.output;

public class OutputVisitorFactory {
    public static iOutput_Visitor produceVisitor(Format format){
        iOutput_Visitor visitor = null;
        switch (format){
            case XML -> visitor = new XmlOutput_Visitor();
            case JSON -> visitor = new JsonOutput_Visitor();
            default -> throw new RuntimeException("No Format specified");
        }
        return visitor;
    }
}
