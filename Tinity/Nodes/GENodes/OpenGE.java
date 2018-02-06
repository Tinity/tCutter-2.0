package Tinity.Nodes.GENodes;

import Tinity.MyFirstNodeScript;
import Tinity.Node;

import static Tinity.MyFirstNodeScript.GE_AREA;

public class OpenGE extends Node {
    public OpenGE(MyFirstNodeScript main) {
        super(main);
    }

    @Override
    public boolean validate() {
        return c.getInventory().contains(item -> item != null && item.getName().contains(" log"));

    }


    @Override
    public int execute() {
        if (GE_AREA.contains(c.getLocalPlayer())) {
            c.getGrandExchange().open();
        } else {
            c.getWalking().walk(GE_AREA.getRandomTile());
        }
        return 1000;
    }
}
