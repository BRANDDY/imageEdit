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
File se;
boolean a = false;
PGraphics pg;

public void setup(){
  
  pg = createGraphics(400, 400);
}

public void draw(){
  if(img != null){
    image(img, 0,0);
  
    noStroke();
    ellipse(mouseX, mouseY, 60, 60);
    pg.beginDraw();
    pg.stroke(255);
    pg.ellipse(mouseX, mouseY, 60, 60);
    pg.endDraw();    
    image(pg, 0, 0); 
    }
  if(a){
    save(se.getAbsolutePath()+".png");
    a=false;
  }
}

public void keyPressed(){
  if(keyCode == UP){
     selectInput("Select a picture to process:", "fileSelected");
  }
  if(keyCode == DOWN){
     selectOutput("Select a picture to save:", "fileSave");
  }
}

public void fileSelected(File selection) {
  if (selection == null) {
    println("Window was closed or the user hit cancel.");
  }
  else {
    try{
      img = loadImage(selection.getAbsolutePath());
    }catch(Exception e){
    }
    finally{
      if (img == null){
    println("out");
        selectInput("Select a picture to process:", "fileSelected");
      }
    }
  }
}

public void fileSave(File selection){
  if (selection == null) {
    println("Window was closed or the user hit cancel.");
  }
  else {
    se = selection;
    a=true;
  }
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
