package com.frc.frc_api2.node_framework.my_nodes;


import com.frc.frc_api2.node_framework.tags.optional.*;
import com.frc.frc_api2.node_framework.tags.required.Node;

public abstract class ChildNode implements Node, Blocking, Executeable, Validateable, HasStatus, PrePost {

    private int nodeID = -1;

    @Override
    public String getStatus() {
        return String.valueOf(nodeID);
    }

    public void setNodeID(int nodeID) {
        this.nodeID = nodeID;
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onFinish() {

    }
}
