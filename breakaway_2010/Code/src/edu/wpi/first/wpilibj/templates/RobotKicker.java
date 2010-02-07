/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Watchdog;

/**
 *
 * @author jeremy
 */
public class RobotKicker {
    private Jaguar motor;
    private Watchdog watchdog;

    private int status;
    private boolean kicking;

    //possible kicker statuses
    public static final int KICKER_CHARGING = 1;
    public static final int KICKER_CHARGED = 2;
    public static final int KICKER_FIRING = 3;
    public static final int KICKER_FIRED = 4;

    public RobotKicker(Jaguar motor, Watchdog watchdog) {
        this.motor = motor;
        this.watchdog = watchdog;
    }

    public boolean kick() {
        if(kicking) return false;

        kicking = true;

        while(this.getStatus()==KICKER_FIRING) {
            //wait for kicker to fire
        }
        if(this.getStatus()==KICKER_FIRED) {
            chargeKicker();
        }

        while(this.getStatus()==KICKER_CHARGING) {
            //wait for kicker to charge
        }
        if(this.getStatus()==KICKER_CHARGED) {
            fireKicker();
        }

        kicking = false;

        return true;
    }

    /**
     * charged the kicker
     */
    private void chargeKicker() {
        setStatus(KICKER_CHARGING);
        motor.set(-1);

        boolean starting_watchdog = watchdog.getEnabled();
        watchdog.setEnabled(false);
        Timer.delay(2);
        watchdog.setEnabled(starting_watchdog);

        setStatus(KICKER_CHARGED);
    }

    /**
     * fires the kicker
     *
     * @return True if kicker fired, false otherwise
     */
    private void fireKicker() {
       setStatus(KICKER_FIRING);
       motor.set(1);

        boolean starting_watchdog = watchdog.getEnabled();
        watchdog.setEnabled(false);
        Timer.delay(2);
        watchdog.setEnabled(starting_watchdog);
        
       setStatus(KICKER_FIRED);
    }

    /**
     * Returns the kickers status
     *
     * @return The status code, either KICKER_CHARGING, KICKER_CHARGED, KICKER_FIRING, or KICKER_FIRED
     */
    public int getStatus() {
        return status;
    }

    private void setStatus(int status) {
        this.status = status;
    }
}