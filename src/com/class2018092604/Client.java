package com.class2018092604;

public class Client {

    public static void main(String[] args) {
        ControllerFactory iosController = new IOSSystem();
        InterfaceController interfaceController = iosController.createInterfaceController();
        interfaceController.playGameViaInterface();
        OperationController iosControllerOperateController = iosController.createOperateController();
        iosControllerOperateController.playGameViaOperate();


        ControllerFactory androidController = new AndroidSystem();
        OperationController operateController = androidController.createOperateController();
        operateController.playGameViaOperate();
        InterfaceController androidInterfaceController = androidController.createInterfaceController();
        androidInterfaceController.playGameViaInterface();

    }
}
