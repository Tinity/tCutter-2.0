package Tinity;

import Tinity.Nodes.*;
import org.dreambot.api.methods.map.Area;
import org.dreambot.api.script.AbstractScript;
import org.dreambot.api.script.Category;
import org.dreambot.api.script.ScriptManifest;


@ScriptManifest(category = Category.WOODCUTTING , name ="tCutter 2.0" , author ="Tinity" , version =2.0 )
public class MyFirstNodeScript extends AbstractScript {
    public Node[] nodes;
    public static final Area TREE_AREA = new Area(3132, 3451, 3119, 3428);
    public static final int LOG = 1511;
    public static final int TREE = 1278;
    public static final int OAK = 1751;
    public boolean geActive;

    @Override
    public void onStart() {
        nodes = new Node[]{
                new GENode(this),
                new ChoppingNode(this),
                new CutNode(this),
                new FullNode(this),
                new WalkNode(this),
                new GetAxeNode(this),

        };
    }

    @Override
    public int onLoop() {
        for (Node node : nodes) {
            if (node.validate()) {
                return node.execute();
            }
        }
        log("No node valid");
        return 1000;
    }

    public boolean isGeActive() {
        return geActive;
    }

    public void setGeActive(boolean geActive) {
        this.geActive = geActive;
    }
}
