package org.firstinspires.ftc.teamcode;

import android.graphics.Color;
import android.text.method.Touch;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.I2cAddr;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.SwitchableLight;
import com.qualcomm.robotcore.hardware.TouchSensor;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;

/**
 * Created by Shelby Goss on 9/28/2017.
 */

public class ARMoldHardware {

    public DcMotor shoulder = null;
    public DcMotor elbow = null;
    public Servo wrist = null;
    public Servo claw = null;
    public double servoInc = 0.0025;

    HardwareMap hwMap = null;


    public ARMoldHardware() { // Constructor
    }

    public void init(HardwareMap ahwMap){

        //save reference to hwMap
        hwMap = ahwMap;

        shoulder = hwMap.get(DcMotor.class, "SH");
        elbow = hwMap.get(DcMotor.class, "EL");
        wrist = hwMap.get(Servo.class, "W");
        claw = hwMap.get(Servo.class, "C");

        shoulder.setPower(0);
        elbow.setPower(0);
        wrist.setPosition(0.1);
        claw.setPosition(0.93);

        shoulder.setDirection(DcMotorSimple.Direction.REVERSE);
        elbow.setDirection(DcMotorSimple.Direction.REVERSE);

        shoulder.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        elbow.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


    }
}
