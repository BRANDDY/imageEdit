import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class imageEdit extends PApplet {

PImage img;
boolean startP = true;

public void setup() {
  
  startPage();
}

public void draw() {
  if (! startP){
    image(img,0,0);
  }
}

public void startPage(){
  textSize(40);
  fill(255);
  text("Choose a picture", 30, 200);
  rect(150, 250, 100, 50);
}

public void mouseClicked(){
  if(startP){
    if (150<mouseX&&mouseX<250&&250<mouseY&&mouseY<300){
      selectInput("Select a picture to process:", "fileSelected");
    }
  }else{
    //save button
    saveImage();
  }
}

public void fileSelected(File selection) {
  String type="null";
  if (selection == null) {
    println("Window was closed or the user hit cancel.");
  }
  else {
    try {
      img = loadImage(selection.getAbsolutePath());
    } catch (Exception e) {
      println("in");
      println("Please choose jpg, png");
      println(e);
    }
    //image(img,0,0);
    startP = false;
  }
}

public void saveImage(){
  save("xxx.png");
}
  public void settings() {  size(400,400,P2D); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "imageEdit" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
