package com.script.util;

import org.tbot.methods.Widgets;
import org.tbot.wrappers.WidgetChild;

public enum CookingTask {
    MEAT(Widgets.getWidget(307, 2), 1, 15, 2132),
    TROUT(Widgets.getWidget(307, 2), 15, 35, 335),
    WINE(Widgets.getWidget(309, 2), 35, 55, 1987, 1937),
    PIZZA(Widgets.getWidget(309, 2), 55, 99, 2289, 319);

    private WidgetChild cookWidget;
    private int minLevel, maxLevel;
    private int[] items;

    CookingTask(WidgetChild cookWidget, int minLevel, int maxLevel, int... items) {
        this.cookWidget = cookWidget;
        this.minLevel = minLevel;
        this.maxLevel = maxLevel;
        this.items = items;
    }

    public WidgetChild getCookWidget() {
        return cookWidget;
    }

    public void setCookWidget(WidgetChild cookWidget) {
        this.cookWidget = cookWidget;
    }

    public int getMinLevel() {
        return minLevel;
    }

    public void setMinLevel(int minLevel) {
        this.minLevel = minLevel;
    }

    public int getMaxLevel() {
        return maxLevel;
    }

    public void setMaxLevel(int maxLevel) {
        this.maxLevel = maxLevel;
    }

    public int[] getItems() {
        return items;
    }

    public void setItems(int[] items) {
        this.items = items;
    }

    public int getFirstItem() {
        return getItems()[0];
    }

    public int getSecondItem() {
        if (getItems().length > 1) {
            return getItems()[1];
        } else {
            return -1;
        }
    }
}
