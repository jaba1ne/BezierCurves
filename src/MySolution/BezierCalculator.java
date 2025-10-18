package MySolution;

import java.awt.Point;
import java.util.List;

// P(t) = Σ [C(n,i) × (1-t)^(n-i) × t^i × P_i] - формула для одной точки на кривой
public class BezierCalculator {
    public static Point calculatePoint(List<Point> points, double t) {
        int n = points.size() - 1;
        if (n < 1)
            return null;

        double x = 0, y = 0;

        for (int i = 0; i <= n; i++) {
            // coef = C(n,i) × (1-t)^(n-i) × t^i
            double coef = binomialCoefficient(n, i) * Math.pow(1 - t, n - i) * Math.pow(t, i);
            Point p = points.get(i);
            x += coef * p.x;
            y += coef * p.y;
        }

        return new Point((int) x, (int) y);
    }

    private static double binomialCoefficient(int n, int k) {
        if (k < 0 || k > n) {
            return 0;
        }
        if (k == 0 || k == n) {
            return 1;
        }
        double result = 1;
        for (int i = 1; i <= k; i++) {
            result *= (double) (n - i + 1) / i;
        }
        return result;
    }
}
