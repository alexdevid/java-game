package com.alexdevid.game.scene.menu;

public class Settings extends MenuScene
{
    @Override
    public void start()
    {
        this.renderScreenTitle("SETTINGS");
        this.renderBackButton();
        this.hide();
    }
}
