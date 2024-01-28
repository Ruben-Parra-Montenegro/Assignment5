## How to use in the command line 
I designed this program to be used by passing arguments through the command line.

when the size of the argument is 2 it will read the matrices in the text files and multiply them and write them into a matrix3.txt file.

When passing the arguments, they have to be named data/matrix1.txt and data/matrix2.txt when being passed and have to be in that order.

Here is the way to run it so it reads from matrix1 and matrix2 text files:

java --enable-preview -jar Assignment5.jar data/matrix1.txt data/matrix2.txt


The 1 argument progam makes 2 random matrices that change size depending on the input of the number into the command line seen below.It will print the matices and write the matrices into their folders after multipying them to equal matrix3

When wanting to run the program when passing 1 argument you have to run type this into the command line:

 java --enable-preview -jar Assignment5.jar 3

 the "3" at the end of this is the size of the matrix.

## How to use in a run.bat file 

java --enable-preview -jar Assignment5.jar 3
PAUSE

 the "3" at the end of this is the size of the matrix.

or 

java --enable-preview -jar Assignment5.jar data/matrix1.txt data/matrix2.txt
PAUSE

uses the text files

## How to run in a Launch.json file 

{
    "version": "0.2.0",
    "configurations": [
        {
            "type": "java",
            "name": "App",
            "request": "launch",
            "mainClass": "App",

INCLUDE ONE OF THESE 

             "args": ["data/matrix1.txt","data/matrix2.txt" ],

             OR 

            "args": ["4"],

The number decides the size of the matrix 

            "projectName": "Assignment5_f4b85c4d",
            // Remove the "classpath" property
        }
    ]
}


## When running "run without debugging"

it will pass the arguments through the Launch.json file

DEPENDING ON IF THE ARGUMENT IS 1 OR 2 THE MATRIX3 WILL BE WRITTEN TO 1 OF THE 2 "matrix3.txt" FILES IN HERE.   
