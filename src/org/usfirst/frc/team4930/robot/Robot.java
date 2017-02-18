package org.usfirst.frc.team4930.robot;

import org.usfirst.frc.team4930.robot.subsystems.Climber;
import org.usfirst.frc.team4930.robot.subsystems.DriveTrain;
import org.usfirst.frc.team4930.robot.subsystems.GearGadget;
import org.usfirst.frc.team4930.robot.subsystems.Pneumatics;
import org.usfirst.frc.team4930.robot.utilities.Playbacker;
import org.usfirst.frc.team4930.robot.utilities.Recorder;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the IterativeRobot documentation. If you change the name of this class
 * or the package after creating this project, you must also update the manifest file in the
 * resource directory.
 */
public class Robot extends IterativeRobot
{
  public static OI oi;
  public static DriveTrain driveTrain;
  public static Pneumatics pneumatics;
  public static Climber climber;
  public static GearGadget gearGadget;

  public static Recorder recorder;
  public static Playbacker playbacker;
  public static String autoFile = "TestReplay";
  public static String autoFilePath = new String("/home/lvuser/CSVs/" + autoFile + ".csv");
  public static boolean isRecording;
  public static boolean isPlaying;

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    RobotMap.init();
    driveTrain = new DriveTrain();
    recorder = new Recorder();
    playbacker = new Playbacker();
    pneumatics = new Pneumatics();
    climber = new Climber();
    gearGadget = new GearGadget();
    oi = new OI();

    isRecording = false;
    isPlaying = false;
  }

  /**
   * This function is called once each time the robot enters Disabled mode. You can use it to reset
   * any subsystem information you want to clear when the robot is disabled.
   */
  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select between different
   * autonomous modes using the dashboard. The sendable chooser code works with the Java
   * SmartDashboard. If you prefer the LabVIEW Dashboard, remove all of the chooser code and
   * uncomment the getString code to get the auto name from the text box below the Gyro
   *
   * You can add additional auto modes by adding additional commands to the chooser code above (like
   * the commented example) or additional comparisons to the switch structure below with additional
   * strings & commands.
   */
  @Override
  public void autonomousInit() {}

  /**
   * This function is called periodically during autonomous
   */
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {}

  /**
   * This function is called periodically during operator control
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();

    SmartDashboard.putBoolean("isRecording: ", isRecording);
    SmartDashboard.putBoolean("isPlaying: ", isPlaying);

    autoFilePath = new String("/home/lvuser/CSVs/" + autoFile + ".csv");
    SmartDashboard.putString("autoFile: ", autoFile);
    SmartDashboard.putString("autoFilePath: ", autoFilePath);

    SmartDashboard.putBoolean("solenoid value", RobotMap.solenoid.get());
  }

  /**
   * This function is called periodically during test mode
   */
  @Override
  public void testPeriodic() {
    LiveWindow.run();
  }
}