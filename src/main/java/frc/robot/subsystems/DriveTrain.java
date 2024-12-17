package frc.robot.subsystems;

//Vendor imports
import com.studica.frc.TitanQuad;

//WPI imports
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

/**
 * DriveTrain class 
 * <p>
 * This class creates the instance of the Titan and enables and sets the speed of the defined motor. 
 */
public class DriveTrain extends SubsystemBase
{
    /**
     * Motors
     */
    private TitanQuad motor;
    private TitanQuad motor1;
    private TitanQuad motor2;
    private TitanQuad motor3;

    /**
     * Constructor
     */
    public DriveTrain()
    {
        //Motors
        motor = new TitanQuad(Constants.TITAN_ID, Constants.MOTOR1);
        motor1 = new TitanQuad(Constants.TITAN_ID, Constants.MOTOR2);
        motor2 = new TitanQuad(Constants.TITAN_ID, Constants.MOTOR3);
        motor3 = new TitanQuad(Constants.TITAN_ID, Constants.MOTOR4);
    }

    /**
     * Sets the speed of the motor
     * <p>
     * @param speed range -1 to 1 (0 stop)
     */
    public void setMotorSpeed(double speed, double speed2, double speed3, double speed4)
    {
        motor.set(speed);
        motor1.set(speed2);
        motor2.set(speed3);
        motor3.set(speed4);
    }
}