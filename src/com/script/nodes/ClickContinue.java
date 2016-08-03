package com.script.nodes;

import com.frc.frc_api2.node_framework.my_nodes.ChildNode;
import org.tbot.methods.Time;
import org.tbot.methods.Widgets;
import org.tbot.util.Condition;
import org.tbot.wrappers.WidgetChild;

/**
 * Created by Eric Vue on 7/31/2016.
 */
public class ClickContinue extends ChildNode {
    private WidgetChild[] continueWidgets = {
            Widgets.getWidget(162, 33),
            Widgets.getWidget(229, 1),
            Widgets.getWidget(231, 2),
            Widgets.getWidget(193, 2),
            Widgets.getWidget(11, 3),
            Widgets.getWidget(217, 2),
            Widgets.getWidget(162, 33),
            Widgets.getWidget(233, 2),
            Widgets.getWidget(193, 2)
    };

    @Override
    public void execute() {
        for (final WidgetChild widgetChild : continueWidgets) {
            if (widgetChild.isOnScreen()) {
                widgetChild.click();
                Time.sleepUntil(new Condition() {
                    @Override
                    public boolean check() {
                        return !widgetChild.isOnScreen();
                    }
                }, 500);
            }
        }
    }

    @Override
    public boolean validate() {
        for (WidgetChild widgetChild : continueWidgets) {
            if (widgetChild.isOnScreen()) {
                return true;
            }
        }
        return false;
    }
}
