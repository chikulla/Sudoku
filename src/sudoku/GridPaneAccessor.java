package sudoku;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by che on 2014/05/07.
 */
public interface GridPaneAccessor {
    public Set<Point> getPointAbout(int n);
    public int getNumber(int x, int y);
    public boolean isInitialValue(int x, int y);
    public Set<Integer> getRow(int y);
    public Set<Integer> getColumn(int x);
    public Set<Integer> getSameArea(int x, int y);
    public Set<Point> getBlank();
    public boolean isBlank(int x, int y);
    public void put(int n,int x, int y);
    public void clear(int x,int y);

}
