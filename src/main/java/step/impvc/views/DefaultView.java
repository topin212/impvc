package step.impvc.views;

/**
 *
 * created May 30, 2017
 */
public abstract class DefaultView implements View{

    public static View getDefaultView(){
        return new DefaultView(){
                @Override
                public void show(){
                    System.out.println("Hello World");
                }
            };
    }
    
    @Override
    public void broadCastUserInteraction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void show(){
        
    }
    
}
