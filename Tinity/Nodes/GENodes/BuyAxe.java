package Tinity.Nodes.GENodes;

import Tinity.MyFirstNodeScript;
import Tinity.Node;
import Tinity.Nodes.AXE;
import org.dreambot.api.methods.skills.Skill;

public class BuyAxe extends Node {

    public BuyAxe(MyFirstNodeScript main) {
        super(main);
    }

    @Override
    public boolean validate() {
        return c.getInventory().contains("Coins") && c.getInventory().count("Coins") >= 1000;
    }

    @Override
    public int execute() {
        AXE currAxe = AXE.getAxeForLvl(c.getSkills().getRealLevel(Skill.WOODCUTTING));

        if (c.getInventory().contains("Coins") && c.getInventory().count("Coins") >= 1000) {
            c.getGrandExchange().buyItem(currAxe.getAxeName(), 1, 1000);
        }
        return 1000;
    }
}
