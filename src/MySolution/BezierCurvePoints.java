package MySolution;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class BezierCurvePoints {
    private List<Point> points = new ArrayList<>();

    public void addPoint(Point point) {
        points.add(point);
    }

    public void clear() {
        points.clear();
    }

    public void removeLastPoint() {
        if (points.size() > 0) {
            points.remove(points.size() - 1);
        }
    }

    public List<Point> getPoints() {
        return new ArrayList<>(points);
    }

    public boolean hasEnoughPoints() {
        return points.size() >= 2;
    }
}