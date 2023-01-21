function setup() {
  createCanvas(400, 400);
}

function draw() {
  background(225);             // bg set to white
  noStroke();                  // gets rid of the shape outlines
    
  //top circle
  let c = color(225,140,160,200);
  fill(c);
  ellipse(200,150,180);
  
  //bottom right
  c = color(100,225,110,160);
  fill(c);
  ellipse(260,240,180);
  
  //bottom left
  c = color(121,50,255,160);
  fill(c);
  ellipse(140,240,180);
  
  describe('three circles in a venn diagram. colors: pink, purple, and green');
}