package com.alexdevid.game.scene;

import com.alexdevid.game.Game;

abstract public class FadingScene extends GameScene
{
    private boolean fadeOutStarted = false;
    private boolean fadeInComplete = false;
    private boolean fadeOutComplete = false;

    @Override
    public void update(long timestamp)
    {
        if (!this.fadeInComplete && !this.fadeOutStarted) {
            if (this.getGuiLayer().getCanvas().getOpacity() <= 0.95f) {
                this.getGuiLayer().getCanvas().setOpacity(this.getGuiLayer().getCanvas().getOpacity() + 0.05f);
            } else {
                this.getGuiLayer().getCanvas().setOpacity(1.0f);
                this.fadeInComplete = true;
            }
        }

        if (fadeOutStarted && !this.fadeOutComplete) {
            this.getGuiLayer().getCanvas().setOpacity(this.getGuiLayer().getCanvas().getOpacity() - 0.05f);
            if (this.getGuiLayer().getCanvas().getOpacity() <= 0.1f) {
                this.fadeOutComplete = true;
            }
        }
    }

    protected void hide()
    {
        this.getGuiLayer().getCanvas().setOpacity(0.0f);
    }

    protected void fadeOut()
    {
        this.fadeOutStarted = true;
    }

    protected boolean isFadeOutComplete()
    {
        return this.fadeOutComplete;
    }
}
