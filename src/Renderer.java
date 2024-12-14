import javax.media.opengl.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public  class Renderer implements GLEventListener , KeyListener {
    private Player player;
    private PlatformManager platformManager;

    public Renderer() {
       player = new Player();
       platformManager = new PlatformManager();
    }
    public void init(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);

        player.update();
        platformManager.update();

        player.render(gl);
        platformManager.render(gl);
    }
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL gl = drawable.getGL();

        float aspect = (float) width / (float) height;
        float fovy = 45.0f;  // Field of view in degrees
        float near = 1.0f;
        float far = 100.0f;

        // Calculate the height and width of the near clipping plane
        float top = (float) Math.tan(Math.toRadians(fovy / 2)) * near;
        float bottom = -top;
        float right = top * aspect;
        float left = -right;

        gl.glViewport(0, 0, width, height);

        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();

        // Set up the perspective view using glFrustum
        gl.glFrustum(left, right, bottom, top, near, far);

        gl.glMatrixMode(GL.GL_MODELVIEW);


    }


    @Override
    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {}

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        char key = Character.toLowerCase(e.getKeyChar());
        player.keyPressed(key);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        char key = Character.toLowerCase(e.getKeyChar());
        player.keyReleased(key);
    }
}
