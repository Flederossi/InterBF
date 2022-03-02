import java.util.Scanner;

public class InterBF {
    public static void main(String[] args){
        String prog = ">++++++++[<+++++++++>-]<.>++++[<+++++++>-]<+.+++++++..+++.>>++++++[<+++++++>-]<++.------------.>++++++[<+++++++++>-]<+.<.+++.------.--------.>>>++++[<++++++++>-]<+.";

        int progCount = 0;

        int[] mem = new int[30000];
        int pointer = 0;

        Scanner scn = new Scanner(System.in);

        int cOpen = 0;
        int cClose = 0;

        while (progCount < prog.length()){
            switch (String.valueOf(prog.charAt(progCount))){
                case ">":
                    pointer++;
                    if (pointer > mem.length){
                        pointer = 0;
                    }
                    break;
                case "<":
                    pointer--;
                    if (pointer < 0){
                        pointer = mem.length - 1;
                    }
                    break;
                case "+":
                    mem[pointer]++;
                    if (mem[pointer] > 255){
                        mem[pointer] = 0;
                    }
                    break;
                case "-":
                    mem[pointer]--;
                    if (mem[pointer] < 0){
                        mem[pointer] = 255;
                    }
                    break;
                case ".":
                    System.out.print((char)mem[pointer]);
                    break;
                case ",":
                    mem[pointer] = scn.next().charAt(0);
                    break;
                case "[":
                    if (mem[pointer] == 0){
                        cOpen = 0;
                        progCount++;
                        while (progCount < prog.length()){
                            String val = String.valueOf(prog.charAt(progCount));
                            if (val.equals("]") && cOpen == 0){
                                break;
                            }else if (val.equals("[")){
                                cOpen++;
                            }else if (val.equals("]")){
                                cOpen--;
                            }
                            progCount++;
                        }
                    }
                    break;
                case "]":
                    if (mem[pointer] != 0){
                        cClose = 0;
                        progCount--;
                        while (progCount >= 0){
                            String val = String.valueOf(prog.charAt(progCount));
                            if (val.equals("[") && cClose == 0){
                                break;
                            }else if (val.equals("]")){
                                cClose++;
                            }else if (val.equals("[")){
                                cClose--;
                            }
                            progCount--;
                        }
                    }
                    break;
            }
            progCount++;
        }
    }
}
