package com.script.parents.wine;

import com.frc.frc_api2.node_framework.my_nodes.ParentNode;
import com.script.nodes.BankItems;
import com.script.nodes.Cook;
import com.script.util.CookingTask;
import org.tbot.methods.Skills;

/**
 * Created by Eric Vue on 7/31/2016.
 */
public class WineParent extends ParentNode {
    @Override
    public boolean conditions() {
        return Skills.getCurrentLevel(Skills.Skill.COOKING) >= CookingTask.WINE.getMinLevel() && Skills.getCurrentLevel(Skills.Skill.COOKING) < CookingTask.WINE.getMaxLevel();
    }

    @Override
    public void initChildren() {
        add(new Cook(CookingTask.WINE), new BankItems(CookingTask.WINE.getItems()));
    }
}
