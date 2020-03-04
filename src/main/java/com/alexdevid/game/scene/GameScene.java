package com.alexdevid.game.scene;

import com.alexdevid.game.rendering.CanvasLayer;
import com.alexdevid.game.rendering.GUILayer;

import java.util.ArrayList;

abstract public class GameScene
{
    private ArrayList<CanvasLayer> layers = new ArrayList<>();
    private GUILayer guiLayer = new GUILayer();

    public ArrayList<CanvasLayer> getLayers()
    {
        return this.layers;
    }

    public GUILayer getGuiLayer()
    {
        return this.guiLayer;
    }

    protected void addLayer(CanvasLayer layer)
    {
        this.layers.add(layer);
    }

    public void start()
    {

    }

    public void update(long timestamp)
    {

    }
}
