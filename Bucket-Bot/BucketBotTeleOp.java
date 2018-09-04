/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="Bucket Bot", group="Linear Opmode")
public class BucketBotTeleOp extends LinearOpMode {

    BucketBotHardware robot = new BucketBotHardware();

    @Override
    public void runOpMode() {

        robot.init(hardwareMap);

        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            // trying to move
            // Preston: This if statement could definitely be put into a function.
            if (Math.abs(gamepad1.left_stick_y) > 0.06 ||
               Math.abs(gamepad1.left_stick_x) > 0.06){
                if (gamepad1.left_stick_y > 0 ) {
                    robot.motors[1].setPower(gamepad1.left_stick_y);
                    robot.motors[3].setPower(gamepad1.left_stick_y);
                }
                else{
                    robot.motors[1].setPower(-gamepad1.left_stick_y);
                    robot.motors[3].setPower(-gamepad1.left_stick_y);
                }
                //strafing
                if (Math.abs(gamepad1.left_stick_x) > 0.06){
                    if (gamepad1.left_stick_x > 0){
                        robot.motors[0].setPower(gamepad1.left_stick_x);
                        robot.motors[2].setPower(gamepad1.left_stick_x);
                    }
                    else{
                        robot.motors[0].setPower(-gamepad1.left_stick_x);
                        robot.motors[2].setPower(-gamepad1.left_stick_x);
                    }
                }
            }
            //trying to rotate
            else if (Math.abs(gamepad1.right_stick_x) > 0.06){
                if (gamepad1.right_stick_x > 0) {
                    robot.motors[0].setPower(-gamepad1.right_stick_x);
                    robot.motors[2].setPower(gamepad1.right_stick_x);
                }
                else{
                    robot.motors[0].setPower(gamepad1.right_stick_x);
                    robot.motors[2].setPower(-gamepad1.right_stick_x);
                }
            }
            else {
                stopMove();
            }
            // Do robot things
            telemetry.update();
            idle();
        }
    }

    public void stopMove(){
        for (int i =0; i < 4; i++){
            robot.motors[i].setPower(0);
        }
    }
}
