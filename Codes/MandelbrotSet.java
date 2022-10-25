//Class to get the Mandelbrot set

public class MandelbrotSet extends FractalSet {
   
    public static void drawMandelbrotSet(double minX,double maxX,double minY,double maxY,int iteration) {

        
        new MandelbrotSet(minX, maxX, minY, maxY,iteration);

    }
    
    
    public MandelbrotSet(double minX,double maxX,double minY,double maxY,int iteration) {

        drawFractal(minX, maxX, minY, maxY,iteration);    //to get the fractal 
        getFrame("Mandelbrot Set");       //to get the frame 
       
        repaint();
       
    }
    
}

