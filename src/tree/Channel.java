package tree;

import visitors.Visitor;

public class Channel extends Node{

    int _sid;
    String _type;
    String _name;
    String _v_pid;
    String _a_pid;
    String _compression;
    String _url;
    String _enc;
    String _package;
    String _res;

    public int getSid() {
        return _sid;
    }

    public String getName() {
        return _name;
    }


    @Override
    public Node accept(Visitor<Node> visitor) {
        return null;
    }
}
