/**
 * E/17/356
 * H.P.S UPEKHA
 * CO225 SOFTWARE CONSTRUCTION
 * PROJECT 1 : FRACTALS 
 
 */

public class Fractals {

    

    public static void main(String[] args) throws Exception{

        //variables
        double minReal=0,maxReal=0,minComplex=0,maxComplex=0;
        double realC=0,complexC=0;
        int iterations=0;
        
        
        //When required fractal type is not provided 
        if (args.length<1){            //if no arguments are provided
            System.out.println("\nRequired Fractal Type is not provided\n");
            usage();
            System.exit(1);        //exit from the program

        }


        //If the Fractal type is not given Correctly
        if( (!args[0].equals("Mandelbrot")) && (!args[0].equals("Julia")))
        {
            System.out.println("\nFractal type is not Correct\n");
            usage();
            System.exit(1);     //exit from the program
        }
        

        /******* MANDELBROT SET *******/
        if (args[0].equals("Mandelbrot")){


            //If the number of arguments are invalid
            if((args.length!=1) && (args.length!=5) && (args.length!=6)){
                
                System.out.println("\nInvalid Number of arguments\n");
                usage();
                System.exit(1);     //to exit from the program
            }
            else{

                //Default values for region of interest and iterations 
               if (args.length==1){
                   minReal=minComplex=-1;
                   maxComplex=maxReal=1;
                   iterations=1000;
                   
               }


               //Taking the region of interest from the arguments 
               else{
                   
                   try{
                   minReal=Double.parseDouble(args[1]);
                   maxReal= Double.parseDouble(args[2]);
                   minComplex=Double.parseDouble(args[3]);
                   maxComplex=Double.parseDouble(args[4]);
                   }
                   catch (Exception e){
                       System.out.println(e);        //if there are any exception
                       System.out.println("\nInvlaid Argument type\n");    
                        usage();
                        System.exit(1);     //to exit from the program
                    }

                    if (args.length==5){      
                        iterations=1000;      //default value for the number of iterations
                    }

                    //Taking the number of iterations from the arguments
                    else{
                       try{
                        iterations=Integer.parseInt(args[5]);
                       }
                       catch(Exception e){
                           System.out.println(e);    //If there are any exceptions
                           System.out.println("\nInvlaid Argument type\n");
                           usage();
                           System.exit(1);

                        }
                    }


               }
               
            System.out.println("minReal : "+minReal+"   maxReal :  "+maxReal+"   minComplex:  "+minComplex+"       maxComplex :   "+maxComplex+"  Itrearions : "+iterations);
            

            //Calling the function drawMandelbrotSet in MandelbrotSet
            MandelbrotSet.drawMandelbrotSet(minReal, maxReal, minComplex, maxComplex, iterations);
                }


        }

        /******* JULIA SET*** */
        else{
            
            //If there are invalid number of arguments
            if((args.length!=1) && (args.length!=3) && (args.length!=4) ){          

                System.out.println("\nInvalid Number of arguments\n");          
                usage();
                System.exit(1);     //To exit from the program
            
            }

            else{

                //regin of interest for julia set 
                minReal=minComplex=-1;
                maxReal=maxComplex=1;

                if (args.length==1){

                    //default values for realC , complexC and number of iterations
                    
                    iterations=1000;
                    realC=-0.4;
                    complexC=0.6;


                }
                else{

                    //To get the realC and complexC from arguments
                    
                    try{
                        realC=Double.parseDouble(args[1]);           //real part
                        complexC= Double.parseDouble(args[2]);       //complex part
                        
                        
                        
                    }
                    catch(Exception e){
                        System.out.println(e);            //if there is any exceptions
                        System.out.println("\nInvlaid Argument type\n");
                        usage();
                        System.exit(1);                   //to exit from the program
                    }

                    if (args.length==3){
                        iterations=1000;          //default number of iterations
                    }
                    else{

                    //to get the number of iterations from arguments 
                        try{
                            iterations=Integer.parseInt(args[3]);        
                           }
                           catch(Exception e){
                               System.out.println(e);                    //if there is  any exception
                               System.out.println("\nInvlaid Argument type\n");
                               usage();
                               System.exit(1);                           //to exit from the program
    
                            }
                    }
                    
                }

                
                System.out.println("minReal : "+minReal+"   maxReal :  "+maxReal+"   minComplex:  "+minComplex+"       maxComplex :   "+maxComplex+"  Itrearions : "+iterations+"   realC :  "+realC+"   complexC : "+complexC);
               
               
                //calling the drawJuliaSet function of the JuliaSet
                JuliaSet.drawJuliaSet(minReal,maxReal,minComplex,maxComplex,iterations, realC, complexC);
                
            }




        }

    }


    //Fuction to print the usage of the program when handling error conditions
    private static void usage() {
        System.out.println("\nUSAGE OF THE PROGRAM : \n\n");
        System.out.println("******** To get the Mandelbrot set *******\n");
        System.out.println("java Fractals Mandelbrot\n");
        System.out.println("java Fractals Mandelbrot <min.real value > <max.real value> <min.complex value> <max.complex value> <Iterations>\n");
        System.out.println("java Fractals Mandelbrot <min.real value > <max.real value> <min.complex value> <max.complex value>\n\n");

        
        System.out.println("******** To get the Julia set *******\n");
        System.out.println("java Fractals Julia\n");
        System.out.println("java Fractals Julia <realC> <complexC> <Iterations>\n");
        System.out.println("java Fractals Julia <realC> <complexC>\n\n");


    }
    
    
    
    


}
