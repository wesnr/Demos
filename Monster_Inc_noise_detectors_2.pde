import processing.sound.*;
Amplitude amp;
AudioIn in;
float x=0;

void setup() {
  size(640, 360);
  background(255);
    
  // Create an Input stream which is routed into the Amplitude analyzer
  amp = new Amplitude(this);
  in = new AudioIn(this, 0);
  in.start();
  amp.input(in);
}      

void draw() {
   //draws yellow surface
  fill(255,220,20);
  rect(150,0,200,400);
  //draws top horizantal and bottomline
  fill(0,0,0);
  rect(150,20,200,10);
  rect(150,325,200,10);
  //measures noice level and prints it
  println(amp.analyze()*500);
  fill(255,0,0);
  rect(200,50,100,250);
 //draws noise level
  fill(0,0,0);
  rect(200,50,100,250-(amp.analyze()*500));
  textSize(32);
  text("Monster Inc", 400,200);
}