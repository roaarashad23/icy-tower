import javax.media.opengl.GL;

public class Player {
    private float x = 0.0f;
    private float y = 0.0f;
    private float gravity = -0.01f;  // Gravity pulling the player down
    private float jumpStrength = 0.5f;
    private float velocityY = 0.0f;

    // Movement flags
    private boolean leftPressed = false;
    private boolean rightPressed = false;
    private boolean upPressed = false;

    // For simplicity, assume the platform y-coordinate is fixed
    private float platformY = -5.0f;

    // Update player position based on movement flags and gravity
    public void update() {
        if (leftPressed)  x -= 1.0f;  // Default horizontal speed of 1.0f
        if (rightPressed) x += 1.0f;  // Default horizontal speed of 1.0f

        // Apply gravity
        velocityY += gravity;
        y += velocityY;

        // Simulate platform collision (simplified)
        if (y <= platformY) {
            y = platformY;
            velocityY = 0.0f;  // Stop falling when landing on a platform
        }

        if (upPressed) {
            velocityY = jumpStrength;
            upPressed = false;  // Reset jump flag
        }
    }

    // Render the player character
    public void render(GL gl) {
        gl.glPushMatrix();
        gl.glTranslatef(x, y, -5.0f);

        gl.glBegin(GL.GL_QUADS);
        gl.glVertex3f(-0.5f, -0.5f, 0.0f);
        gl.glVertex3f(0.5f, -0.5f, 0.0f);
        gl.glVertex3f(0.5f, 0.5f, 0.0f);
        gl.glVertex3f(-0.5f, 0.5f, 0.0f);
        gl.glEnd();

        gl.glPopMatrix();
    }

    // Handle key pressed events
    public void keyPressed(int key) {
        switch (key) {
            case 'a': leftPressed = true; break;
            case 'd': rightPressed = true; break;
            case 'w': upPressed = true; break;
        }
    }

    // Handle key released events
    public void keyReleased(int key) {
        switch (key) {
            case 'a': leftPressed = false; break;
            case 'd': rightPressed = false; break;
        }
    }
}
