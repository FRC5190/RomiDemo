// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class PlayMusic extends CommandBase {
  private final String musicLocation;
  
  /** Creates a new PlayMusic. */
  public PlayMusic(String location) {
    musicLocation = location;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    try {
      File musicPath = new File(musicLocation);

      if (musicPath.exists()) {
        AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
        Clip clip = AudioSystem.getClip();
        
        if (!clip.isRunning()) {
          clip.open(audioInput);
          clip.start();
          clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
      }
      else {
        System.out.println("can't find file");
      }
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
