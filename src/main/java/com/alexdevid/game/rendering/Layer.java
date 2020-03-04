package com.alexdevid.game.rendering;

import com.alexdevid.game.Game;
import javafx.scene.canvas.Canvas;

abstract public class Layer
{
    Canvas canvas;

    Layer()
    {
        canvas = new Canvas(Game.SCREEN_WIDTH, Game.SCREEN_HEIGHT);
    }

    public Canvas getCanvas()
    {
        return this.canvas;
    }
}
