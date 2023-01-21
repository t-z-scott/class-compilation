function setup() {
  createCanvas(400, 200);
}
  
function draw() {
  background(0);
  noStroke();
    
  //pac-man
  let c = color(210,200,30);
  fill(c);
  ellipse(100,100,160);
  beginShape(TRIANGLES);
  fill(0);
  vertex(25, 35);
  vertex(100, 100);
  vertex(15, 160);
  endShape();
    
  //red ghost
  c = color(255,0,0);
  fill(c);
  rect(210,15,170,170,80,80,0,0);
  //whites of the eyes
  fill(255);
  ellipse(255,90,50);
  ellipse(335,90,50);
  //irises
  c = color(0,0,255);
  fill(c);
  ellipse(255,91,30);
  ellipse(335,91,30);
  
  describe('pac-man and blinky on a black background');
}