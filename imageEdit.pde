PImage img;
boolean startP = true;

void setup() {
  size(400,400,P2D);
  startPage();
}

void draw() {
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
    int i = selection.getName().indexOf(".");
    if (i>0){
      type = selection.getName().substring(i+1);
    }
    if(type == "jpg"||type == "png"){
      img = loadImage(selection.getName());
      image(img,0,0);
      startP = false;
      println("in");
    }else{
      println("Please choose jpg, png");
    }
  }
  println(type);
}

void saveImage(){
  save("xxx.png");
}
