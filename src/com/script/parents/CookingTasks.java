package com.script.parents;

import com.frc.frc_api2.node_framework.my_nodes.ParentNode;
import com.script.parents.meat.MeatParent;
import com.script.parents.pizza.PizzaParent;
import com.script.parents.trout.TroutParent;
import com.script.parents.wine.WineParent;

/**
 * Created by Eric Vue on 7/31/2016.
 */
public class CookingTasks extends ParentNode {
    @Override
    public void initChildren() {
        add(new MeatParent(), new TroutParent(), new WineParent(), new PizzaParent());
    }
}
