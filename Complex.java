public class Complex {
    private double real;
    private double imag;

    public Complex(double newReal, double newImaginary) {
        this.real = newReal;
        this.imag = newImaginary;
    }

    public Complex() {
        this.real = 0;
        this.imag = 0;
    }

    public double getReal() {
        return this.real;
    }

    public double getImag() {
        return this.imag;
    }

    public Complex add(Complex other) {
        double newReal = this.real + other.real;
        double newImag = this.imag + other.imag;
        return new Complex(newReal, newImag);
    }

    public Complex add(double real) {

        return this.add(new Complex(real, 0));
    }

    public double abs() {
        double a = this.real * this.real;
        double b = this.imag * this.imag;
        return Math.sqrt(a + b);
    }

    public Complex subtract(Complex other) {
        double newReal = this.real - other.real;
        double newImag = this.imag - other.imag;
        return new Complex(newReal, newImag);
    }

    public Complex subtract(double real) {
        return this.subtract(new Complex(real, 0));
    }

    public Complex multiply(Complex other) {
        return new Complex((this.real * other.real) - (this.imag * other.imag),
                (this.real * other.imag) + (this.imag * other.real));
    }

    public Complex multiply(double real) {
        return this.multiply(new Complex(real, 0));
    }

    public Complex divide(Complex other) {
        double a = this.real;
        double b = this.imag;
        double c = other.real;
        double d = other.imag;
        double ac = (a * c);
        double bd = (b * d);
        double denominator = (c * c) + ((d * d));
        double bc = (b * c);
        double ad = (a * d);

        return new Complex(((ac + bd) / denominator), ((bc - ad) / denominator));
    }

    public Complex divide(double real) {

        return this.divide(new Complex(real, 0));
    }

    public boolean equals(Complex other) {
        if (this.real == other.real && this.imag == other.imag) {
            return true;
        }
        return false;
    }

    public Complex square() {
        return this.multiply(new Complex(this.real, this.imag));
    }

    public String toString() {
        return String.format(real + "+" + imag + "i");
    }

}
