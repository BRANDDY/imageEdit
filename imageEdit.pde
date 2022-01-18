PImage img;
boolean startP = true;

void setup() {
  size(400,400,P2D);
  startPage();
}

void draw() {
  if (! startP){
    image(img,0,0);
  }
}

void startPage(){
  textSize(40);
  fill(255);
  text("Choose a picture", 30, 200);
  rect(150, 250, 100, 50);
}

void mouseClicked(){
  if(startP){
    if (150<mouseX&&mouseX<250&&250<mouseY&&mouseY<300){
      selectInput("Select a picture to process:", "fileSelected");
    }
  }else{
    //save button
    saveImage();
  }
}

void fileSelected(File selection) {
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

void saveImage(){
  save("xxx.png");
}
