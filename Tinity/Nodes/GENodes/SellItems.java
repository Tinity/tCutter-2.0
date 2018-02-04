package Tinity.Nodes.GENodes;

import Tinity.MyFirstNodeScript;
import Tinity.Node;

public class SellItems extends Node {
    public SellItems(MyFirstNodeScript main) {
        super(main);
    }

    @Override
    public boolean validate() {
        return true;
    }

    @Override
    public int execute() {
        int logAmount = c.getInventory().count(MyFirstNodeScript.LOG);
        c.getGrandExchange().sellItem("Logs", logAmount, 1);
        return 1000;
    }
}
