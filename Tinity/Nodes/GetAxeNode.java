package Tinity.Nodes;

import Tinity.MyFirstNodeScript;
import Tinity.Node;
import org.dreambot.api.methods.container.impl.bank.BankLocation;

public class GetAxeNode extends Node {
    public GetAxeNode(MyFirstNodeScript main) {
        super(main);
    }

    @Override
    public boolean validate() {
        return !c.getInventory().contains(item -> item != null && item.getName().contains(" axe"));
    }

    @Override
    public int execute() {
        if (c.getBank().isOpen()) {
            c.getBank().withdraw(item -> item != null && item.getName().contains(" axe"));
        } else {
            c.getBank().open(BankLocation.VARROCK_WEST);
        }
        return 1000;
    }
}
