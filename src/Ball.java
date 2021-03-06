import java.awt.*;

public class Ball extends Rectangle {
	double xComponent, yComponent;
	private final int player2ID = GameScreen.player2ID, baseSpeed = 5;
	private final double easyMultiplier = 0.25, hardMultiplier = 1.0;
	Ball(int x, int y) {
		super(x, y, 20, 20);
		xComponent = Math.random() > 0.5 ? baseSpeed - 1 + (2 * Math.random()) : -baseSpeed + 1 - (2 * Math.random());
		yComponent = Math.random() > 0.5 ? baseSpeed - 1 + (2 * Math.random()) : -baseSpeed + 1 - (2 * Math.random());
	}
	public void move() {
		x += xComponent;
		y += yComponent;
	}
	public void negateXComp() {
		xComponent *= -1;
		if (player2ID == 3) {
			xComponent += xComponent > 0 ? easyMultiplier : -easyMultiplier;
			yComponent += yComponent > 0 ? easyMultiplier : -easyMultiplier;
		} else if (player2ID == 4) {
			xComponent += xComponent > 0 ? Math.random() * hardMultiplier : Math.random() * -hardMultiplier;
			yComponent += yComponent > 0 ? Math.random() * hardMultiplier : Math.random() * -hardMultiplier;
		}
	}
	public void negateYComp() {
		yComponent *= -1;
	}
	public double getXComp() {
		return xComponent;
	}
	public void nudge () {
		double oldXC = xComponent, oldYC = yComponent;
		xComponent = x < 400 ? 5 : -5;
		yComponent = y < 5 ? 5 : y > 495 ? -5 : 0;
		move();
		xComponent = oldXC;
		yComponent = oldYC;
	}
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, width, height);
	}
}
