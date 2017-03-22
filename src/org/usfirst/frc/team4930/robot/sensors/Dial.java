package org.usfirst.frc.team4930.robot.sensors;

import org.usfirst.frc.team4930.robot.Robot;
import org.usfirst.frc.team4930.robot.RobotMap;
import org.usfirst.frc.team4930.robot.autonomous.*;

public class Dial
{

  // return 0-10 dial number after normalizing to nearest 11th point
  static public int getDialNumber() {
    double autoSwitch = RobotMap.dial.get();
    double dialNum = (autoSwitch + 7) / (360 / 11);
    double floor = Math.floor(dialNum);
    if ((dialNum - floor) >= 0.5) {
      dialNum = Math.ceil(dialNum);
    } else {
      dialNum = floor;
    }
    return (int) dialNum;
  }

  // setup autonomous modes based on dial input
  public void setSelectedReplay() {
    Integer getDialNum = getDialNumber();
    if (getDialNum != Robot.dialNumber) {
      Robot.dialNumber = getDialNum;
      switch (Robot.dialNumber) {
        case 1:
          Robot.autoDescription = "(1) Drive Straight To Line";
          Robot.replayFilePath = "/home/lvuser/CSVs/Auto01.csv";
          Robot.autoCommand = new Auto01();
          break;
        case 2:
          Robot.autoDescription = "(2r) Place Gear On Left Side";
          Robot.replayFilePath = "/home/lvuser/CSVs/Auto02.csv";
          Robot.autoCommand = new Auto02();
          break;
        case 3:
          Robot.autoDescription = "(3r) Place Gear In The Middle";
          Robot.replayFilePath = "/home/lvuser/CSVs/Auto03.csv";
          Robot.autoCommand = new Auto03();
          break;
        case 4:
          Robot.autoDescription = "(4r) Place Gear On Right Side";
          Robot.replayFilePath = "/home/lvuser/CSVs/Auto04.csv";
          Robot.autoCommand = new Auto04();
          break;
        case 5:
          Robot.autoDescription = "(5r) Intake Along DS & Shoot";
          Robot.replayFilePath = "/home/lvuser/CSVs/Auto05.csv";
          Robot.autoCommand = new Auto05();
          break;
        case 6:
          Robot.autoDescription = "(6r) Short Turn & Shoot";
          Robot.replayFilePath = "/home/lvuser/CSVs/Auto06.csv";
          Robot.autoCommand = new Auto06();
          break;
        case 7:
          Robot.autoDescription = "(7) Trip Hopper (far) & Shoot";
          Robot.replayFilePath = "/home/lvuser/CSVs/Auto07.csv";
          Robot.autoCommand = new Auto07();
          break;
        case 8:
          Robot.autoDescription = "(8) Trip Hopper (near) & Shoot";
          Robot.replayFilePath = "/home/lvuser/CSVs/Auto08.csv";
          Robot.autoCommand = new Auto08();
          break;
        case 9:
          Robot.autoDescription = "(9r) Place Gear And Unload Fuel";
          Robot.replayFilePath = "/home/lvuser/CSVs/Auto09.csv";
          Robot.autoCommand = new Auto09();
          break;
        case 10:
          Robot.autoDescription = "(10) Replay Code Only";
          Robot.replayFilePath = "/home/lvuser/CSVs/Auto10.csv";
          Robot.autoCommand = new Auto10();
          break;
        default:
          Robot.dialNumber = 0;
          Robot.autoDescription = "(0) Do Nothing";
          Robot.replayFilePath = "";
          Robot.autoCommand = new Auto00();
      }
      System.out.println("AutoDial: " + Robot.autoDescription);
    }
  }
}
