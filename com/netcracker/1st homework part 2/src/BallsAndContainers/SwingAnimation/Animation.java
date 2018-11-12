package BallsAndContainers.SwingAnimation;

import BallsAndContainers.MyBalls.Ball;
import BallsAndContainers.MyContainers.Container;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Animation {
    private JFrame mainFrame = new JFrame("Box and ball emulator");
    private Container box;
    private Ball ball;
    private ArrayList<JLabel> containsLabel = new ArrayList<>();
    private ArrayList<JButton> buttons = new ArrayList<>();
    private ArrayList<JTextField> textFields = new ArrayList<>();

    public Animation(Container box, Ball ball) {
        this.box = box;
        this.ball = ball;
        setSwing();
    }

    private void setSwing() {
        ContainerAndBallAnimation containerAndBallAnimation = new ContainerAndBallAnimation();

        JPanel parametersPanel = new JPanel();

        Box boxForLabels = new Box(BoxLayout.Y_AXIS);
        containsLabel.add(new JLabel(box.toString()));
        containsLabel.add(new JLabel(ball.toString()));
        containsLabel.add(new JLabel(box.contains(ball) ? "Container contains the ball" : "Container doesn't contain the ball"));
        boxForLabels.add(containsLabel.get(0));
        boxForLabels.add(containsLabel.get(1));
        boxForLabels.add(containsLabel.get(2));

        JPanel setsPanel = new JPanel();
        setsPanel.setBorder(new TitledBorder("settings"));
        buttons.add(new JButton("Set speed"));
        buttons.get(0).addActionListener(containerAndBallAnimation);
        textFields.add(new JTextField(5));
        buttons.add(new JButton("Set direction in degrees"));
        buttons.get(1).addActionListener(containerAndBallAnimation);
        textFields.add(new JTextField(5));
        setsPanel.add(buttons.get(0));
        setsPanel.add(textFields.get(0));
        setsPanel.add(buttons.get(1));
        setsPanel.add(textFields.get(1));

        JButton moveButton = new JButton("Move");
        moveButton.addActionListener(containerAndBallAnimation);

        parametersPanel.add(boxForLabels);
        parametersPanel.add(setsPanel);
        parametersPanel.add(moveButton);

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        mainFrame.setSize(screen.width*2/3,screen.height*2/3);
        mainFrame.setVisible(true);
        mainFrame.getContentPane().add(containerAndBallAnimation);
        mainFrame.getContentPane().add(parametersPanel, BorderLayout.SOUTH);
    }

    class ContainerAndBallAnimation extends JPanel implements ActionListener {

        @Override
        protected void paintComponent(Graphics g) {
            mainFrame.repaint();
            g.setColor(Color.red);
            g.drawRect(box.getX(), box.getY(), box.getWidth(), box.getHeight());
            g.setColor(Color.GREEN);
            g.fillOval((int)ball.getX() - ball.getRadius(), (int)ball.getY() - ball.getRadius(), 2*ball.getRadius(), 2*ball.getRadius());
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();
            if (source.equals(buttons.get(0))) {
                ball.setVelocityAndDirection(Integer.parseInt(textFields.get(0).getText()), ball.getDirection());
            } else if (source.equals(buttons.get(1))) {
                ball.setVelocityAndDirection(ball.getVelocity(), Integer.parseInt(textFields.get(1).getText()));
            } else {
                ball.move();
                containsLabel.get(0).setText(box.toString());
                containsLabel.get(1).setText(ball.toString());
                containsLabel.get(2).setText(box.contains(ball) ? "Container contains the ball" : "Container doesn't contain the ball");
                repaint();
            }
        }
    }
}
