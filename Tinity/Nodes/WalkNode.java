package Tinity.Nodes;

import Tinity.MyFirstNodeScript;
import Tinity.Node;

public class WalkNode extends Node {
    public WalkNode(MyFirstNodeScript main) {
        super(main);
    }

    @Override
    public boolean validate() {
        return !MyFirstNodeScript.TREE_AREA.contains(c.getLocalPlayer()) && !c.getInventory().isFull() && c.getInventory().contains(item -> item != null && item.getName().contains(" axe"));
    }

    @Override
    public int execute() {
        c.getWalking().walk(MyFirstNodeScript.TREE_AREA.getRandomTile());
        return 1000;
    }
}
