package com.script.parents.pizza;

import com.frc.frc_api2.node_framework.my_nodes.ParentNode;
import com.script.nodes.BankItems;
import com.script.nodes.Cook;
import com.script.util.CookingTask;
import org.tbot.methods.Skills;

public class PizzaParent extends ParentNode {
    @Override
    public boolean conditions(){
        return Skills.getCurrentLevel(Skills.Skill.COOKING) >= CookingTask.PIZZA.getMinLevel() && Skills.getCurrentLevel(Skills.Skill.COOKING) < CookingTask.PIZZA.getMaxLevel();
    }
    @Override
    public void initChildren() {
        add(new Cook(CookingTask.PIZZA), new BankItems(CookingTask.PIZZA.getItems()));
    }
}
