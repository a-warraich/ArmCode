// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.*;
import frc.robot.subsystems.*;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Intake;


public class RobotContainer {
    //Subsystems
    private final Arm arm = new Arm();
    //private final Hooks hooks = new Hooks();
    //private final Intake intake = new Intake();

    //Commands
    //private final CoralIntake cIntake = new CoralIntake(intake);
    //private final CoralDeposit cDeposit = new CoralDeposit(intake);
    private final AHigh daHigh = new AHigh(arm);
    private final ALow daLow = new ALow(arm);
    private final ACoral aCoral = new ACoral(arm);
    private final test Test = new test(arm);

  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController xbox =
      new CommandXboxController(0);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    //xbox.x().toggleOnTrue(cIntake);
    //xbox.b().toggleOnTrue(cDeposit);
    xbox.povUp().toggleOnTrue(daHigh);
    xbox.povDown().toggleOnTrue(daLow);
    //xbox.povRight().toggleOnTrue(aCoral);
    //xbox.rightTrigger().whileTrue(Test);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return null;
  }
}
