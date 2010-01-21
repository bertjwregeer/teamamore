/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;


import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

    //slot in cRio that breakout board is plugged into.
    public static int chasis_slot = 4;

    //declare variables
    Jaguar left1, left2, right1, right2; //motor variables
    Joystick joystick; //joystick


    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {

        //left wheels
        left1 = new Jaguar(chasis_slot,1);
        left2 = new Jaguar(chasis_slot,2);

        //right wheels
        right1 = new Jaguar(chasis_slot,3);
        right2 = new Jaguar(chasis_slot,4);

        //joystick
        joystick = new Joystick(1);
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        //temporarily disable watchdog
        getWatchdog().setEnabled(false);

        //autonomous code goes here

        //re-enable watchdog
        getWatchdog().setEnabled(true);

        //feed watchdog
        getWatchdog().feed();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        //read joystick input and set motor values

        //check for special joystick buttons
        
        //feed watchdog
        getWatchdog().feed();
    }

    /**
     * This scales a number in the range 0 to 255 to the range -1.0 to 1.0
     * @param num A number in the range 0 to 255
     * @return The scaled number in the range -1.0 to 1.0
     */
    public double scale(int num) {
        return scale((num - 127.5)/127.5);
    }

    /**
     * This makes sure a number is within a range -1.0 to 1.0
     * @param num The number
     * @return The number after normalizing
     */
    public double scale(double num) {
        //make sure number is within scale
        if(num<-1.0) num = -1.0;
        else if(num>1.0) num = 1.0;

        return num;
    }

    /**
     * Sets the speed of drive train motors.
     *
     * @param left Value of the left motors (0-255)
     * @param right Value of the right motors (0-255)
     */
    public void setMotors(int left, int right) {
        setMotors(scale(left),scale(right));
    }

    /**
     * Sets the speed of drive train motors.
     * 
     * @param left Value of the left motors (-1.0 to 1.0)
     * @param right Value of the right motors (-1.0 to 1.0)
     */
    public void setMotors(double left, double right) {
        //left motors
        left1.set(scale(left));
        left2.set(scale(left));

        //right motors
        right1.set(scale(right));
        right2.set(scale(right));

    }
    
}
