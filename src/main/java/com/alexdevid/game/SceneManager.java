package com.alexdevid.game;

import com.alexdevid.game.rendering.Layer;
import com.alexdevid.game.scene.GameScene;

public class SceneManager
{
    private GameScene activeScene;

    public GameScene getActiveScene()
    {
        return activeScene;
    }

    public void loadScene(GameScene scene)
    {
        Game.app().getRoot().getChildren().clear();

        this.activeScene = scene;

        for (Layer layer : this.activeScene.getLayers()) {
            Game.app().getRoot().getChildren().add(layer.getCanvas());
        }

        Game.app().getRoot().getChildren().add(this.activeScene.getGuiLayer().getCanvas());

        this.activeScene.start();
    }
}
