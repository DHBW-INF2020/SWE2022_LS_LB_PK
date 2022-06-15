package SatelliteManagement.tree;

import SatelliteManagement.visitor.iVisitor;

/**
 * Class to represent a Channel in tree
 * @author Lea Soffel
 * @version 1.0
 */
public class Channel extends Node{

    int _sid;
    String _name;

    /**
     * Getter for sid
     * @return sid of Channel
     */
    public int getSid() {
        return _sid;
    }

    /**
     * Getter for name
     * @return name of Channel
     */
    public String getName() {
        return _name;
    }

    /**
     * Constructor for Channel
     */
    public Channel(String name, int sid){
        this._name = name;
        this._sid = sid;
    }

    @Override
    public Node accept(iVisitor visitor) {
        return visitor.visitChannel(this);
    }

    @Override
    public String getCollectionName() {
        return "channels";
    }

}
