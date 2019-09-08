/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Elevator extends PIDSubsystem {
  Encoder encoder = new Encoder(RobotMap.elevatorEncoderChannelA, RobotMap.elevatorEncoderChannelB);
  
  Spark motor = new Spark(RobotMap.elevatorChannel);
  Solenoid brake = new Solenoid(RobotMap.brakeChannel);

  DigitalInput topLimit = new DigitalInput(RobotMap.elevatorTopChannel);
  DigitalInput bottomLimit = new DigitalInput(RobotMap.elevatorBottomChannel);
  /**
   * Add your docs here.
   */
  public Elevator() {
    // Intert a subsystem name and PID values here
    super("Elevator", 0, 0, 0);
    encoder.setDistancePerPulse(RobotMap.elevatorDistancePerPulse);
    // Use these to get going:
    // setSetpoint() - Sets where the PID controller should move the system
    // to
    // enable() - Enables the PID controller.
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  @Override
  protected double returnPIDInput() {
    // Return your input value for the PID loop
    // e.g. a sensor, like a potentiometer:
    // yourPot.getAverageVoltage() / kYourMaxVoltage;
    return encoder.getDistance();
  }

  @Override
  protected void usePIDOutput(double output) {
    // Use output to drive your system, like a motor
    // e.g. yourMotor.set(output);
    output = limitCutoff(output);
    motor.set(output);
  }
  /**
   * Ensures the output does not push past the limit switches
   */
  double limitCutoff(double output){
    if (bottomLimit.get()) output = Math.max(0, output);
    if (topLimit.get()) output = Math.min(0, output);
    return output;
  }

}
