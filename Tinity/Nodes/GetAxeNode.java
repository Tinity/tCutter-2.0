package Tinity.Nodes;

import Tinity.MyFirstNodeScript;
import Tinity.Node;
import org.dreambot.api.methods.MethodProvider;
import org.dreambot.api.methods.container.impl.bank.BankLocation;
import org.dreambot.api.methods.skills.Skill;

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


        AXE currAxe = AXE.getAxeForLvl(c.getSkills().getRealLevel(Skill.WOODCUTTING));
        MethodProvider.log("ID " + currAxe.getId() + " LVL " + currAxe.getLvlReq());

        MethodProvider.log("Taking out " + currAxe.getId());
        if (c.getBank().isOpen()) {
            if (c.getBank().contains(currAxe.getId())) {
                c.getBank().withdraw(currAxe.getId());
            } else {
                c.setGeActive(true);
            }
        } else {
            c.getBank().open(BankLocation.VARROCK_WEST);
        }
        return 1000;
    }
}
