package com.script.area;

import org.tbot.methods.web.Web;
import org.tbot.methods.web.areas.WebArea;
import org.tbot.methods.web.nodes.WebNode;
import org.tbot.wrappers.Tile;

public class HouseArea extends WebArea {
    @Override
    public void addTo(Web web) {
        WebNode node0 = web.getNearestWebNode(new Tile(3279, 3180));
        WebNode node1 = web.getNode(new Tile(3277,3180));
        WebNode node2 = web.getNode(new Tile(3272,3180));
        web.addWalkConnection(node0, node1);
        web.addWalkConnection(node1,node2);
    }
}
