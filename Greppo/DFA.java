package Greppo;

import java.util.ArrayList;

public class DFA {
    String[] states;
    String alphabet;
    TransitionFuntion tf = new TransitionFuntion();
    ArrayList<TransitionFuntion.Data> myTF=new ArrayList<>();
    String initialState;
    String[] finalStates;

    public DFA(String[] states, String alphabet,  ArrayList<TransitionFuntion.Data> myTF, String initialState, String[] finalStates){
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
            currentState = moveState(currentState,in.charAt(i));
            if (currentState.equals("fail")){
                return false;
            }

        }
        for (int j = 0; j < finalStates.length; j++) {
            if (finalStates[j].equals(currentState)){
                return true;
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

    public boolean isDFA(){


        //each state must have one transition for each alphabet
        int[] stateCounter = new int[states.length];
        boolean stateCheck = false;
        for (int i = 0; i < myTF.size(); i++) {
            stateCheck = false;
            //need to add a check for adding more than one of a letter to your delta

            if (!alphabet.contains(String.valueOf(myTF.get(i).alphabet))){
                System.out.println("alph");
                return false;
            }


            for (int j = 0; j < states.length; j++) {
                if(states[j].equals(myTF.get(i).state)){
                    stateCheck = true;
                    stateCounter[j]+= 1;
                    if (stateCounter[j] > alphabet.length()){
                        return false;
                    }
                }
                System.out.println(states[j]+myTF.get(i).state);
            }
            if (!stateCheck){
                System.out.println("sc");
                return false;
            }

        }
        return true;
    }





}
