package com.alexdevid.game.scene.menu;

import com.alexdevid.game.Game;
import com.alexdevid.game.module.ui.Button;
import com.alexdevid.game.scene.FadingScene;
import javafx.scene.text.Text;

abstract class MenuScene extends FadingScene
{
    @Override
    public void update(long timestamp)
    {
        super.update(timestamp);

        if (this.isFadeOutComplete()) {
            Game.app().getSceneManager().loadScene(new MainMenu());
        }
    }

    void renderScreenTitle(String title)
    {
        Text screenName = new Text(title);
        screenName.applyCss();

        final double centerX = screenName.getLayoutBounds().getCenterX();
        final double centerY = screenName.getLayoutBounds().getCenterY();

        this.getGuiLayer().getCanvas().getGraphicsContext2D().fillText(screenName.getText(), Game.SCREEN_WIDTH / 2f - centerX, 50);
    }

    void renderBackButton()
    {
        Button backButton = new Button(Game.SCREEN_WIDTH / 2f - 100, 260, 200, 50);
        backButton.setText("BACK");
        backButton.draw();

        backButton.onMouseClicked(event -> {
            this.fadeOut();
        });
    }
}
