#include "AmoreRobotDrive.h"

/*
 * This is the initialisation routine for the Amore Robot drive, which
 * is basically a tank drive, with no modifications. May replace using
 * this code with using just the standard RobotDrive in the near future.
 * 
 * We initialise the following:
 * 
 * Jaguar:
 * Left wheels: PWM input 1
 * Right wheels: PWM input 3
 * 
 */

AmoreRobotDrive::AmoreRobotDrive() {
	leftWheels = new Jaguar(1);
	rightWheels = new Jaguar(3);
	
}


/*
 * Using two joysticks we get the current values and tell the robot to set the
 * wheel speed to the speed we request via the joysticks
 * 
 */

void AmoreRobotDrive::MyDrive(Joystick * rightStick, Joystick * leftStick) {
	//std::cout << "Joystick Right: "  << rightStick->GetY() << " Joystick Left: " << -(leftStick->GetY()) << std::endl;
	leftWheels->Set(-(leftStick->GetY()));
	rightWheels->Set(rightStick->GetY());
}

/*
 * In autonomous we want to drive forward at half speed, so set the motor speeds
 * 
 */

void AmoreRobotDrive::AutoDrive() {
	leftWheels->Set(0.5);
	rightWheels->Set(-0.5);
}


/*
 * We also want to provide a way to stop the robot while in autonomous mode
 * 
 */

void AmoreRobotDrive::AutoStop() {
	leftWheels->Set(0.0);
	rightWheels->Set(0.0);
}
