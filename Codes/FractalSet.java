
//importing
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import java.awt.Canvas;

public class FractalSet extends Canvas {

    public static final int WIDTH = 800;      //Width of the Canvas
    public static final int HEIGHT = 800;     //Height of the Canvas

    static BufferedImage buffer;
    static BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

    double minX, maxX, minY, maxY;
    int iteration;


    //This constructor is used When using Mandelbrot set
    public static void drawFractal(double minX, double maxX, double minY, double maxY, int iteration) {
        buffer = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_BGR);

        //taking a point in the cnvas
        for (int x = 0; x < WIDTH; x++)         
            for (int y = 0; y < HEIGHT; y++) {

                //Mapping a point on the Canvas on to a point in the region of interest
                
                double newX = (((double) x * (maxX - minX)) / WIDTH) + minX;
                double newY = (((double) y * (maxY - minY)) / HEIGHT) + minY;

                //To get the colour of the point
                int color = calculatePoint(newX, newY, iteration, newX, newY);

                //Assign colours to those points
                buffer.setRGB(x, y, color);
                image.setRGB(x, y, color);

            }

    }

    // this constructor is used when using Julia set

    public static void drawFractal(double minX, double maxX, double minY, double maxY, int iteration, double realC,double ComplexC) {
        buffer = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_BGR);
       
        //taking a point in the cnvas
        for (int x = 0; x < WIDTH; x++)
            for (int y = 0; y < HEIGHT; y++) {

                 //Mapping a point on the Canvas on to a point in the region of interest

                double newX = (((double) x * (maxX - minX)) / WIDTH) + minX;
                double newY = (((double) y * (maxY - minY)) / HEIGHT) + minY;

                //To get the colour of the point

                int color = calculatePoint(newX, newY, iteration, realC, ComplexC);


                //Assign colours to those points
                buffer.setRGB(x, y, color);
                image.setRGB(x, y, color);

            }

    }
    //To get the Graphics

    public void paint(Graphics g) {

        g.drawImage(buffer, 0, 0, null);

    }


    //Function to get the colour of the point

    public static int calculatePoint(double x, double y, int iteration, double cx, double cy) {
        

        int i = 0;
        for (; i < iteration; i++) {
            double new_x = x * x - y * y + cx;      //real part of the complex number 
            double new_y = 2 * x * y + cy;          //Imaginary part of the complex number 

            

            x = new_x;
            y = new_y;

            if (x * x + y * y > 4)     //abs(z) >2
                break;

        }

        //if C is a Mandelbrot number 
        if (i == iteration) {        

            return 0x000000; // black
        } 
        
        //If C is not a Mandelbrot Number 
        else {


            /*** 
            //OTHER COLOUR PATTERNS

            // return 0xff14;
            
            // return 0x8a2be2/(i+1);
            *****/

            //Colour Pattern
            float saturation = 1f;
            float Hue = (i % 256) / 255.0f;
            Color colorCode = Color.getHSBColor((float) Hue, saturation, 1f);
            return colorCode.getRGB();

        }
    }

    //To get the frame
    public static void getFrame(String name) {

        JFrame frame = new JFrame(name);       //Name of the frame 
        Canvas canvas = new FractalSet();      //creating a canvas
        canvas.setSize(WIDTH, HEIGHT);   //Size of the canvas
        frame.add(canvas);               //Adding the canvas to the frame
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);           //Exit


        //To get the output as a image file 
        try {
            ImageIO.write(image, "png", new File("output.png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
         

        }
   

}



