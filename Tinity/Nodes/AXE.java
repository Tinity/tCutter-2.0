package Tinity.Nodes;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public enum AXE {
    Bronze(1, 1351,"Bronze axe"), Black(11, 1361,"Black axe"), Mithril(21, 1355,"Mithril axe"), Adamant(31, 1357,"Adamant axe");


    public static final List<Tinity.Nodes.AXE> LVL_SORTED;

    static {
        LVL_SORTED = Arrays.asList(values());
        LVL_SORTED.sort(Comparator.comparingInt(AXE -> -AXE.getLvlReq()));
    }

    private final int lvlReq, id;
    private final String AxeName;


    AXE(int lvlReq, int id, String AxeName) {
        this.lvlReq = lvlReq;
        this.id = id;
        this.AxeName = AxeName;
    }

    public static Tinity.Nodes.AXE getAxeForLvl(int currAxe) {
        for (Tinity.Nodes.AXE id : LVL_SORTED) {
            if (currAxe >= id.getLvlReq()) {
                return id;

            }

        }
        return Bronze;
    }

    public int getLvlReq() {
        return lvlReq;
    }

    public int getId() {
        return id;
    }

    public String getAxeName(){
        return AxeName;
    }
}
