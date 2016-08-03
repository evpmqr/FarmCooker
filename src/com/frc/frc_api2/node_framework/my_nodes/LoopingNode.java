package com.frc.frc_api2.node_framework.my_nodes;

import org.tbot.methods.Time;

public abstract class LoopingNode extends ChildNode {

    @Override
    public void execute() {
        while (FrcScript.isScriptRunning()){
            if (FrcScript.isScriptPaused()){
                Time.sleep(1000);
                continue;
            }

            int result = loop();

            if (result == -1){
                break;
            }

            Time.sleep(result);
        }
    }

    public abstract int loop();
}
