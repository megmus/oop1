package de.mome.javaprofis.oop.graphics;

import java.awt.*;

public class Figure {

    public void drawFigure(final Object obj) {
        draw(obj);
    }

    public void draw(Object obj) {
        System.out.println("\ndraw-object");
    }

    public void draw(final Point point) {
        System.out.println("\ndraw-point");
    }

    public void draw(final Rectangle rectangle) {
        System.out.println("\ndraw-rectangle");
    }

}
