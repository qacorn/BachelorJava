package com.class2018092604;

public class AndroidSystem implements ControllerFactory {
    @Override
    public InterfaceController createInterfaceController() {
        return new AndroidInterfaceController();
    }

    @Override
    public OperationController createOperateController() {
        return new AndroidOperateController();
    }

    @Override
    public TouchController createTouchController() {
        return new AndroidTouchController();
    }

}
