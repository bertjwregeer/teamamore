/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;

/**
 *
 * @author jeremy
 */
public class RobotDrive {
    private Jaguar left1, left2, right1, right2;

    public static int DEFAULT_CHASIS_SLOT = 4;

    public RobotDrive(Jaguar left1, Jaguar left2, Jaguar right1, Jaguar right2 ) {
        this.left1 = left1;
        this.left2 = left2;
        this.right1 = right1;
        this.right2 = right2;
    }

    public void arcardeDrive(Joystick joystick) {
        //get joystick axes
        double x = joystick.getAxis(Joystick.AxisType.kX);
        double y = joystick.getAxis(Joystick.AxisType.kY);

        //mix x and y axis to get left and right speeds
        double left = x+y;
        double right = y-x;

        //make speeds less sensitive so driving is easier
        left = left*Math.abs(left);
        right = right*Math.abs(right);

        //drive
        drive(left,right);
    }

     /**
     * This makes sure a number is within a range -1.0 to 1.0
     * @param num The number
     * @return The number after normalizing
     */
    private double normalize(double num) {
        //make sure number is within scale
        if(num<-1.0) num = -1.0;
        else if(num>1.0) num = 1.0;

        return num;
    }
    
    /**
     * Sets the speed of drive train motors.
     *
     * @param left Speed of the left motors (-1.0 to 1.0)
     * @param right Speed of the right motors (-1.0 to 1.0)
     */
    public void drive(double left_speed, double right_speed) {
        //left motors
        left1.set(normalize(left_speed));
        left2.set(normalize(left_speed));

        //right motors
        right1.set(normalize(right_speed));
        right2.set(normalize(right_speed));
    }

    /**
     * Stops all drive motors
     */
    public void stop() {
        drive(0,0);
    }

}
