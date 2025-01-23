// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.DutyCycleEncoder;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.ClosedLoopConfig.FeedbackSensor;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.SparkFlex;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.SparkAbsoluteEncoder;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arm extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  private final SparkMax leader = new SparkMax(3, MotorType.kBrushless);
  
  private final SparkAbsoluteEncoder encoder = leader.getAbsoluteEncoder();
  private final SparkClosedLoopController armPIDController;

  public Arm() {
    armPIDController = leader.getClosedLoopController();
    configureMotors();
  }

  public void configureMotors(){
    SparkMaxConfig leaderConfig = new SparkMaxConfig();
    
    leaderConfig.encoder.positionConversionFactor(5).velocityConversionFactor(5);
    leaderConfig.closedLoop.feedbackSensor(FeedbackSensor.kPrimaryEncoder);
    leaderConfig.closedLoop.pid(1, 0, 0.00);

    leader.configure(leaderConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
  }

  public double getPosition(){
    return encoder.getPosition();    
  }

  public void setPosition(double pos){
    armPIDController.setReference(pos, SparkMax.ControlType.kPosition);
  }

  public void setSpeed(double speed){
    leader.set(0.1);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
