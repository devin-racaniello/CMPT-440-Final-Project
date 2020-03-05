package Greppo;
import java.util.Scanner;
import java.util.Stack;

//java RegexFilter '^(0|1(01*0)*1)*$'

//(0|1(01*0)*1)*
//*start
//0|1(01*0)*1
//0|1(01*0)*1
//0 spec done
//1(01*0)*1
//1 done
//(01*0)*1
//* start
//0 done
//1* done
//0 done
//*finish
//1 done
//*finish





public class Project {
    public static void main(String[] args){
        Scanner regIn = new Scanner(System.in);
        System.out.println("Enter username");

        String regex = regIn.nextLine();
        String regTrim = "";

        boolean inReg = false;

        //Cuts down the input to whats within the ''
        for(int j = 0; j <= regex.length(); j++){

            char checker = regex.charAt(j);

            if (checker=="'".charAt(0)){
                if (!inReg){
                    inReg = true;
                } else {
                    inReg = false;
                    break;
                }

            }
            if (inReg){
                regTrim += checker;
            }
        }

        Stack parens = new Stack();
        char check = '0';

        for(int i = 0; i <= regTrim.length(); i++){
            check = regTrim.charAt(i);

            if (parens.empty()){
                if (check == '(') {
                    parens.push(i);
                } if(check == '*') {
                    //excecute * code
                } else if(check == '|'){

                } else {

                }




            } else {
                if (check == ')') {
                    parens.pop();
                    //make a grouping

                }
            }






        }


    }

    public static string parens() {


    }


}
