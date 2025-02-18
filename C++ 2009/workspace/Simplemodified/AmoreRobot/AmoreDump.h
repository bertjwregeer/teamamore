#ifndef AMORE_DUMP_H
#define AMORE_DUMP_H

#include "Relay.h"
#include "Victor.h"
#include "DigitalInput.h"
#include "WPILib.h"

class AmoreDump {
public:	
	AmoreDump();
	
	// Return true when done
	bool liftUp();
	bool liftDown();
	
	void liftGo(Joystick *);
	void unLoad(Joystick *);
	
	void rollerCollect();
	
	void goRun(Joystick *);
	void dumpGo(Joystick *);
	
private:
	Relay * rollerBottom;
	Jaguar * rollerLift;
	Jaguar * shooterLift;
	DigitalInput * limitLift;
	
	Timer * liftTimer;
	Timer * liftTriggerTimer;
	
	bool collectorOn;
	bool liftActionDone;
	int  liftCurAction;
	int  liftPrevAction;
	
};

#endif
