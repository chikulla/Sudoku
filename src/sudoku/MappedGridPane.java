package sudoku;

import javafx.scene.layout.GridPane;

import java.awt.Point;
import java.util.*;

/**
 * Created by che on 2014/04/25.
 */
public class MappedGridPane extends GridPane implements GridPaneAccessor {
    //intでいいからawt.Point
    private final Map<Point, NumberInputField> map = new HashMap<Point, NumberInputField>();
    private final AreaMentor areaMentor = new AreaMentor();

    public void add(NumberInputField node, int x, int y) {
        super.add(node, x, y);
        map.put(new Point(x, y), node);
    }

    public NumberInputField get(int x, int y) {
        return map.get(new Point(x, y));
    }

    @Override
    public Set<Point> getPointAbout(int n) {
        Set<Point> points = new HashSet<Point>();
        for (Point p : map.keySet()) {
            if (map.get(p).getNumber() == n) {
                points.add(p);
            }
        }
        return points;
    }

    @Override
    public int getNumber(int x, int y) {
        return get(x, y).getNumber();
    }

    @Override
    public boolean isInitialValue(int x, int y) {
        return get(x, y).isInitialValue();
    }

    @Override
    public Set<Integer> getRow(int y) {
        Set<Integer> result = new HashSet<Integer>();
        for (int x = 0; x < 9; x++) {
            if (!isBlank(x, y)) {
                result.add(get(x, y).getNumber());
            }
        }
        return result;
    }

    @Override
    public Set<Integer> getColumn(int x) {
        Set<Integer> result = new HashSet<Integer>();
        for (int y = 0; y < 9; y++) {
            if (!isBlank(x, y)) {
                result.add(get(x, y).getNumber());
            }
        }
        return result;
    }

    @Override
    public Set<Integer> getSameArea(int x, int y) {
        Set<Integer> result = new HashSet<Integer>();
        Set<Point> points = areaMentor.sameArea(x, y);
        for (Point p : points) {
            if (!isBlank(p.x, p.y)) {
                result.add(get(p.x, p.y).getNumber());
            }
        }
        return result;
    }

    @Override
    public Set<Point> getBlank() {
        Set<Point> points = new HashSet<Point>();
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                if (isBlank(x, y)) {
                    //TODO: create factory of "Point"
                    points.add(new Point(x, y));
                }
            }
        }
        return points;
    }

    @Override
    public boolean isBlank(int x, int y) {
        return (get(x, y).getNumber()==0);
    }

    @Override
    public void put(int n, int x, int y){
        if(n<1||n>9){
            throw new IllegalArgumentException("number must fall within 1<=num<=9");
        }
        get(x,y).setNumber(n);
    }

    @Override
    public void clear(int x, int y){
        get(x,y).clear();
    }


}
