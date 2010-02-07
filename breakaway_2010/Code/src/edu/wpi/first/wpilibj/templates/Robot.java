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
import edu.wpi.first.wpilibj.Timer;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

    //slot in cRio that breakout board is plugged into.
    private static int CHASIS_SLOT = 4;

    //declare variables
    private Jaguar left1, left2, right1, right2; //motor variables
    private Jaguar kicker_motor; //kicker
    private Joystick joystick; //joystick
    private RobotDrive drive_system; //drive system
    private RobotKicker kicker; //kicker

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {

        //instantiate jaguars and joystick
        left1 = new Jaguar(CHASIS_SLOT,1);
        left2 = new Jaguar(CHASIS_SLOT,2);
        right1 = new Jaguar(CHASIS_SLOT,3);
        right2 = new Jaguar(CHASIS_SLOT,4);
        kicker_motor = new Jaguar(CHASIS_SLOT,5);
        joystick = new Joystick(1);

        //drive system
        drive_system = new RobotDrive(left1, left2, right1, right2);

        //kicker
        kicker = new RobotKicker(kicker_motor, getWatchdog());
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        //temporarily disable watchdog
        getWatchdog().setEnabled(false);

        drive_system.drive(1,-1); //spin to the right for 2 seconds
        Timer.delay(2);

        drive_system.drive(.5,.5); //drive forward at half speed for 3 seconds
        Timer.delay(3);

        kick(); //activate kicker

        //re-enable watchdog
        getWatchdog().setEnabled(true);

        //feed watchdog
        getWatchdog().feed();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        
        drive_system.arcardeDrive(joystick);
        
        //feed watchdog
        getWatchdog().feed();
    }

    public void kick() {
        //stop robot from moving
        drive_system.stop();

        //kick
        kicker.kick();
    }
}
