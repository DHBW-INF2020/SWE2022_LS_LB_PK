package SatelliteManagement.input;

import SatelliteManagement.tree.Node;

public interface iFormatParser {


    /**
     * Creates a tree of Nodes from the input file
     *
     * @param fileName Path to the input file
     * @return Root Node of the input tree
     */
    public Node parseInputFile(String fileName);
}
