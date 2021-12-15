package com.example.project401_java;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ComplainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ComplainFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "Description";
    private static final String ARG_PARAM2 = "State";

    // TODO: Rename and change types of parameters
    private String mDescription;
    private String mState;

    public ComplainFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param mDescription Parameter 1.
     * @param mState Parameter 2.
     * @return A new instance of fragment ComplainFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ComplainFragment newInstance(String mDescription, String mState) {
        ComplainFragment fragment = new ComplainFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, mDescription);
        args.putString(ARG_PARAM2, mState);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mDescription = getArguments().getString(ARG_PARAM1);
            mState = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_complain2, container, false);
    }
}