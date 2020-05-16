package Greppo;

import java.util.ArrayList;

public class grepp {
    public static void main(String[] args){
        String[] states = {"q0","q1"};
        String alphabet = "ab";
        TransitionFuntion tf = new TransitionFuntion();
        ArrayList<TransitionFuntion.Data> myTF=new ArrayList<>();

        String tfStates[] = {"q0","q0","q1","q1"};
        char tfAlphabet[] = {'a','a','a', 'b'};
        String tfEndStates[] = {"q1","q0","q1","q0"};

        myTF = tf.addValues(tfStates,tfAlphabet,tfEndStates);

        String initialState = "q0";
        String[] finalStates = {"q1"};
        DFA example = new DFA(states,alphabet,myTF,initialState,finalStates);

        System.out.println(example.isDFA());
        System.out.println(example.doesAccept("abaaa"));

    }
}
