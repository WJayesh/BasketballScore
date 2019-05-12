package com.example.jayeshsharma.basketballscore;

import java.io.Serializable;

public class data  implements Serializable {
    String t1,t2;
    String s1,s2;
    public data(String  T1, String S1, String T2, String S2 ){
        t1=T1;t2=T2;s1=S1;s2=S2;
    }
    public String getScoreA(){
        return s1;
    }
    public String getScoreB(){
        return s2;
    }
    public String getNameA(){
        return t1;
    }
    public String getNameB(){
        return t2;
    }
}
