import javax.media.opengl.*;
import com.sun.opengl.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {

    public static void main(String[] args) {

        // Create the OpenGL canvas
        GLCanvas canvas = new GLCanvas();

        // Main frame setup
        JFrame frame = new JFrame("Icy Tower");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Main panel to organize the layout
        JPanel panel = new JPanel(new BorderLayout());

        // Right-side panel to hold buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setBackground(Color.LIGHT_GRAY);

        // Create buttons
        JButton Play = new JButton("Play");
        JButton Instruction = new JButton("Instruction");
        JButton Profile = new JButton("Profile");
        JButton HighScore = new JButton("High Score");
        JButton Sound = new JButton("Sound");
        JButton Exit = new JButton("Exit");

        // Set button sizes (game-style)
        Dimension buttonSize = new Dimension(150, 60);
        Play.setPreferredSize(buttonSize);
        Instruction.setPreferredSize(buttonSize);
        Profile.setPreferredSize(buttonSize);
        HighScore.setPreferredSize(buttonSize);
        Sound.setPreferredSize(buttonSize);
        Exit.setPreferredSize(buttonSize);

        // Set button background color to bright yellow
        Color brightYellow = new Color(255, 255, 0);  // Bright yellow color
        Play.setBackground(brightYellow);
        Play.setOpaque(true);
        Play.setBorderPainted(false);

        Instruction.setBackground(brightYellow);
        Instruction.setOpaque(true);
        Instruction.setBorderPainted(false);

        Profile.setBackground(brightYellow);
        Profile.setOpaque(true);
        Profile.setBorderPainted(false);

        HighScore.setBackground(brightYellow);
        HighScore.setOpaque(true);
        HighScore.setBorderPainted(false);

        Sound.setBackground(brightYellow);
        Sound.setOpaque(true);
        Sound.setBorderPainted(false);

        Exit.setBackground(brightYellow);
        Exit.setOpaque(true);
        Exit.setBorderPainted(false);

        // Add buttons to the button panel
        buttonPanel.add(Play);
        buttonPanel.add(Box.createVerticalStrut(10));  // Space between buttons
        buttonPanel.add(Instruction);
        buttonPanel.add(Box.createVerticalStrut(10));
        buttonPanel.add(Profile);
        buttonPanel.add(Box.createVerticalStrut(10));
        buttonPanel.add(HighScore);
        buttonPanel.add(Box.createVerticalStrut(10));
        buttonPanel.add(Sound);
        buttonPanel.add(Box.createVerticalStrut(10));
        buttonPanel.add(Exit);

        // Attach ActionListeners to buttons
        Play.addActionListener(new Main());
        Instruction.addActionListener(new Main());
        Profile.addActionListener(new Main());
        HighScore.addActionListener(new Main());
        Sound.addActionListener(new Main());
        Exit.addActionListener(new Main());

        // Place the canvas and button panel in the main panel
        panel.add(canvas, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.EAST);

        frame.add(panel);
        frame.setVisible(true);

        // Set up the OpenGL renderer
        Renderer renderer = new Renderer();
        canvas.addGLEventListener(renderer);

        Animator animator = new Animator(canvas);
        animator.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand() + " button clicked!");
    }
}
