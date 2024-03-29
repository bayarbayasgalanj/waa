package websocket;

public class Calculator {
    public String calc(String input){
        if(input.contains("+")) {
            String[] calculation = input.split("\\+");
            int value1= Integer.parseInt(calculation[0]);
            int value2= Integer.parseInt(calculation[1]);
            int result = add(value1, value2);
            return input+" = "+result;
        }
        else if(input.contains("-")) {
            String[] calculation = input.split("-");
            int value1= Integer.parseInt(calculation[0]);
            int value2= Integer.parseInt(calculation[1]);
            int result = subtract(value1, value2);
            return input+" = "+result;
        }
        return "";
    }
    public int add(int x, int y){
        return x+y;
    }

    public int subtract(int x, int y){
        return x-y;
    }
}
