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
        int logAmount = c.getInventory().count(item -> item != null && item.getName().contains(" log"));
        if (c.getGrandExchange().sellItem("Logs", logAmount, 1)) {
            c.getGrandExchange().collect();
        }
        return 1000;
    }
}
