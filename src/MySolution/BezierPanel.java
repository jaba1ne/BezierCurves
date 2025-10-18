package MySolution;

import javax.swing.*;
import java.awt.*;
import java.util.List;

// панель для отрисовки
public class BezierPanel extends JPanel {
    private BezierCurvePoints bezierCurvePoints;

    public BezierPanel(BezierCurvePoints pointManager) {
        this.bezierCurvePoints = pointManager;
        setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        setupRenderingHints(g2);

        if (bezierCurvePoints.hasEnoughPoints()) {
            drawBezierCurve(g2);
        }

        drawControlPointsAndLines(g2);
    }

    // сглаживание краев
    private void setupRenderingHints(Graphics2D g2) {
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
    }


    private void drawBezierCurve(Graphics g) {
        g.setColor(Color.BLUE);
        List<Point> points = bezierCurvePoints.getPoints();

        Point prev = BezierCalculator.calculatePoint(points, 0);
        for (int i = 1; i <= 200; i++) {
            double t = i / 200.0;
            Point current = BezierCalculator.calculatePoint(points, t);

            if (prev != null && current != null) {
                g.drawLine(prev.x, prev.y, current.x, current.y);
            }
            prev = current;
        }
    }

    private void drawControlPointsAndLines(Graphics g) {
        List<Point> points = bezierCurvePoints.getPoints();

        // рисуем линии между контрольными точками
        g.setColor(Color.GRAY);
        for (int i = 0; i < points.size() - 1; i++) {
            Point p1 = points.get(i);
            Point p2 = points.get(i + 1);
            g.drawLine(p1.x, p1.y, p2.x, p2.y);
        }

        // рисуем контрольные точки
        for (int i = 0; i < points.size(); i++) {
            Point p = points.get(i);
            if (i == 0)
                g.setColor(Color.GREEN);      // первая точка - зеленая
            else if (i == points.size() - 1)
                g.setColor(Color.RED);        // последняя точка - красная
            else
                g.setColor(Color.BLACK);      // остальные - черные

            g.fillOval(p.x - 5, p.y - 5, 10, 10);
        }
    }
}