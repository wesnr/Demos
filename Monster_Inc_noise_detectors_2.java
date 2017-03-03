import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import processing.sound.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Monster_Inc_noise_detectors_2 extends PApplet {


Amplitude amp;
AudioIn in;
float x=0;

public void setup() {
  
  background(255);
    
  // Create an Input stream which is routed into the Amplitude analyzer
  amp = new Amplitude(this);
  in = new AudioIn(this, 0);
  in.start();
  amp.input(in);
}      

public void draw() {
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
  public void settings() {  size(640, 360); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--stop-color=#cccccc", "Monster_Inc_noise_detectors_2" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
