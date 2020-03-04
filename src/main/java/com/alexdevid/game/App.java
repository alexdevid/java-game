package com.alexdevid.game;

import com.alexdevid.game.scene.menu.MainMenu;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Application entry point
 */
public class App extends Application
{
    public void start(Stage stage)
    {
        stage.setTitle(Game.NAME);
        stage.setWidth(Game.SCREEN_WIDTH);
        stage.setHeight(Game.SCREEN_HEIGHT);
        stage.setResizable(false);

        Scene scene = new Scene(Game.app().getRoot());

        Game.app().getSceneManager().loadScene(new MainMenu());

        stage.setScene(scene);
        stage.show();

        startAnimation();
    }

    private void startAnimation()
    {
        final LongProperty lastUpdateTime = new SimpleLongProperty(0);
        final AnimationTimer timer = new AnimationTimer()
        {
            @Override
            public void handle(long timestamp)
            {
                if (lastUpdateTime.get() > 0) {
                    Game.app().update(timestamp);
                }

                lastUpdateTime.set(timestamp);
            }
        };

        timer.start();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}