package SatelliteManagement.aggregates;

import SatelliteManagement.visitor.iVisitor;

/**
 * Factory to produce the aggregate visitors.
 *
 * @author Lukas Benner
 * @version 1.0
 */
public class AggregateVisitorFactory {
    /**
     * Produces a visitor that can be used to aggregate a tree.
     *
     * @param aggregate The aggregate determines the visitor
     * @return A visitor
     * @exception RuntimeException if no matching aggregate is found
     */
    public static iVisitor produceVisitor(Aggregate aggregate){
        iVisitor visitor;
        switch (aggregate){
            case CHANNEL_SAT -> visitor = new ChannelsOverSatellitesVisitor();
            case SAT_TRANSPONDER -> visitor = new SatellitesOverTranspondersVisitor();
            default -> throw new RuntimeException("No aggregate specified");
        }
        return visitor;
    }
}
