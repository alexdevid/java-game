package com.alexdevid.game.geometry;

public class Rectangle extends Shape
{
    public double x;
    public double y;
    public double width;
    public double height;

    public Rectangle(double x, double y, double width, double height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public boolean isTarget(double x, double y)
    {
        return x >= this.x && x <= this.x + this.width && y >= this.y && y <= this.y + this.height;
    }
}
