/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  //CAN 
  public static final int frontLeftChannel = 1;
  public static final int rearLeftChannel = 2;
  public static final int frontRightChannel = 3;
  public static final int rearRightChannel = 4;

  //PWM
  public static final int elevatorChannel = 0;
  public static final int neckChannel = 1;
  public static final int intakeChannel = 2;
  public static final int elevatorEncoderChannelA = 0;
  public static final int elevatorEncoderChannelB = 0;

  //DIO
  public static final int elevatorTopChannel = 0;
  public static final int elevatorBottomChannel = 1;

  //pnumatics
  public static final int jawChannel = 0;
  public static final int wristChannel = 1;
  public static final int brakeChannel = 2;


  //physical
  public static final float elevatorDistancePerPulse = 1;

  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;
}
