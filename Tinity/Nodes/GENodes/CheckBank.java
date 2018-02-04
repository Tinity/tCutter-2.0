package Tinity.Nodes.GENodes;

import Tinity.MyFirstNodeScript;
import Tinity.Node;
import org.dreambot.api.methods.container.impl.bank.BankMode;

public class CheckBank extends Node {
    public CheckBank(MyFirstNodeScript main) {
        super(main);
    }

    @Override
    public boolean validate() {
        return c.getBank().isOpen();
    }

    @Override
    public int execute() {
        if (c.getBank().getWithdrawMode() == BankMode.NOTE) {
            /*
            if (c.getBank().contains(item -> item != null && item.getName().contains(" log"))) {
                c.getBank().withdrawAll(item -> item != null && item.getName().contains(" log"));
                */
            if (c.getBank().contains(MyFirstNodeScript.LOG)) {
                c.getBank().withdrawAll(MyFirstNodeScript.LOG);
            }
        } else {
            c.getBank().setWithdrawMode(BankMode.NOTE);
        }


        return 1000;
    }
}
