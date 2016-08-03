package com.frc.frc_api2.node_framework.tags.optional;

public interface PrePost {
    //Tags the outside_script as having a pre/post execution
    void onStart();
    void onFinish();
}
