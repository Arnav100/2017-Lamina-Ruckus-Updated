package org.usfirst.frc.team4930.robot.autonomous;

import org.usfirst.frc.team4930.robot.commands.ReplayPlayback;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoReplay extends CommandGroup
{
  public AutoReplay() {
    System.out.println("AUTO: Initializing AutoReplayGear()");
    addSequential(new ReplayPlayback());
  }
}
