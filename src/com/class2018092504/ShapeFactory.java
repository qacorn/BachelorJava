package com.class2018092504;

import java.util.HashMap;
import java.util.Map;

public class ShapeFactory {

    private Map<String, IShape> iShapeMap = new HashMap<>();


    public static IShape buildShape(String type) throws UnSupportedShapeException {
        if (type.equals("Circle")) {
            return new Circle();
        } else if (type.equals("Rectangle")) {
            return new Rectangle();
        } else if (type.equals("Triangle")) {
            return new Triangle();
        } else {
            throw new UnSupportedShapeException();
        }

    }

    public  IShape buildShapeWithReflection(String type) throws Exception {
        try {
            if (iShapeMap.containsKey(type)) {
                return iShapeMap.get(type);
            }else {
                Class<?> clazz = Class.forName(type);
                IShape iShape = (IShape) clazz.getConstructor().newInstance();
                iShapeMap.put(type, iShape);
                return iShape;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception();
        }

    }
}
