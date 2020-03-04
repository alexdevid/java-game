package com.alexdevid.game;

public class FPSMeter
{
    private final long[] frameTimes = new long[30];
    private int frameTimeIndex = 0 ;
    private boolean arrayFilled = false ;

    private double fps = 0;

    public void update(long nanoTime)
    {
        long oldFrameTime = frameTimes[frameTimeIndex] ;
        frameTimes[frameTimeIndex] = nanoTime ;
        frameTimeIndex = (frameTimeIndex + 1) % frameTimes.length ;
        if (frameTimeIndex == 0) {
            arrayFilled = true ;
        }
        if (arrayFilled) {
            long elapsedNanos = nanoTime - oldFrameTime ;
            long elapsedNanosPerFrame = elapsedNanos / frameTimes.length ;
            fps = 1_000_000_000.0 / elapsedNanosPerFrame ;
        }
    }

    public double getFPS()
    {
        return this.fps;
    }
}
