function setup() {
  createCanvas(400, 400);
}
  
function draw() {
  background(0,0,140);
    
  // circle
  strokeWeight(4);
  stroke(225);      //makes outline white
  fill("green");
  ellipse(200,200,190);
    
  // star
  fill(225,0,0);    //stroke is the same
  beginShape();
  vertex(200, 103); //top point
  vertex(220, 165); //right shoulder (clockwise points)
  vertex(290, 165); //right top point
  vertex(235, 205); //right hip
  vertex(260, 275); //right bottom point
  vertex(200, 230); //bottom indent
  vertex(140, 275); //left bottom point
  vertex(165, 205); //left hip
  vertex(110, 165); //left top point
  vertex(177, 165); //left shoulder
  vertex(200, 103); //top point
  endShape();
   
  describe('green circle in the middle of a blue background with a red star over it');
}