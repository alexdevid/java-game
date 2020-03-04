package com.alexdevid.game;

import javafx.scene.Group;

public class Game
{
    static final String NAME = "GAME EXAMPLE";
    public static final int SCREEN_WIDTH = 600;
    public static final int SCREEN_HEIGHT = 800;

    public static boolean SHOW_FPS = true;

    private final SceneManager sceneManager;

    private final Group root = new Group();

    private static Game instance = null;

    Group getRoot()
    {
        return this.root;
    }

    void update(long timestamp)
    {
        sceneManager.getActiveScene().update(timestamp);
    }

    public SceneManager getSceneManager()
    {
        return this.sceneManager;
    }

    public void exit()
    {
        System.out.println("BYE!");
        System.exit(0);
    }

    private Game()
    {
        sceneManager = new SceneManager();
    }

    public static Game app()
    {
        if (instance == null) {
            instance = new Game();
        }

        return instance;
    }
}
