//Class to get the Julia Set


public class JuliaSet extends FractalSet {
   
	
    public static void drawJuliaSet(double minX,double maxX,double minY,double maxY,int iteration,double realC,double complexC) {

        
        new JuliaSet(minX, maxX, minY, maxY,iteration,realC,complexC);

    }
    
    //Function JuliaSet
    public JuliaSet(double minX,double maxX,double minY,double maxY,int iteration,double realC,double complexC) {
       
        drawFractal(minX, maxX, minY, maxY,iteration,realC,complexC);    //to draw the Fractal
        getFrame("Julia Set");                            //To get the frame 

        repaint();
    }	
}

