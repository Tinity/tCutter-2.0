package Tinity.Nodes;

import Tinity.MyFirstNodeScript;
import Tinity.Node;
import org.dreambot.api.methods.MethodProvider;
import org.dreambot.api.methods.container.impl.bank.BankLocation;



public class FullNode extends Node {
    public FullNode(MyFirstNodeScript main) {
        super(main);
    }

    @Override
    public boolean validate() {
        return c.getInventory().isFull();

    }

    @Override
    public int execute() {
        MethodProvider.log("banking...");
        if (c.getBank().isOpen()) {
            if (c.getInventory().contains(item -> item != null && item.getName().contains(" log")) || c.getInventory().contains(MyFirstNodeScript.LOG)) {

                c.getBank().depositAllExcept(item -> item != null && item.getName().contains(" axe"));
            }
        } else {
            c.getBank().open(BankLocation.VARROCK_WEST);
        }
        return 1000;
    }
}
