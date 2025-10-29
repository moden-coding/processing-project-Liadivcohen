import processing.core.*;

public class App extends PApplet {
    // ball
    float circleX, circleY;

    // high score
    float highscore = 0;

    // padle
    float heroy = 415;
    float herox = 50;
    float herow = 200;
    float heroh = 50;
    float speed = 3;

    boolean left, right;

    // game start
    float ballHit = 0;
    float score = 0;
    float scene = 1;

    float velocityY; // vertical speed
    float velocityX; // horizontal speed
    float accelration;
    float speedMultiplier = 1; // speed

    public static void main(String[] args) {
        PApplet.main("App");
    }

    public void setup() {
        textSize(25);
        accelration = .1f;
        resetGame();

        left = false;
        right = false;

    }

    public void settings() {
        size(500, 500);
    }

    public void draw() {
        

        if (scene == 1) {
            gameplay();
            text("Bounce: " + score, 0, 50);
            text("Circle Speed = " + speedMultiplier, 0, 75);

        } else if (scene == 2) {
            background(0);
            text("Game over", 50, 250);
            text("Press space bar to play again", 50, 285);
            text ("highscore: " + highscore,50, 315);
        }

        if (left == true && herox > 0) {
            herox -= 10;

        }
        if (right == true && herox < width - herow) {
            herox += 10;

        }
        if (score > highscore){
            highscore = score;
        }

    }

    public void gameplay() {
        background(100);
        velocityY += accelration;
        circleY += velocityY;
        circleX += velocityX;

        if (circleY <= 0) { // Means the ball went off of the top of the screen
            velocityY = abs(velocityY); // abs = absolute value, makes the ball go down once it hits the top, if sign
                                        // was -5 it becomes 5, if was 5 it stays as 5
        }
        if (circleX <= 0 || circleX >= width) { // Checking if the ball hit the side
            velocityX = -velocityX; // If it did than change the direction of the ball, does this by changing the
                                    // sign

        }

        if (circleY >= heroy && circleX >= herox && circleX <= herox + herow) { // if it doesn't touch padel, then just
                                                                                // go off the screen

            ballHit += 1; // increases bounce count
            velocityX = random(-3, 3); // Everytime it hits padel, it chooses a random number between -3, 3

            println("bounce");
            velocityY = -10 * speedMultiplier;
            if (ballHit % 3 == 0) {
                speedMultiplier += 0.2; // Everytime ball gets to a multiple of five bounces it increases the speed by
                                        // 0.2
            }
            println(score);
            score++;

        }
        if (score >= 500){
            if (score > highscore){
                highscore = score;
            }
        }

        if (circleY >= 500) {
            scene = 2; 
        }

       

        circle(circleX, circleY, 30);
        rect(herox, heroy, herow, heroh);

    }

    public void keyPressed() {

        if (keyCode == LEFT) {
            left = true;
        }
        if (keyCode == RIGHT) {
            right = true;

        }

        if (key == ' ') {
            scene = 1;
            resetGame();

        }
    }

    public void keyReleased() {
        if (keyCode == LEFT) {
            left = false;

        }
        if (keyCode == RIGHT) {
            right = false;

        }

    }

    public void resetGame() {
        circleX = 250;
        circleY = 250;
        velocityY = 0;
        velocityX = 0;
        speedMultiplier = 1;
        herox = 50;
        heroy = 415;
        score = 0;

    }
}
