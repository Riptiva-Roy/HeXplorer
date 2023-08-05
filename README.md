# HeXplorer

#Hexapod robot (Arduino)

This project contains the code for a hexapod robot, a 6-legged walking creature that mimics an insect-like gait. The robot's movements are controlled using Bluetooth communication.

Video of motion:
https://www.youtube.com/watch?v=sqbBWBNbRG4

**Final product**

![b7caaba2-44ac-4abb-8c7f-fee48c8f4a15](https://github.com/x-Bloodlust-x/Hexapod-robot-Arduino-/assets/127997008/6b334b80-2a11-49a8-93eb-3cf015e22223)



![4a8e2017-d47d-417b-90fc-344944dfb6d2](https://github.com/x-Bloodlust-x/Hexapod-robot-Arduino-/assets/127997008/fb0896cd-5150-447a-af53-79546eb4afe2)


**Description**: The hexapod robot is controlled through a custom mobile application that sends commands to the robot via Bluetooth. The robot is capable of moving forward and backward using its six legs.

**Hardware Requirements**

Arduino board (e.g., Arduino Uno)

6x Servo motors (e.g., SG90)

HC-05 Bluetooth module

Power supply for the Arduino and servos

**Libraries Used**

SoftwareSerial - for Bluetooth communication

Servo - for controlling the servo motors

**Wiring**: The connections for the servos and Bluetooth module should be made as follows:

Bluetooth TX  -> Arduino Pin 12

Bluetooth RX  -> Arduino Pin 13

Servo 1 (front) -> Arduino Pin 9

Servo 2 (middle) -> Arduino Pin 10

Servo 3 (back) -> Arduino Pin 11

**Functions**

zeroset(): Initializes the positions of the servos to a neutral position.

forward(): Moves the hexapod forward in an insect-like gait.

backward(): Moves the hexapod backward in an insect-like gait.

Stop(): Stops the movement of the hexapod and resets all servos to the neutral position.

**Setup and Usage**

Upload the provided Arduino code to the Arduino board using the Arduino IDE.

Connect the hardware as per the wiring instructions above.

Power up the hexapod robot and ensure the Bluetooth module is properly paired with the controlling device (e.g., smartphone).

Use the custom mobile application to control the hexapod's movement. Send 'f' to move forward, 'b' to move backward, and 'S' to stop.

**Note**: Please ensure that you handle the hexapod robot with care and operate it in a safe environment, away from obstacles and other potential hazards.

Some pictures of the late process (I built the frame myself using strips of aluminium that had holes, and the chassis by forging 2 central holes)

![095b691e-d285-41ea-abe1-3439eee5a609](https://github.com/x-Bloodlust-x/Hexapod-robot-Arduino-/assets/127997008/fac3a9f9-a10e-4bd5-9ff4-7e0e5023a866)

![3f2a56b9-9137-4899-bfd3-5e111ce419bc](https://github.com/x-Bloodlust-x/Hexapod-robot-Arduino-/assets/127997008/85d78968-ce61-4e84-88db-b746da15492f)


