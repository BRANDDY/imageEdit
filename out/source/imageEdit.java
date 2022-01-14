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

public void setup() {
  
  startPage();
}

public void draw() {
}

public void startPage(){
  textSize(40);
  fill(255);
  text("Choose a picture", 30, 200);
  rect(150, 250, 100, 50);
}

public void mouseClicked(){
  if (150<mouseX&&mouseX<250&&250<mouseY&&mouseY<300){
    selectInput("Select a picture to process:", "fileSelected");
  }
}

public void fileSelected(File selection) {
  String type="null";
  if (selection == null) {
    println("Window was closed or the user hit cancel.");
    ////判断是否为图片
  }
  else {
    int i = selection.getName().indexOf(".");
    if (i>0){
      type = selection.getName().substring(i+1);
    }
    if(type == "jpg"||type == "png"){
      img = loadImage(selection.getName());
      image(img,0,0);
      println("in");
    }
  }
  println(type);
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
