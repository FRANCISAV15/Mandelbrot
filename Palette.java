import java.awt.Color;

public class Palette {

    private int colorScheme;

    public Palette(int colorScheme) {
        this.colorScheme = colorScheme;
    }

    public Color mapColor(double normX) {
        if (this.colorScheme == 0) {
            return map0(normX);
        }
        if (this.colorScheme == 1) {
            return map1(normX);
        }
        if (this.colorScheme == 2) {
            return map2(normX);
        }
        return map0(normX);
    }

    private Color map0(double n) {
        if (n < 0) {
            return Color.BLACK;
        } else {
            return Color.WHITE;
        }
    }

    private Color map1(double n) {
        if (n < 0) {
            return Color.BLACK;

        }
        int red = (int) (((255 / 2)) * (Math.cos((5 * n)))) + (255 / 2);
        int green = (int) ((((255 / 2) * Math.sin((3 * n))) + ((255 / 2))));
        int blue = (int) (((-255 / 2) * Math.cos((4 * n))) + (((255 / 2) + 1)));
        return new Color(red, green, blue);
    }

    public Color map2(double n) {
        double smoothColorValue = Math.log(Math.log(n + 1) / Math.log(2)) / Math.log(2);
        int r = (int) (Math.cos(0.3 * smoothColorValue + 0) * 127 + 128);
        int g = (int) (-1 * Math.cos(0.3 * smoothColorValue + 2) * 127 + 128);
        int b = (int) (Math.sin(0.3 * smoothColorValue + 4) * 128 + 128);
        return new Color(r, g, b);

    }

}