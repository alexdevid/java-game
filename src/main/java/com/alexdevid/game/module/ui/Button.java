package com.alexdevid.game.module.ui;

import com.alexdevid.game.Game;
import com.alexdevid.game.geometry.Rectangle;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class Button extends UIElement
{
    private Text text;

    public Button(double x, double y, double width, double height)
    {
        this.shape = new Rectangle(x, y, width, height);
    }

    public void setText(String text)
    {
        this.text = new Text(text);
        this.text.applyCss();
    }

    @Override
    public void draw()
    {
        GraphicsContext gc = Game.app().getSceneManager().getActiveScene().getGuiLayer().getCanvas().getGraphicsContext2D();

        this.getGraphicsContext().setFill(Color.PAPAYAWHIP);
        this.getGraphicsContext().fillRect(shape.x, shape.y, shape.width, shape.height);

        this.getGraphicsContext().setFill(Color.BLACK);
        final double centerX = this.text.getLayoutBounds().getCenterX();
        final double centerY = this.text.getLayoutBounds().getCenterY();
        this.getGraphicsContext().fillText(this.text.getText(), shape.x + shape.width / 2 - centerX, shape.y + shape.height / 2 - centerY);
    }
}
