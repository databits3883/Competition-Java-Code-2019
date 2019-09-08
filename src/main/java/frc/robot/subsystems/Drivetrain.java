/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.ManualDrive;

/**
 * Add your docs here.
 */
public class Drivetrain extends Subsystem {
  MotorType type = MotorType.kBrushless;
  CANSparkMax frontLeft = new CANSparkMax(RobotMap.frontLeftChannel, type);
  CANSparkMax rearLeft = new CANSparkMax(RobotMap.rearLeftChannel, type);
  CANSparkMax frontRight = new CANSparkMax(RobotMap.frontRightChannel, type);
  CANSparkMax rearRight = new CANSparkMax(RobotMap.rearRightChannel, type);

  SpeedControllerGroup left = new SpeedControllerGroup(frontLeft, rearLeft);
  SpeedControllerGroup right = new SpeedControllerGroup(frontRight, rearRight);

  DifferentialDrive train = new DifferentialDrive(left, right);

  public void drive(float x, float y){
    train.arcadeDrive(y, x);
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    
  }
}
