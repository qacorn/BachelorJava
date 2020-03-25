package com.class2018092604;

public class IOSSystem implements ControllerFactory {



    @Override
    public InterfaceController createInterfaceController() {
        return new IOSInterfaceController();
    }

    @Override
    public OperationController createOperateController() {
        return new IOSOperateController();
    }

    @Override
    public TouchController createTouchController() {
        return null;
    }
}
