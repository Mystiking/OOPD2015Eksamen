
public class Vector {
    private double x;
    private double y;
    private double z;

    /**
     * Constructor: Creates a vector object in three dimensions.
     *
     * @param x The x-coordinate of the vector.
     * @param y The y-coordinate of the vector.
     * @param z The z-coordinate of the vector.
     */
    public Vector (double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Adds another vector to the desired vector.
     *
     * @param other The vector to be added.
     * @return The result of the addition.
     */
    public Vector add(Vector other){
        double x = this.getX() + other.getX();
        double y = this.getY() + other.getY();
        double z = this.getZ() + other.getZ();

        return new Vector(x, y, z);
    }

    /**
     * Multiplies each element of the vector by the desired amount.
     *
     * @param amount the amount to be multiplied with each element.
     * @return the result of the multiplication.
     */
    public Vector mul(double amount){
        double x = this.getX() * amount;
        double y = this.getY() * amount;
        double z = this.getZ() * amount;

        return new Vector(x, y, z);
    }

    /**
     * Checks if two vectors are identical
     *
     * @param other the vector to be checked against
     * @return if the vectors are the same
     */
    public boolean equals(Vector other){
        boolean x = Math.abs(this.getX() - other.getX()) < .000001;
        boolean y = Math.abs(this.getY() - other.getY()) < .000001;
        boolean z = Math.abs(this.getZ() - other.getZ()) < .000001;

        return x && y && z;
    }

    /**
     * Subtracts a vector from another
     *
     * @param other the vector to subtract with
     * @return the result of the subtraction
     */
    public Vector sub(Vector other){
        double x = this.getX() - other.getX();
        double y = this.getY() - other.getY();
        double z = this.getZ() - other.getZ();

        return new Vector(x, y, z);
    }

    /**
     * Computes the length of the vector
     *
     * @return the length of the vector
     */
    public double length(){
        double x_pow_2 = Math.pow(this.getX(), 2);
        double y_pow_2 = Math.pow(this.getY(), 2);
        double z_pow_2 = Math.pow(this.getZ(), 2);
        double sum = x_pow_2 + y_pow_2 + z_pow_2;

        return Math.sqrt(sum);
    }

    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    public double getZ(){
        return this.z;
    }

    public String toString(){
        String x = "[ " + this.getX() + " ]";
        String y = "[ " + this.getY() + " ]";
        String z = "[ " + this.getZ() + " ]";

        return x + "\n" + y + "\n" + z;
    }
}
