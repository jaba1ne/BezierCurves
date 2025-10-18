package MySolution;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;


public class BezierCurvePoints {
    private List<Point> points = new ArrayList<>();

    public void addPoint(Point point) {
        points.add(point);
    }

    public void removeNearestPoint(Point click, double maxDistance) {
        if (points.isEmpty()) return;

        // Находим ближайшую точку
        Point nearest = points.get(0);
        double minDist = click.distance(nearest);

        for (int i = 0; i < points.size(); i++) {
            Point p = points.get(i);
            double dist = click.distance(p);
            if (dist < minDist) {
                minDist = dist;
                nearest = p;
            }
        }

        // Удаляем если клик достаточно близко
        if (minDist < maxDistance) {
            points.remove(nearest);
        }
    }

    // очистка всех точек
    public void clear() {
        points.clear();
    }

    public List<Point> getPoints() {
        return new ArrayList<>(points);
    }

    public boolean hasEnoughPoints() {
        return points.size() >= 2;
    }

    public int getPointCount() {
        return points.size();
    }
}