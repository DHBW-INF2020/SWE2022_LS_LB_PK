package tree;

import visitor.iVisitor;

public class Channel extends Node{

    int _sid;
    String _name;

    public int getSid() {
        return _sid;
    }

    public String getName() {
        return _name;
    }

    public Channel(String name, int sid){
        this._name = name;
        this._sid = sid;
    }

    @Override
    public Node accept(iVisitor visitor) {
        return visitor.visitChannel(this);
    }

    @Override
    public NodeType getType() {
        return NodeType.CHANNEL;
    }

}
