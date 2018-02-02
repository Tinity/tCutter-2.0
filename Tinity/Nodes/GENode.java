package Tinity.Nodes;

import Tinity.MyFirstNodeScript;
import Tinity.Node;
import Tinity.Nodes.GENodes.*;


public class GENode extends Node {
    private final Node[] nodes;
    public GENode(MyFirstNodeScript main) {
        super(main);
        nodes = new Node[]{
                new CheckBank(c),
                new OpenGE(c),
                new SellItems(c),
        };
    }

    @Override
    public boolean validate() {
        return c.isGeActive();
    }

    @Override
    public int execute() {
       for(Node node : nodes){
           if(node.validate()){
               return node.execute();
           }
       }
        c.setGeActive(false);
       return 1000;
    }
}
