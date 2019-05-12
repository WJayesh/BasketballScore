package com.example.jayeshsharma.basketballscore;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  implements  input.OnFragmentInteractionListener{


    int sa = 0;
    int sb = 0;
    int c,d,indicator;
    static String nameA="";
    static String nameB="";
    static ArrayList<data> dataArrayList=new ArrayList<data>();

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState!=null){
           nameA= savedInstanceState.getString("nameA");
           nameB=savedInstanceState.getString("nameB");
           c=savedInstanceState.getInt("c");
           d=savedInstanceState.getInt("d");
           sa=savedInstanceState.getInt("sa");
           sb=savedInstanceState.getInt("sb");
           displayA(sa);
           displayB(sb);
           TextView nA=(TextView) findViewById(R.id.teamA);
           nA.setText(nameA);
           TextView nB=(TextView) findViewById(R.id.teamB);
           nB.setText(nameB);
        }
        Intent in=getIntent();
        nameA=(nameA!=null)?in.getStringExtra("nameA"):"";
        nameB=(nameB!=null)?in.getStringExtra("nameB"):"";

     TextView nA=(TextView) findViewById(R.id.teamA);
     nA.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             indicator=1;
             getSupportFragmentManager().beginTransaction().add(R.id.container,input.newInstance(indicator,"Team A"),"input").commit();
         }
     });
     TextView nB=(TextView) findViewById(R.id.teamB);
     nB.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             indicator=2;
             getSupportFragmentManager().beginTransaction().add(R.id.container, input.newInstance(indicator,"Team B"),"input").commit();
         }
     });

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("nameA",nameA);
        outState.putString("nameB",nameB);
        outState.putInt("c",c);
        outState.putInt("d",d);
        outState.putInt("sa",sa);
        outState.putInt("sb",sb);
    }


    public void openHistory(View v){
        Intent in = new Intent(this,History.class);
        Bundle bundle=new Bundle();
        bundle.putSerializable("data", dataArrayList);
        in.putExtra("data", bundle);
        startActivity(in);
    }
    public void displayA(int n) {
        TextView score = (TextView) findViewById(R.id.scoreA);
        score.setText("" + n);
    }

    public void twoA(View view) {
        sa += 2;
        displayA(sa);
        c=2;
    }

    public void threeA(View view) {
        sa += 3;
        displayA(sa);
        c=3;
    }

    public void oneA(View v) {
        sa += 1;
        displayA(sa);
        c=1;
    }

    public void undoA(View v){
    if(c==1)
     sa-=1;
    else if(c==2)
        sa-=2;
    else if(c==3)
        sa-=3;
    displayA(sa);
    }

    public void displayB(int n) {
        TextView score = (TextView) findViewById(R.id.scoreB);
        score.setText("" + n);
    }

    public void twoB(View view) {
        sb += 2;
        displayB(sb);
        d=2;
    }

    public void threeB(View view) {
        sb += 3;
        displayB(sb);
        d=3;
    }

    public void oneB(View v) {
        sb += 1;
        displayB(sb);
        d=1;
    }

    public void undoB(View v){
        if(d==1)
            sb-=1;
        else if(d==2)
            sb-=2;
        else if(d==3)
            sb-=3;
        displayB(sb);
    }

    public void reset(View v) {
        sa = 0;
        sb = 0;
        displayA(sa);
        displayB(sb);
        TextView s1=(TextView) findViewById(R.id.scoreA);
        String scoreA=s1.toString();
        TextView s2=(TextView) findViewById(R.id.scoreB);
        String scoreB=s2.toString();
        save(nameA,nameB,scoreA,scoreB);
    }
    public void save(String t1,String t2, String s1, String s2){
        data d=new data(t1,s1,t2,s2);
        dataArrayList.add(d);
    }

}
