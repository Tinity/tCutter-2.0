package Tinity.Nodes;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public enum TREE {
    DEFAULT(-1, -1), OAK(15, 1751), TREE(1, 1278);


    public static final List<Tinity.Nodes.TREE> LVL_SORTED;

    static {
        LVL_SORTED = Arrays.asList(values());
        LVL_SORTED.sort(Comparator.comparingInt(TREE -> -TREE.getLvlReq()));
    }

    private final int lvlReq, id;


    TREE(int lvlReq, int id) {
        this.lvlReq = lvlReq;
        this.id = id;
    }

    public static Tinity.Nodes.TREE getTreeForLvl(int currTree) {
        for (Tinity.Nodes.TREE id : LVL_SORTED) {
            if (currTree >= id.getLvlReq()) {
                return id;
            }

        }
        return DEFAULT;
    }

    public int getLvlReq() {
        return lvlReq;
    }

    public int getId() {
        return id;
    }
}
