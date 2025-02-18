#include  <iostream>
#include "AmoreRobotDrive.h"
#include "AmoreDump.h"
#include "WPILib.h"

/**
 * This is a demo program showing the use of the RobotBase class.
 * The SimpleRobot class is the base of a robot application that will automatically call your
 * Autonomous and OperatorControl methods at the right time as controlled by the switches on
 * the driver station or the field controls.
 */
class Robot : public SimpleRobot
{
	AmoreRobotDrive *myRobot; // robot drive system
	AmoreDump * myDump;
	Joystick * rightStick; // only joystick
	Joystick * leftStick;
	DriverStation *ds; // driver station

public:
	Robot(void) {
		ds = DriverStation::GetInstance();
		std::cerr << "We have a driver station" << std::endl;
		myRobot = new AmoreRobotDrive(); // custom robot drive base
		std::cerr << "We have AmoreRobotDrive" << std::endl;
		myDump = new AmoreDump();
		std::cerr << "We have an AmoreDump" << std::endl;
		leftStick = new Joystick(1); // create the joysticks
		rightStick = new Joystick(2);
		GetWatchdog().SetExpiration(100);
		
		std::cout << "I am sorry Dave, I can't do that!" << std::endl;
	}

	/**
	 * Dummy autonomous mode for testing:
	 * 		drive left & right motors for 2 seconds then stop
	 */
	void Autonomous(void) {
		GetWatchdog().SetEnabled(false);
		Timer myTimer;
		myTimer.Start();
		std::cerr << "Auto mode entered" << std::endl;
		
		myRobot->AutoDrive();
		std::cerr << "Timer says: " << myTimer.Get() << std::endl;
		Wait(5); 				//    for 5 seconds
		std::cerr << "Timer says: " << myTimer.Get() << std::endl;
		myRobot->AutoStop();
		
		std::cerr << "Auto mode done" << std::endl;
	}

	/**
	 * Runs the motors with arcade steering. 
	 */
	void OperatorControl(void) {
		GetWatchdog().SetEnabled(false);
		
		while (IsOperatorControl()) {
			GetWatchdog().Feed();
			
			myRobot->MyDrive(rightStick, leftStick);
			myDump->goRun(rightStick);
			Wait(0.005);
		}
	}
};

START_ROBOT_CLASS(Robot);
