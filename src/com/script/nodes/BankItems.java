package com.script.nodes;

import com.frc.frc_api2.node_framework.my_nodes.ChildNode;
import org.tbot.methods.Bank;
import org.tbot.methods.Time;
import org.tbot.methods.tabs.Inventory;
import org.tbot.methods.web.banks.WebBanks;
import org.tbot.util.Condition;

/**
 * Created by Eric Vue on 7/31/2016.
 */
public class BankItems extends ChildNode {
    private int[] items;

    public BankItems(int... items) {
        this.items = items;
    }

    @Override
    public void execute() {
        if (Bank.isOpen()) {
            if (isOneItem()) {
                if (Inventory.getCountExcept(items) > 0) {
                    Bank.depositAll();
                    Time.sleepUntil(new Condition() {
                        @Override
                        public boolean check() {
                            return Inventory.isEmpty();
                        }
                    }, 100);
                }
            } else {
                if (Inventory.getCountExcept(items) > 0 || Inventory.getCount(items[0]) > 14 || Inventory.getCountExcept(items[1]) > 14) {
                    Bank.depositAll();
                    Time.sleepUntil(new Condition() {
                        @Override
                        public boolean check() {
                            return Inventory.isEmpty();
                        }
                    }, 100);
                }
            }
            handleWithdraws();
        } else {
            Bank.openBank(WebBanks.AL_KHARID_BANK);
            Time.sleepUntil(new Condition() {
                @Override
                public boolean check() {
                    return Bank.isOpen();
                }
            }, 500);
        }

    }

    public void handleWithdraws() {
        for (final int i : items) {
            if (!Inventory.contains(i) && Bank.contains(i)) {
                if (isOneItem()) {
                    Bank.withdrawAll(i);
                } else {
                    Bank.withdraw(i, 14);
                }
                Time.sleepUntil(new Condition() {
                    @Override
                    public boolean check() {
                        return Inventory.contains(i);
                    }
                }, 1000);
            }
        }
    }

    private boolean isOneItem() {
        return items.length < 2;
    }

    @Override
    public boolean validate() {
        return true;
    }
}
