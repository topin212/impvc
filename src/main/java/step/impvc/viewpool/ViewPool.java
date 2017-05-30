package step.impvc.viewpool;

import java.util.List;
import step.impvc.views.View;

/**
 *
 * created May 30, 2017
 */
public class ViewPool extends ObjectPool<View>{
    
    private List<View> viewList;

    public ViewPool(List<View> viewList) {
        this.viewList = viewList;
    }
    
    @Override
    public View getObject(int id) {
        return viewList.get(id);
    }

    @Override
    public void addObject(View view) {
        viewList.add(view);
    }
    
}
