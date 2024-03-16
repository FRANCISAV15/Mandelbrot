public class View {

    int screenWidth, screenHeight;
    double xSlope;
    double xOffset;
    double ySlope;
    double yOffset;

    public View(int w, int h) {

        screenWidth = w;

        screenHeight = h;

        setComplexCorners(new Complex(-2, 1), new Complex(1, -1));

    }

    public Complex translate(int x, int y) {
        double real = xSlope * x + xOffset;

        double imag = ySlope * y + yOffset;

        return new Complex(real, imag);

    }

    public void setComplexCorners(Complex topLeft, Complex botRight) {
        this.xSlope = ((botRight.getReal() - topLeft.getReal()) / (screenWidth - 0));
        this.xOffset = topLeft.getReal();
        this.ySlope = -xSlope;
        this.yOffset = topLeft.getImag();

    }

}