package Calc;

public class CC {
    
    double answer = 0;

    public CC(long num1, char operator, long num2){
        switch (operator) {
            case '-':
                answer = num1-num2;
            case '+':
                answer = num1+num2;
            case '/':
                answer = num1/num2;
            case '*':
                answer = num1*num2;
            case '^':
                answer = Math.pow(num1, num2);
        }
    }
    public CC(byte angle, byte trig_pref){

        //Constructor for Trionometry functions
        //Using Math.cos Math.tan and Math.sin();

        switch (trig_pref) {
            case 1:
                //cos
                answer = Math.cos(angle);
            case 2:
                //tan
                answer = Math.tan(angle);
            case 3:
                //sin
                answer = Math.sin(angle);
        }
    }
    public CC(long num, boolean SqRt){
        //Constructor For Square Root
        if(SqRt == true) {
            answer = Math.sqrt(num);
        }
    }

    public double getAnswer(){
        return answer;
    }

}
