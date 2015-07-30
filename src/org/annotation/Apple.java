package org.annotation;

import org.annotation.annotation.FruitColor;
import org.annotation.annotation.FruitName;
import org.annotation.annotation.FruitColor.Color;

public class Apple {

    @FruitName("Apple")
    private String appleName;

    @FruitColor(fruitColor = Color.RED)
    private String appleColor;

    public void setAppleColor(String appleColor) {
        this.appleColor = appleColor;
    }

    public String getAppleColor() {
        return appleColor;
    }

    public void setAppleName(String appleName) {
        this.appleName = appleName;
    }

    public String getAppleName() {
        return appleName;
    }

    public void displayName() {
        System.out.println("ˮ���������ǣ�ƻ��");
    }
}
