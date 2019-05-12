package com.example.jayeshsharma.basketballscore;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link input.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link input#newInstance} factory method to
 * create an instance of this fragment.
 */
public class input extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";



    private String name;
    private int indicator;

    private OnFragmentInteractionListener mListener;

    public input() {
    }

    public static input newInstance(int indicator, String name) {
        input fragment = new input();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, indicator);
        args.putString("team",name);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            indicator = getArguments().getInt(ARG_PARAM1);
            name=getArguments().getString("team");
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_input, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView label=view.findViewById(R.id.name);
        label.setText(name);

        Button done=(Button) view.findViewById(R.id.button);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(indicator==1){
                    EditText editText=getView().findViewById(R.id.input);
                    String s=editText.getText().toString();
                    TextView textA=getActivity().findViewById(R.id.teamA);
                    textA.setText(s);
                    MainActivity.nameA=s;
                }
                if(indicator==2){
                    EditText editText=getView() .findViewById(R.id.input);
                    String s=editText.getText().toString();
                    TextView textB=getActivity().findViewById(R.id.teamB);
                    textB.setText(s);
                    MainActivity.nameB=s;
                }
                getActivity().getSupportFragmentManager().beginTransaction().remove(getFragmentManager().findFragmentById(R.id.container)).commit();
            }
        });
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
