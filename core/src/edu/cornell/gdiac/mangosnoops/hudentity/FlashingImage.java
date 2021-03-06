package edu.cornell.gdiac.mangosnoops.hudentity;

import com.badlogic.gdx.graphics.Texture;
import edu.cornell.gdiac.mangosnoops.GameCanvas;
import edu.cornell.gdiac.mangosnoops.Image;

/**
 * FlashingImage flashes on the screen at a particular rate. Its
 * visibility can be toggled. For use in the Tutorial implementation.
 */
public class FlashingImage extends Image {

    /** How quickly the image flashes */
    private float FLASHING_RATE = 0.5f;

    private float deltaSum = 0;

    /**
     * Whether or not the Image is visible to the user.
     *  Not to be confused with hidden:
     *   - when isVisibleToUser is true, the image will
     *     flash on and off.
     *   - when isVisibleToUser is false, the image will
     *      remain invisible.
     */
    private boolean isVisibleToUser;

    /**
     * Whether or not the image is hidden - this toggles on
     * and off repeatedly
     */
    private boolean hidden;

    public FlashingImage(float x, float y, float relSca, Texture tex) {
        super(x, y, relSca, tex);
        isVisibleToUser = false;
        hidden = true;
    }

    public FlashingImage(float x, float y, float relSca, Texture tex, GameCanvas.TextureOrigin o) {
        super(x, y, relSca, tex, o);
        isVisibleToUser = false;
        hidden = true;
    }

    /**
     * Set the visibility to inVis.
     * @param isVis visibility
     */
    public void setVisible(boolean isVis) {
        isVisibleToUser = isVis;
    }

    public void update(float delta) {
        deltaSum += delta;
        if (deltaSum > FLASHING_RATE) {
            deltaSum = 0;
            hidden = !hidden;
        }
    }

    @Override
    public void draw(GameCanvas canvas) {
        if (isVisibleToUser && !hidden) {
            super.draw(canvas);
        }
    }

    @Override
    public void draw(GameCanvas canvas, float ang) {
        if (isVisibleToUser && !hidden) super.draw(canvas, ang);
    }
}
