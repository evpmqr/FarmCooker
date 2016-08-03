package com.script.nodes;

import com.frc.frc_api2.node_framework.my_nodes.ChildNode;
import org.tbot.methods.Random;
import org.tbot.methods.Time;
import org.tbot.methods.walking.Walking;
import org.tbot.util.Condition;

/**
 * Created by Eric Vue on 7/31/2016.
 */
public class HandleRun extends ChildNode {
    private int runTrigger = Random.nextInt(60,70);
    @Override
    public void execute() {
        Walking.setRun(true);
        Time.sleepUntil(new Condition() {
            @Override
            public boolean check() {
                return Walking.isRunEnabled();
            }
        }, 500);
        runTrigger = Random.nextInt(60,70);
    }

    @Override
    public boolean validate() {
        return !Walking.isRunEnabled() && Walking.getRunEnergy() >= runTrigger;
    }
}
