package sudoku;

/**
 * Created by che on 2014/05/07.
 */
public class Solver {
    private final GridPaneAccessor accessor;
    int x =0;
    int y =0;
    public Solver(GridPaneAccessor accessor){
        this.accessor = accessor;
    }

    public void solve() {
        if(accessor.getBlank().isEmpty()){
            return;
        }
        if(!accessor.isBlank(x, y)){
            next();
        }else{
            for(int n=1;n<=9;n++){
                if(puttable(n, x, y)){
                    accessor.put(n,x,y);
                    next();
                }else if(n==9){
                    accessor.clear(x,y);
                    prev();
                }
            }
        }
    }
    private void prev(){
        if(x==0){
            if(y==0){
                //never reach here please
            }else{
                y--;
                x=8;
            }
        }else{
            x--;
        }
    }
    private void next(){
        if(x==8){
            if(y==8){
                // never reach here please
                return;
            }else{
                y++;
                x=0;
            }
        }else{
            x++;
        }
        solve();
    }

    public boolean puttable(int n, int x, int y){
        if(accessor.getSameArea(x,y).contains(n)){
            return false;
        }else if(accessor.getColumn(x).contains(n)){
            return false;
        }else if(accessor.getRow(y).contains(n)){
            return false;
        }else{
            return true;
        }
    }
}
