package MySolution;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Input {
    private final BezierCurvePoints bezierCurvePoints;

    public Input(BezierCurvePoints pointManager) {
        this.bezierCurvePoints = pointManager;
    }

    public MouseAdapter createMouseAdapter(Runnable repaintAll) {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // левая кнопка мыши - добавить точку
                if (SwingUtilities.isLeftMouseButton(e) || SwingUtilities.isRightMouseButton(e)) {
                    bezierCurvePoints.addPoint(e.getPoint());
                }

                // вызываем перерисовку
                repaintAll.run();
            }
        };
    }

    public KeyAdapter createKeyAdapter(Runnable clearAll, Runnable removeLast) {
        return new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                // клавиша 'F' - очистить все точки
                if (e.getKeyCode() == KeyEvent.VK_F) {
                    clearAll.run();
                }
                // клавиша 'E' - удалить последнюю точку
                else if (e.getKeyCode() == KeyEvent.VK_E) {
                    removeLast.run();
                }
            }
        };
    }
}