# -Fractals-

##Introduction
Design and implement a software that would plot two of the most
popular fractals: Mandelbrot set and Julia set. 
Fractals are infinity many, self-similar shapes formed by some simple mathematical computations. The
computation varies from fractal set to set but are generally based on complex numbers. 

### Generating the image: 
We have a area (with some dimension) to plot the pattern. This area will
contain pixels and will be fixed for 800x800 pixels. For each point you need to see if the point is in the
set specified by the user and assign colour accordingly. 

### Program
program accept arguments; at least one which would specify what set to plot. If
the set selected is Mandelbrot the user should give either 0, 4 or 5 arguments. If there are 0 arguments
then use the default values as specified in the table below. 4 arguments will be the region of interest in
the complex plane and the 5th one is the number of iterations to do for a point. 
For the Julia set the user should give 0 or 2 arguments. If there are no arguments one should use the
default arguments and 2 arguments will be the real and complex part for C.
