package com.frc.frc_api2.node_framework.tags.optional;

public interface SelfRemoving {
    //Tags the outside_script as removeable, if the return is true the parent outside_script will remove the outside_script from the tree after execution.
    boolean shouldRemove();
}
