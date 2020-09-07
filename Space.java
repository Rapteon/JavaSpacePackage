//AUTHOR: rapteon; DATE: 20200309
//Small class to use for printing somewhat formatted tabular data.

public class Space{
    static final char verticalLine = '\u2502';
    static final char horizontalLine = '\u2500';
    static final char topLeftCorner = '\u256D';
    static final char topRightCorner = '\u256E';
    static final char bottomRightCorner = '\u256F';
    static final char bottomLeftCorner = '\u2570';
    static final char warning = '\u2639';
    static final char lightShadeBlock = '\u2591';
    static final String littleSpace = "  ";     //Two spaces.
    void sleepingLine(int width){
        for(int i = 0; i < width; i++)
            System.out.printf("%c", horizontalLine);
    }
    
    void standingLine(int distanceFromCursor){
        for(int i = 0; i < distanceFromCursor; i++)
            System.out.print(" ");      //Moves right by a single space.
        System.out.printf("%c", verticalLine);
    }
    
    void printSpaces(int n){
        for(int i = 0;i < n; i++)
            System.out.print(" ");
    } 
    void printHeading(int width, String heading){
        System.out.printf("%c", topLeftCorner);
        sleepingLine(heading.length()/2+1);
        System.out.print(heading);
        sleepingLine(width-heading.length());      //Printing the remaining width.
        System.out.printf("%c\n", topRightCorner);
    }
    
    int numOfDigits(int n){
        int num = 0;
        String s = ""+n;
        num = s.length();
        return num;
    }
    void menu(String heading, String[] options){
        int maxWidth = 0, spacesForNum = 0;
        int optionCount = options.length;
        if(options.length == 0){
            System.out.println("Cannot make a box with no options.");
            return;
        }
        spacesForNum = numOfDigits(optionCount);
        maxWidth = options[0].length();
        for(int i = 0; i < options.length; i++){
            if(options[i].length() > maxWidth)
                maxWidth = options[i].length();
        }
        // System.out.println("MaxWidth: "+maxWidth);
        printHeading(maxWidth, heading);
        int i = 0;  //Used to print the index of array item.
        for(String s : options){
            System.out.printf("%c", verticalLine);      //left vertical line of table.
            System.out.printf("%d", i++);
            spacesForNum = numOfDigits(i);
            printSpaces(spacesForNum);
            System.out.print(s);
            System.out.println("");
        }
        System.out.printf("%c", bottomLeftCorner);
        sleepingLine(1);
        System.out.println("");
        
        //Printing option suggestions.
        System.out.print("[");
        for(int j = 0; j < i; j++)
            System.out.print(""+j+"/");
        System.out.print("\b]?\n");
        inputBar();
    }
    
    void inputBar(){
        System.out.printf("%c%c ", lightShadeBlock, lightShadeBlock);
    }
    void askQuestion(String question){
        System.out.println(question);
        inputBar();
        
    }

    void ArrayPrinter(int[] array){
        printHeading(array.length, "Array");
        for(int i = 0; i < array.length; i++)
            System.out.print(""+array[i]+"|");
        System.out.println("\b ");  //Removing last pipe character and moving cursor to newline.
    }
}