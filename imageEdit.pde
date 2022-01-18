PImage img;
File se;
boolean a = false;

void setup(){
  size(400,400,P2D);
}

void draw(){
  if(img != null){
    image(img,0,0);
  }
  if(a){
    save(se.getAbsolutePath()+".png");
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

void startPage(){
  textSize(40);
  fill(255);
  text("Choose a picture", 30, 200);
  rect(150, 250, 100, 50);
}
