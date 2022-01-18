PImage img;
File se;
boolean a = false;
PGraphics pg;

void setup(){
  size(400,400,P2D);
  pg = createGraphics(400, 400);
}

void draw(){
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
    pg.save(se.getAbsolutePath()+".png");
    a=false;
  }
}

void keyPressed(){
  if(keyCode == UP){
     selectInput("Select a picture to process:", "fileSelected");
  }
  if(keyCode == DOWN){
     selectOutput("Select a picture to save:", "fileSave");
  }
}

void fileSelected(File selection) {
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

void fileSave(File selection){
  if (selection == null) {
    println("Window was closed or the user hit cancel.");
  }
  else {
    se = selection;
    a=true;
  }
}

