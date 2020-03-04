package com.alexdevid.game.scene.menu;

import com.alexdevid.game.Game;
import com.alexdevid.game.module.ui.Button;

public class MainMenu extends MenuScene
{
    private Button startButton;
    private Button exitButton;
    private Button settingsButton;

    private LevelChange nextLevel;
    private enum LevelChange {
        Start, Settings
    }

    @Override
    public void start()
    {
        startButton = new Button(Game.SCREEN_WIDTH / 2f - 100, 100, 200, 50);
        startButton.setText("START");

        settingsButton = new Button(Game.SCREEN_WIDTH / 2f - 100, 180, 200, 50);
        settingsButton.setText("SETTINGS");

        exitButton = new Button(Game.SCREEN_WIDTH / 2f - 100, 260, 200, 50);
        exitButton.setText("EXIT");

        startButton.draw();
        settingsButton.draw();
        exitButton.draw();

        this.events();

        this.hide();
    }

    @Override
    public void update(long timestamp)
    {
        super.update(timestamp);

        if (this.isFadeOutComplete()) {
            if (this.nextLevel == LevelChange.Settings) {
                Game.app().getSceneManager().loadScene(new Settings());
            }
            if (this.nextLevel == LevelChange.Start) {
                Game.app().getSceneManager().loadScene(new Start());
            }
        }
    }

    private void events()
    {
        startButton.onMouseClicked(event -> {
            this.nextLevel = LevelChange.Start;
            this.fadeOut();
        });
        settingsButton.onMouseClicked(event -> {
            this.nextLevel = LevelChange.Settings;
            this.fadeOut();
        });
        exitButton.onMouseClicked(event -> {
            Game.app().exit();
        });
    }
}
