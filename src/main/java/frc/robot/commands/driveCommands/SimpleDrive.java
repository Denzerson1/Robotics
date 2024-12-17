package frc.robot.commands.driveCommands;

// WPI imports
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;

// RobotContainer import
import frc.robot.RobotContainer;

// Subsystem imports
import frc.robot.subsystems.DriveTrain;

/**
 * SimpleDrive class
 * <p>
 * Drives the robot in a square motion: go forward, turn right, repeat.
 */
public class SimpleDrive extends CommandBase {
    // Grab the subsystem instance from RobotContainer
    private static final DriveTrain drive = RobotContainer.drive;

    // Timer to control durations
    private final Timer timer = new Timer();

    /**
     * Constructor
     */
    public SimpleDrive() {
        addRequirements(drive);
    }

    /**
     * Runs before the command starts
     */
    @Override
    public void initialize() {
        timer.reset();
        timer.start();
    }

    /**
     * Called repeatedly to execute the motion
     */
    @Override
    public void execute() {
        double time = timer.get();

        // Forward for 2 seconds, then turn right for 1 second, repeat
        if ((time % 3) < 2) {
            driveForward(); // Drive forward for 2 seconds
        } else {
            turnRight(); // Turn right for 1 second
        }
    }

    /**
     * Stops all motion
     */
    @Override
    public void end(boolean interrupted) {
        stopDrive();
    }

    /**
     * Runs indefinitely until interrupted
     */
    @Override
    public boolean isFinished() {
        return false;
    }

    // Movement methods
    private void driveForward() {
        drive.setMotorSpeed(0.5, 0, -0.5, 0); // Forward motion
    }

    private void turnRight() {
        drive.setMotorSpeed(-0.5, -0.5, -0.5, -0.5); // In-place right turn
    }

    private void stopDrive() {
        drive.setMotorSpeed(0.0, 0.0, 0.0, 0.0); // Stop motors
    }
}
