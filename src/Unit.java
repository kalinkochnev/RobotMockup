public class Unit {
    double length;
    double conversion_factor_x;
    double conversion_factor_y;
    String unit_type;

    Unit(String unit_type, double length) {
        this.unit_type = unit_type;
        this.conversion_factor_x = 1;
        this.conversion_factor_y = 1;
    }

    Unit(String unit_type, double max_x, double max_y, double length) {
        this.unit_type = unit_type;
        this.conversion_factor_x = calc_conversion(length, max_x);
        this.conversion_factor_y = calc_conversion(length, max_y);
    }

    private double calc_conversion(double actual_length, double max_coord) {
        return actual_length/max_coord;
    }

    public String get_unit_type() {
        return  unit_type;
    }

    public double get_conversion_factor_x() {
        return conversion_factor_x;
    }

    public double get_conversion_factor_y() {
        return conversion_factor_y;
    }

}
