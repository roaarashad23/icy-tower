import javax.media.opengl.*;
public class Platform {
    private float x, y, width;

    public Platform(float x, float y, float width) {
        this.x = x;
        this.y = y;
        this.width = width;
    }

    public void render(GL gl) {
        gl.glPushMatrix();
        gl.glTranslatef(x, y, -5.0f);
        gl.glBegin(GL.GL_QUADS);
        gl.glVertex3f(-width / 2, 0.0f, 0.0f);
        gl.glVertex3f(width / 2, 0.0f, 0.0f);
        gl.glVertex3f(width / 2, 0.1f, 0.0f);
        gl.glVertex3f(-width / 2, 0.1f, 0.0f);
        gl.glEnd();
        gl.glPopMatrix();
    }
}
