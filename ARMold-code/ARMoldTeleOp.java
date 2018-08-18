package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by Prestolie on 1/29/2018.
 */

@TeleOp(name="competitionfinal",group="TeamBot")
public class ARMoldTeleOp extends LinearOpMode {

    public ARMoldHardware robot = new ARMoldHardware();


    @Override
    public void runOpMode() throws InterruptedException {

        robot.init(hardwareMap);

        waitForStart();

        while (opModeIsActive()) {
            armoldControls();
            // Wait for instructions
            idle();
        }
    }


    public void armoldControls(){
        boolean isX = gamepad1.x;
        boolean isA = gamepad1.a;
        boolean isY = gamepad1.y;
        boolean isB = gamepad1.b;
        boolean isUp = gamepad1.dpad_up;
        boolean isDown = gamepad1.dpad_down;
        double leftY = gamepad1.left_stick_y;
        double curWrist = robot.wrist.getPosition();

        // Control Shoulder
        if(Math.abs(leftY) > 0.06 && isA) {
            robot.shoulder.setPower(leftY);
        }
        else {
            robot.shoulder.setPower(0);
        }

        // Control Elbow
        if(isX && Math.abs(leftY)>0.05){
           robot.elbow.setPower(leftY);
        }
        else{
            robot.elbow.setPower(0);
        }
        if (isUp){
            robot.wrist.setPosition(curWrist + robot.servoInc);
        }
        if (isDown){
            robot.wrist.setPosition(curWrist - robot.servoInc);
        }
        if (isY){
            robot.claw.setPosition(0.5);
        }
        if (isB){
            robot.claw.setPosition(0.95);
        }
    }
}




//   // private void checkDriverControls() {
//      //  double rightY = gamepad1.right_stick_y;
//        double leftY = gamepad1.left_stick_y;
//
//        if(Math.abs(rightY) > 0.06) {
//            robot.FRmotor.setPower(rightY);
//            robot.RRmotor.setPower(rightY);
//        }
//        else {
//            robot.FRmotor.setPower(0);
//            robot.RRmotor.setPower(0);
//        }
//        if(Math.abs(leftY) > 0.06){
//            robot.FLmotor.setPower(leftY);
//            robot.RLmotor.setPower(leftY);
//        }
//        else {
//            robot.FLmotor.setPower(0);
//            robot.RLmotor.setPower(0);
//        }
//
