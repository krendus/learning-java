package com.example;

interface Shape {
    void draw();
}
interface DrawingAPI {
    void drawCircle(int x, int y, int radius);
}
class DrawingAPI1 implements DrawingAPI {
    public void drawCircle(int x, int y, int radius) {
        System.out.println("Drawing circle with API 1");
    }
}
class DrawingAPI2 implements DrawingAPI {
    public void drawCircle(int x, int y, int radius) {
        System.out.println("Drawing circle with API 2");
    }
}
class Circle implements Shape {
    private final int x,y,radius;
    private final DrawingAPI drawingAPI;

    public Circle(int x, int y, int radius, DrawingAPI drawingAPI) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.drawingAPI = drawingAPI;
    }
    public void draw() {
        drawingAPI.drawCircle(x, y, radius);
    }
}
public class BridgeExample {
    public static void main(String[] args) {
        Circle circle1 = new Circle(1,1,3, new DrawingAPI1());
        circle1.draw();
        Circle circle2 = new Circle(1,1,3, new DrawingAPI2());
        circle2.draw();
    }
}
