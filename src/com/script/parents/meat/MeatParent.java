package com.script.parents.meat;

import com.frc.frc_api2.node_framework.my_nodes.ParentNode;
import com.script.nodes.BankItems;
import com.script.nodes.Cook;
import com.script.util.CookingTask;
import org.tbot.methods.Skills;

/**
 * Created by Eric Vue on 7/31/2016.
 */
public class MeatParent extends ParentNode {

    @Override
    public boolean conditions(){
        return Skills.getCurrentLevel(Skills.Skill.COOKING) >= CookingTask.MEAT.getMinLevel() && Skills.getCurrentLevel(Skills.Skill.COOKING) < CookingTask.MEAT.getMaxLevel();
    }
    @Override
    public void initChildren() {
        add(new Cook(CookingTask.MEAT), new BankItems(CookingTask.MEAT.getItems()));
    }
}
