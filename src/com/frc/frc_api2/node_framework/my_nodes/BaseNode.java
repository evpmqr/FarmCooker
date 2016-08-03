package com.frc.frc_api2.node_framework.my_nodes;

public class BaseNode extends ParentNode {

    //Node to add all other nodes to, removes it's status.

    @Override
    public String getStatus() {
        return getChildStatus();
    }

    @Override
    public void initChildren() {

    }

    @Override
    public boolean validate() {
        return true;
    }
}
