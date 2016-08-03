package com.script.nodes;

import com.frc.frc_api2.game.util.code.FrcTimer;
import com.frc.frc_api2.game.wrappers.qurie_wrapper.FGameObjects;
import com.frc.frc_api2.game.wrappers.qurie_wrapper.FInventory;
import com.frc.frc_api2.node_framework.my_nodes.ChildNode;
import com.script.util.CookingTask;
import org.tbot.bot.TBot;
import org.tbot.internal.event.events.InventoryEvent;
import org.tbot.internal.event.listeners.IgnoreListeners;
import org.tbot.internal.event.listeners.InventoryListener;
import org.tbot.methods.Bank;
import org.tbot.methods.Time;
import org.tbot.methods.tabs.Inventory;
import org.tbot.util.Condition;
import org.tbot.wrappers.Tile;

/**
 * Created by Eric Vue on 7/31/2016.
 */
@IgnoreListeners
public class Cook extends ChildNode implements InventoryListener {


    private CookingTask cookingTask;
    private FrcTimer timer = new FrcTimer(4000);

    public Cook(CookingTask cookingTask) {
        this.cookingTask = cookingTask;
        TBot.getBot().getScriptHandler().getEventManager().addListener(this);
    }

    @Override
    public void execute() {
        if (cookingTask.getItems().length > 1) {
            interactItems();
        } else {
            cookStove();
        }
    }

    private void interactItems() {
        if (cookingTask.getCookWidget().isOnScreen()) {
            cookingTask.getCookWidget().interact("Make All");
            Time.sleepUntil(new Condition() {
                @Override
                public boolean check() {
                    return !cookingTask.getCookWidget().isOnScreen();
                }
            }, 500);
            timer.restart();
        } else if (timer.isFinished()) {
            FInventory.get(cookingTask.getFirstItem()).useOn(FInventory.get(cookingTask.getSecondItem()));
            Time.sleepUntil(new Condition() {
                @Override
                public boolean check() {
                    return cookingTask.getCookWidget().isOnScreen();
                }
            }, 500);
        }
    }

    private void cookStove() {
        if (cookingTask.getCookWidget().isOnScreen()) {
            cookingTask.getCookWidget().interact("Cook All");
            Time.sleepUntil(new Condition() {
                @Override
                public boolean check() {
                    return !cookingTask.getCookWidget().isOnScreen();
                }
            }, 500);
            timer.restart();
        } else if (timer.isFinished()) {
            FInventory.get(cookingTask.getFirstItem()).fromLocation(new Tile(3272, 3180)).useOn(FGameObjects.getNearest("Range"));
            Time.sleepUntil(new Condition() {
                @Override
                public boolean check() {
                    return cookingTask.getCookWidget().isOnScreen();
                }
            }, 1000);
        }
    }

    @Override
    public boolean validate() {
        if (cookingTask.getMaxLevel() >= 55) {
            makeValidate();
        }
        return cookValidate();

    }

    @Override
    public void itemsAdded(InventoryEvent inventoryEvent) {
        if (!Bank.isOpen()) {
            timer.restart();
        }
    }

    private boolean makeValidate() {
        return Inventory.containsAll(cookingTask.getItems()) && Inventory.getCount(cookingTask.getFirstItem()) <= 14 && Inventory.getCount(cookingTask.getSecondItem()) <= 14;
    }

    private boolean cookValidate() {
        return Inventory.containsAll(cookingTask.getItems());
    }

    @Override
    public void itemsRemoved(InventoryEvent inventoryEvent) {

    }
}

