package step.impvc.views;

/**
 *
 * created May 30, 2017
 */
public abstract class DefaultView implements View{

    private String template;
    
    @Override
    public void broadCastUserInteraction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void setTemplate(String template){
        this.template = template;
    }
    
    @Override
    public void show(Object obj){
        System.out.println(String.format(template, obj.toString()));
    }
    
}
