package Tinity.Nodes;

import Tinity.MyFirstNodeScript;
import Tinity.Node;
import org.dreambot.api.Client;

public class ChoppingNode extends Node {
    public ChoppingNode(MyFirstNodeScript main) {
        super(main);
    }

    @Override
    public boolean validate() {
        if (c.getLocalPlayer().isAnimating()) { // isAnimating(woodcutting animation)
            Client.setForcedFPS(5);
            return true;
        } else {
            Client.setForcedFPS(20);
            return false;
        }
    }

    @Override
    public int execute() {
        return 1000;
    }
}
