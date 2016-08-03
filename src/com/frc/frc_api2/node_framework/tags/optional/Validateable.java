package com.frc.frc_api2.node_framework.tags.optional;


public interface Validateable {
    //Tags the outside_script as validateable, no other actions will happen to the outside_script if the return is not true.
    boolean validate();
}
