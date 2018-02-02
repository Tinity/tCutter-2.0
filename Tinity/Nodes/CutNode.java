package Tinity.Nodes;

import Tinity.MyFirstNodeScript;
import Tinity.Node;

public class CutNode extends Node {
    public CutNode(MyFirstNodeScript main) {
        super(main);
    }

    @Override
    public boolean validate() {
        return MyFirstNodeScript.TREE_AREA.contains(c.getLocalPlayer()) && !c.getLocalPlayer().isAnimating() && !c.getLocalPlayer().isMoving() && c.getInventory().contains(item -> item != null && item.getName().contains(" axe"));
    }

    @Override
    public int execute() {
        c.getGameObjects().closest(MyFirstNodeScript.TREE).interact("Chop down");
        return 1000;
    }
}
