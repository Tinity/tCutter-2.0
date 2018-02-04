package Tinity.Nodes;

import Tinity.MyFirstNodeScript;
import Tinity.Node;
import org.dreambot.api.methods.MethodProvider;
import org.dreambot.api.methods.skills.Skill;

import static org.dreambot.api.methods.MethodProvider.sleepUntil;

public class CutNode extends Node {
    public CutNode(MyFirstNodeScript main) {
        super(main);
    }

    @Override
    public boolean validate() {
        return true;
    }

    @Override
    public int execute() {
        // c.getGameObjects().closest(MyFirstNodeScript.TREE).interact("Chop down");

        Trees currTree = Trees.getTreeForLvl(c.getSkills().getRealLevel(Skill.WOODCUTTING));
        MethodProvider.log("ID " + currTree.getID() + " LVL " + currTree.getLvlReq());
        if (c.getGameObjects().closest(currTree.getID()).interact("Chop down") && MethodProvider.sleepUntil(() -> c.getLocalPlayer().isMoving(), 1000)) {
            sleepUntil(() -> c.getLocalPlayer().getAnimation() == 879, 5000);
        }


        return 1000;
    }
}
