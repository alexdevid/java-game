package com.alexdevid.game.scene.menu;

public class Start extends MenuScene
{
    @Override
    public void start()
    {
        this.renderScreenTitle("START GAME");
        this.renderBackButton();
        this.hide();
    }
}
