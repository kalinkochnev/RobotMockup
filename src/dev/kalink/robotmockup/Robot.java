package dev.kalink.robotmockup;

public class Robot {

    private double xpos;
    private double ypos;
    private double dir_degrees;
    private double size_x;
    private double size_y;

    public double getXpos() {
        return xpos;
    }

    public void setXpos(double xpos) {
        this.xpos = xpos;
    }

    public double getYpos() {
        return ypos;
    }

    public void setYpos(double ypos) {
        this.ypos = ypos;
    }

    public double getDir_degrees() {
        return dir_degrees;
    }

    public void setDir_degrees(double dir_degrees) {
        this.dir_degrees = dir_degrees;
    }

    public double getSize_x() {
        return size_x;
    }

    public void setSize_x(double size_x) {
        this.size_x = size_x;
    }

    public double getSize_y() {
        return size_y;
    }

    public void setSize_y(double size_y) {
        this.size_y = size_y;
    }


    Robot(double size_x, double size_y) {
        xpos = 0;
        ypos = 0;
        dir_degrees = 0;
        this.size_x = size_x;
        this.size_y = size_y;
    }

    Robot(double xpos, double ypos, double direction, double size_x, double size_y) {
        this.xpos = xpos;
        this.ypos = ypos;
        this.dir_degrees = direction;
        this.size_x = size_x;
        this.size_y = size_y;
    }

    //returns the robots location in an array {xpos, ypos};
    public double[] get_robot_pos() {
        return new double[]{xpos, ypos};
    }

    public void move(double distance, double angle) {
        xpos += distance * Math.cos(angle);
        ypos += distance * Math.sin(angle);
        dir_degrees += angle;
    }


}
