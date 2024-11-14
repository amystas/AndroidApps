package com.example.myapplication.ui.task4;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentHomeBinding;
import com.example.myapplication.databinding.FragmentTask2Binding;
import com.google.android.material.snackbar.Snackbar;

public class Task4Fragment extends Fragment {

    private Task4ViewModel mViewModel;
    private FragmentTask2Binding binding;

    public static Task4Fragment newInstance() {
        return new Task4Fragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentTask2Binding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.ID3.setOnClickListener(view -> {
            if(binding.ID2.getText().length() > 0) {
                if (binding.ID5.isChecked()) {
                    Toast.makeText(root.getContext(), binding.ID2.getText(), Toast.LENGTH_SHORT).show();
                } else {
                    Snackbar.make(root.getRootView(), binding.ID2.getText(), Snackbar.LENGTH_LONG).show();
                }
            } else {
                if (binding.ID5.isChecked()) {
                    Toast.makeText(root.getContext(), "NIE WPISANO TEKSTU", Toast.LENGTH_SHORT).show();
                } else {
                    Snackbar.make(root.getRootView(), "NIE WPISANO TEKSTU", Snackbar.LENGTH_LONG).show();
                }
            }
        });

        //return inflater.inflate(R.layout.fragment_task2, container, false);
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(Task4ViewModel.class);
        // TODO: Use the ViewModel
    }

}