package aggregates;

import visitor.iVisitor;

public class AggregateVisitorFactory {
    public static iVisitor produceAggregateVisitor(Aggregate aggregate){
        iVisitor visitor = null;
        switch (aggregate){
            case CHANNEL_SAT -> visitor = new ChannelsOverSatellites_Visitor();
            case SAT_TRANSPONDER -> visitor = new SatellitesOverTransponders_Visitor();
            default -> throw new RuntimeException("No aggregate specified");
        }
        return visitor;
    }
}
