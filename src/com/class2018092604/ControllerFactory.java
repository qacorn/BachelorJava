package com.class2018092604;

public interface ControllerFactory {

    InterfaceController createInterfaceController();

    OperationController createOperateController();

    TouchController createTouchController();

}
