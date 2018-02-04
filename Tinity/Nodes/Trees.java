package Tinity.Nodes;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public enum Trees {
    DEFAULT(-1, -1), OAK(15, 1751), TREE(1, 1278);


    private static final List<Trees> lvlSorted;

    static {
        lvlSorted = Arrays.asList(values());
        lvlSorted.sort(Comparator.comparingInt(trees -> -trees.getLvlReq()));
    }

    private final int lvlReq, ID;


    Trees(int lvlReq, int ID) {
        this.lvlReq = lvlReq;
        this.ID = ID;
    }

    public static Trees getTreeForLvl(int currTree) {
        for (Trees ID : lvlSorted) {
            if (currTree >= ID.getLvlReq()) {
                return ID;
            }

        }
        return DEFAULT;
    }

    public int getLvlReq() {
        return lvlReq;
    }

    public int getID() {
        return ID;
    }
}
