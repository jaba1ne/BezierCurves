package MySolution;

import javax.swing.*;

public class Main extends JFrame {
    private BezierCurvePoints bezierCurvePoints;
    private BezierPanel bezierPanel;
    private Input input;

    public Main() {
        initializeComponents();
        setupUI();
        setupEventHandlers();
    }

    private void initializeComponents() {
        bezierCurvePoints = new BezierCurvePoints();
        bezierPanel = new BezierPanel(bezierCurvePoints);
        input = new Input(bezierCurvePoints);
    }


    private void setupUI() {
        setTitle("Кривые Безье");
        setSize(1500, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        add(bezierPanel);
        setFocusable(true);
    }


    private void setupEventHandlers() {

        bezierPanel.addMouseListener(
                input.createMouseAdapter(() -> bezierPanel.repaint())
        );

        addKeyListener(
                input.createKeyAdapter(
                        () -> { // очистка всех точек
                            bezierCurvePoints.clear();
                            bezierPanel.repaint();
                        },
                        () -> { // удаление последней точки
                            bezierCurvePoints.removeLastPoint();
                            bezierPanel.repaint();
                        }
                )
        );
    }

    public static void main(String[] args) {
        Main window = new Main();
        window.setVisible(true);
    }
}
