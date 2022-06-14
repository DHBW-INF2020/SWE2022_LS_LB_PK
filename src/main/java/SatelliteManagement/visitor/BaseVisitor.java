package SatelliteManagement.visitor;

import SatelliteManagement.tree.*;

/**
 * Class represents a base visitor 
 * @author Lukas Benner
 * @version 1.0
 * 
 */
public class BaseVisitor implements iVisitor {
    @Override
    public Node visitChannel(Channel ctx) {
        return null;
    }

    @Override
    public Node visitSatellite(Satellite ctx) {
        return null;
    }

    @Override
    public Node visitTransponder(Transponder ctx) {
        return null;
    }

    @Override
    public Node visitRoot(Root ctx) {
        return null;
    }
}
