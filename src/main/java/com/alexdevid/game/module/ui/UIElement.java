package com.alexdevid.game.module.ui;

import com.alexdevid.game.Game;
import com.alexdevid.game.geometry.Rectangle;
import javafx.event.Event;
import javafx.event.EventType;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.util.function.Consumer;

abstract public class UIElement
{
    Rectangle shape;
    Color backgroundColor;

    abstract public void draw();

    public void setBackgroundColor(Color color)
    {
        this.backgroundColor = color;
    }

    GraphicsContext getGraphicsContext()
    {
        return Game.app().getSceneManager().getActiveScene().getGuiLayer().getCanvas().getGraphicsContext2D();
    }

    public void onMouseClicked(Consumer<MouseEvent> callback)
    {
        Canvas canvas = Game.app().getSceneManager().getActiveScene().getGuiLayer().getCanvas();
        canvas.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            if (this.shape.isTarget(event.getX(), event.getY())) {
                callback.accept(event);
            }
        });
    }
}
