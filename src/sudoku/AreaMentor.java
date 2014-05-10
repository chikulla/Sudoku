package sudoku;

import java.awt.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by che on 2014/05/08.
 * AreaMentor tells you Point of area containing "?"
 *   |0 1 2|3 4 5|6 7 8|
 *  --------------------
 *  1|* * *|* * *|* * *|
 *  2|* * *|* * *|* * *|
 *  3|* * *|* * *|* * *|
 *  --------------------
 *  4|* * *|* * *|* * *|
 *  5|* * *|* * *|* * *|
 *  6|* * *|* * *|* ? *|
 *  --------------------
 *  7|* * *|* * *|* * *|
 *  8|* * *|* * *|* * *|
 *  9|* * *|* * *|* * *|
 *  I'm not ASCII Art painter.
 */
public class AreaMentor {
    private static final Set<Integer> area1;
    private static final Set<Integer> area2;
    private static final Set<Integer> area3;
    static{
        area1 = new HashSet<Integer>();
        area2 = new HashSet<Integer>();
        area3 = new HashSet<Integer>();
        area1.addAll(Arrays.asList(0,1,2));
        area2.addAll(Arrays.asList(3,4,5));
        area3.addAll(Arrays.asList(6,7,8));
    }
    public Set<Point> sameArea(int x,int y){
        Set<Point> result = new HashSet<Point>();
        Set<Integer> areax = getArea(x);
        Set<Integer> areay = getArea(y);
        for(Integer px:areax){
            for(Integer py:areay){
                result.add(new Point(px,py));
            }
        }
        //I'm worried to remove argument point or not
        result.remove(new Point(x,y));
        return result;
    }
    private Set<Integer> getArea(int i){
        if(area1.contains(i)){
            return area1;
        }else if(area2.contains(i)){
            return area2;
        }else if(area3.contains(i)){
            return area3;
        }else{
            throw new IllegalArgumentException("arg must falls 0<=i<=8");
        }
    }
}
