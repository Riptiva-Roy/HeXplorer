#include<SoftwareSerial.h>
#include<Servo.h>

char data;
SoftwareSerial bluetooth(12, 13);

Servo front; // this controls the front legs of the hexapod
Servo middle; // this controls the middle legs of the hexapod
Servo back; // this controls the back legs of the hexapod

void zeroset() // to initialise the positions of the servos to 'neutral'
{
  front.write(90);
  middle.write(90);
  back.write(90);
  delay(400);

}

void forward()
{
  front.write(60);
  middle.write(120);
  back.write(60);

  delay(400);

  // setting the the servos to their neutral position so all the legs are in their 'natural' position
  front.write(90);
  middle.write(90);
  back.write(90);

  front.write(120);
  middle.write(60);
  back.write(120);

  middle.write(120); //this lifts up the middle leg
  delay(400);

  front.write(60); // this causes the legs on the left side to move forward
  back.write(60);
  delay(400);

  middle.write(90); //this is the 0th/neutral position again
  delay(400);
  middle.write(40); // now the middle leg is lifted to the other side
  delay(400);

  front.write(90); //forward and backward legs are back to their neutral position
  back.write(90); // this makes the robot move forward 1 step
  delay(400);

  middle.write(90);
  delay(400);

}
void backward()
{
  middle.write(120); //this lifts up the middle leg
  delay(400);
  front.write(120);
  back.write(120);
  delay(400);

  middle.write(90); //0th/neutral position
  delay(400);
  middle.write(60);
  delay(400);

  front.write(90);
  back.write(90);
  delay(400);

  middle.write(90);
  delay(400);
}

void Stop()
{
  front.write(90);
  middle.write(90);
  back.write(90);
  delay(400);
}

void setup() {
  Serial.begin(9600);

  front.attach(9);
  middle.attach(10);
  back.attach(11);
  zeroset();
  Serial.begin(9600); // starting serial communication between arduino and the device its connected too
  BT.begin(9600);
}

void loop() {

  while (bluetooth.available()) // will continuously check whether the bluetooth module is receiving data

  {
    data = bluetooth.read();
    Serial.println(data);
  }

  if (data == 'f') // these are the values that will be sent when controlling the app I coded for controlling the hexapod

  {
    forward();
  }

  if (data == 'b')

  {
    backward();

    if (data == 'S')

    {
      Stop();
    }

  }


}
