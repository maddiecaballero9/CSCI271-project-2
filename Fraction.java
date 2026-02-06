/*************************************************************************
* Project 2 for CSCI 271-001 Spring 2026
*
* Author: MadelynReyes
* OS: 
* Compiler: java
* Date: feb 6, 2026
*
* Purpose
* This program deals with fractions in main i have examples and 
* in the class fractions i do the math has 6 main methods which 
* are add, subtract, multiply, divide, negate, pow. These use
* which does math between two different fractions. This program
* also does math for fraction that are whole number, negative 
* number, infinity and negative infinity
*************************************************************************/
/*******************************************************************
* I declare and confirm the following:
* - I have not discussed this program code with anyone other than my
* instructor or the teaching assistants assigned to this course.
* - I have not used programming code obtained from someone else,
* or any unauthorised sources, including the Internet, either
* modified or unmodified.
* - If any source code or documentation used in my program was
* obtained from other sources, like a text book or course notes,
* I have clearly indicated that with a proper citation in the
* comments of my program.
* - I have not designed this program in such a way as to defeat or
* interfere with the normal operation of the supplied grading code.
*
* <Madelyn Reyes>
********************************************************************/ 
/*******************************************************************
* i tried not to use a lot of if loops but most of the if loops 
* but i did use then to know if a number was negative or 
* positive but i tried to no use a much
* i also did use while and for loops this i did it mostly for 
* the remainder since that how you get to know which is 
* greatest common divisor of a number
********************************************************************/ 

class Fraction {
    private long numerator;
    private long denominator;
        
        public Fraction(long num, long denom){ //constructor for Fraction
           if (num == 0 && denom == 0) {   // this if statments checks
                numerator = 0;       // if that the number inputted is 0
                denominator = 0;    // sets numerator and denominator to 0
                return;
            }
            else if (num > 0 && denom == 0) {   // checks if numerator is postive
                numerator = 1;      // and if denominator is 0 if its true then its a infinity
                denominator = 0;    // infinity represented by 1/0
                return;
            }
            else if(num < 0 && denom == 0) {    // checks if numerator is negative 
                numerator = -1;       // and if denominatoris 0 if its true then its a infinity
                denominator = 0;    // but since its negative so its a -infintiy represented by -1/0
                return ;
            }
            long g = gcd(num, denom); // this is finding the biggest number 
            numerator = num/g;      // they can be divide by
            denominator = denom/g; // it reduces the fracton  
            if (denominator < 0 ) {  //denominatormust be postive
                numerator = -numerator;   // so we flip numerator
                denominator = -denominator; // and denominator
            }
        }
        
        public Fraction(long num){    // this constructor is for whole numbers
            numerator = num;        // this is the number
            denominator = 1;       // and the denominator makes it into fraction 
        }
        private long gcd(long a, long b) { // calculate greatest common divisor
            if (a < 0 ) {     //  if its negative we make it postive by
                a = -a;       // flipping the numerator
            }
            if (b < 0) {   // same thing for b 
                b = -b; // flipping denominator
            }
            while (b != 0) {  //repeat until remainder is 0
                long remainder = a % b;  //remainder 
                a = b;    // b to a example a= 12 and b=8 so a=8
                b = remainder;  // remainer to b and b = 4 the remainder
            }
            if (a == 0) {  // if the numerator and denominator is 0
                a = 1;   // then make it a one so it dont divde by 0
            }
            return a;
        }
        
        public long getNumerator() {  //getter for numerator
            return numerator;
        }
        
        public long getDenominator() {   //getter for denominator
            return denominator;
        }
        
        public Fraction add(Fraction f) { //so f means the other fraction so we have a/b and the other fraction would be c/d
            long num = numerator * f.denominator + f.numerator * denominator; //Cross multiply and then you add so a*d + c*b
            long denom = denominator * f.denominator; // Just multiply denominator by other denominator b*d
            return new Fraction(num, denom);  //return Fraction
        }
        
        public Fraction subtract(Fraction f) {
            long num = numerator * f.denominator - f.numerator * denominator; //Cross multiply and then you subtract so a*d - c*b
            long denom = denominator * f.denominator; //Just multiply denominator by other denominator b*d
            return new Fraction(num, denom);
        }
        
        public Fraction multiply(Fraction f) {
            long num = numerator * f.numerator; //multiply numerator a* c
            long denom = denominator * f.denominator; //multiply denominator b*d
            return new Fraction(num, denom);
        }
        
        public Fraction divide(Fraction f) {
            long num = numerator * f.denominator; // flip second fraction and multiply numerator by other function denominator a*d
            long denom = denominator * f.numerator; // multiply denominator by other function numerator b*c
            return new Fraction(num, denom);
        }
        
        public Fraction pow(int n) {
            if (n == 0) {          // if an is 0 then the ^ 0 is 1 so that 
                return new Fraction(1,1); // why we set this as 1
            }
            long num = numerator; 
            long denom = denominator;
            for (int i = 1; i < Math.abs(n); i++) { //multiply numerator and denominator and math.abs takes negtive num and return postive num
                num *= numerator;  // so the numerator power by n so numerator^n
                denom *= denominator; // same thing for denominator denominator^n
            }
            if (n < 0) {      //this means its a negtive num so we 
                return new Fraction(denom, num); // have to flip numerator and denominator
            }
            return new Fraction(num, denom); //return fraction to the power of n
        }
        
        public Fraction negate() {  //returns negative of this fraction
            return new Fraction(-numerator, denominator);  //flips the numerator
        }
        
        @Override
        public String toString() {
            if (numerator == 0 && denominator == 0) { // checks for nan
                return "NaN";
            }
            else if (numerator > 0 && denominator == 0) { // checks for Infinity
                return "Infinity";
            }
            else if(numerator < 0 && denominator == 0) { //checks for negative Infinity
                return "-Infinity";
            }
            return numerator + "/" + denominator; //returns a fraction 
        }
    
    public static void main (String[] args) {  // main for testing fractions
        Fraction a = new Fraction(16);  // used the math you had 
        Fraction b = new Fraction(3,5).add(new Fraction(7)); // to see if i got 
        Fraction c = new Fraction(6,7); // the math right 
        Fraction result = c.multiply(a.divide(b));  
        System.out.println("Results: " + result);
        
        System.out.println(new Fraction(8,-6)); // also from the project instuctions
        System.out.println(new Fraction(23,0)); // to make sure they do Infinity and 
        System.out.println(new Fraction(-6,0)); // negative Infinity
        System.out.println(new Fraction(7,1)); // also just regular fraction
        System.out.println(new Fraction(0,0)); // and nan
        System.out.println(new Fraction(7,20)); // added two extra just incase
        System.out.println(new Fraction(5,10));
        
    }
}
