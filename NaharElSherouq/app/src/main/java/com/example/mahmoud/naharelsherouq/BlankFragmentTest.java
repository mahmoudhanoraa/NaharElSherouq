package com.example.mahmoud.naharelsherouq;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragmentTest extends Fragment {


    public BlankFragmentTest() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        String k = "koko";
//        getFragmentManager().popBackStack(k, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        return inflater.inflate(R.layout.fragment_blank_fragment_test, container, false);
    }

}
