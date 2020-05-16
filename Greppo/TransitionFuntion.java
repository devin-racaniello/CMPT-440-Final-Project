package Greppo;


import java.util.ArrayList;

public class TransitionFuntion {

    // custom class which has data type
    // class has defined the type of data ArrayList
    // size of input 4
    int n = 3;

    // the custom datatype class
    public class Data {
        // global variables of the class
        String state;
        char alphabet;
        String goState;


        // constructor has type of data that is required
        Data(String state, char alphabet, String goState) {
            // initialize the input variable from main
            // function to the global variable of the class
            this.state = state;
            this.alphabet = alphabet;
            this.goState = goState;

        }
    }

    public ArrayList<Data> addValues(String[] state, char[] alphabet, String[] goState)
    {
        // local custom arraylist of data type
        // Data having (int, String, int, long) type
        // from the class
        ArrayList<Data> list=new ArrayList<>();

        for (int i = 0; i < state.length; i++)
        {
            // create an object and send values to the
            // constructor to be saved in the Data class
            list.add(new Data(state[i],alphabet[i],goState[i]));
        }

        // after adding values printing the values to test
        // the custom arraylist
        return list;
    }



}

