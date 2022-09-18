package it.unicam.cs.pa.jlogo.api.colors;

/**
 * This class is used to represent the colors used for drawing in the RGB (red-green-blue) format
 *
 * @author Stanislav Teghipco
 */

public class RGBColorLogo implements RGBColor {
    private int redByte;
    private int greenByte;
    private int blueByte;

    /**
     * Creates a RGB color, given the parameters corresponding to the colors
     *
     * @param redByte   byte corresponding to the red part
     * @param greenByte byte corresponding to the green part
     * @param blueByte  byte corresponding to the blue part
     */
    public RGBColorLogo(int redByte, int greenByte, int blueByte) {
        this.redByte = isWithinBounds(redByte);
        this.greenByte = isWithinBounds(greenByte);
        this.blueByte = isWithinBounds(blueByte);
    }

    /**
     * Creates a RGB color without given parameters, in which case the color is black
     */
    public RGBColorLogo() {
        this.redByte = 0;
        this.greenByte = 0;
        this.blueByte = 0;
    }

    @Override
    public int getRedByte() {
        return redByte;
    }

    @Override
    public int getGreenByte() {
        return greenByte;
    }

    @Override
    public int getBlueByte() {
        return blueByte;
    }

    @Override
    public String getLogoFormat() {
        String logoFormat = redByte + " " + greenByte + " " + blueByte;

        return logoFormat;
    }
}
