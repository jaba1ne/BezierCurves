package MySolution;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class BezierCurvePoints {
    private List<Point> points = new ArrayList<>();

    //добавляем точки
    public void addPoint(Point point) {
        points.add(point);
    }

    // очистка всех точек
    public void clear() {
        points.clear();
    }

    // удаление последней точки
    public void removeLastPoint() {
        if (points.size() > 0) {
            points.remove(points.size() - 1);
        }
    }

    public List<Point> getPoints() {
        return new ArrayList<>(points);
    }

    // проверка можно ли построить кривую (2 нужно точки)
    public boolean hasEnoughPoints() {
        return points.size() >= 2;
    }
}