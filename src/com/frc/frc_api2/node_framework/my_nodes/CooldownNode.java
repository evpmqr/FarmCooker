package com.frc.frc_api2.node_framework.my_nodes;

import com.frc.frc_api2.game.util.code.FrcTimer;

public abstract class CooldownNode extends ChildNode {

    private FrcTimer timeout = new FrcTimer();

    public CooldownNode(int timeout) {
        this.timeout.setDuration(timeout);
    }

    public void restartTimeout(){
        timeout.restart();
    }

    public boolean isTimeoutFinished(){
        return timeout.isFinished();
    }
}
