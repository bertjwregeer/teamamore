#ifndef AMORE_ROBOT_DRIVE_H
#define AMORE_ROBOT_DRIVE_H

#include "RobotDrive.h"
#include "WPILib.h"

class AmoreRobotDrive {
public:	
	AmoreRobotDrive();
	void MyDrive(Joystick *, Joystick *);
	void AutoDrive();
	void AutoStop();
	
private:
	Jaguar * leftWheels;
	Jaguar * rightWheels;
};

#endif // AMORE_ROBOT_DRIVE
