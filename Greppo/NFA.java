package Greppo;

import java.util.ArrayList;

public class NFA {
    String[] states;
    String alphabet;
    TransitionFuntion tf = new TransitionFuntion();
    ArrayList<TransitionFuntion.Data> myTF=new ArrayList<>();
    String initialState;
    String[] finalStates;

    public NFA(String[] states, String alphabet,  ArrayList<TransitionFuntion.Data> myTF, String initialState, String[] finalStates){
        this.states = states;
        this.alphabet = alphabet;
        this.myTF = myTF;
        this.initialState = initialState;
        this.finalStates = finalStates;
    }

    @Override
    public String toString() {
        String output = "";
        output += states.toString();
        output += alphabet;
        output += myTF.toString();
        output += initialState;
        output += finalStates.toString();
        return output;
    }

    public boolean doesAccept(String in) {
        String currentState = initialState;



        for (int i = 0; i < in.length(); i++) {
            for (int j = 0; j < finalStates.length; j++) {
                if (finalStates[j].equals(currentState)){
                    return true;
                }
            }
            currentState = moveState(currentState,in.charAt(i));
            if (currentState.equals("fail")){
                return false;
            }

        }


        return false;


    }

    public String moveState(String currentState,char letter){
        String state = currentState;
        for (int i = 0; i < myTF.size(); i++) {

            if (myTF.get(i).state == currentState){
                if(myTF.get(i).alphabet == letter){
                    return myTF.get(i).goState;
                }
            }

        }

        return "fail";
    }





}
