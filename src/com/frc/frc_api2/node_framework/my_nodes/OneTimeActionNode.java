package com.frc.frc_api2.node_framework.my_nodes;

import com.frc.frc_api2.node_framework.tags.optional.*;
import com.frc.frc_api2.node_framework.tags.required.Node;

public abstract class OneTimeActionNode implements Node, Validateable, Executeable, PrePost, SelfRemoving, HasStatus {

    //Node that will only be execute one time then it will remove itself from the outside_script tree. Good for initing stuff only when logged in.
    @Override
    public void onStart() {

    }

    @Override
    public void onFinish() {

    }

    @Override
    public boolean shouldRemove() {
        return true;
    }
}
