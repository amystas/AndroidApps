package com.example.myapplication.ui.task5;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentTask5Binding;

import java.util.concurrent.atomic.AtomicInteger;

public class Task5Fragment extends Fragment {

    private Task5ViewModel mViewModel;
    private FragmentTask5Binding binding;

    public static Task5Fragment newInstance() {
        return new Task5Fragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = FragmentTask5Binding.inflate(inflater, container, false);
        View root = binding.getRoot();

        String[] descriptions = {
                "Sanrio characters posing together",
                "Sanrio characters on New Year's Eve",
                "Sanrio characters on a picnic",
                "Hello Kitty eating brunch",
                "Hello Kitty making pancakes",
                "Hello Kitty bathing",
                "Hello Kitty on her laptop"};

        AtomicInteger index = new AtomicInteger(1);
        binding.buttonPrev.setEnabled(false);
        binding.textView2.setText(descriptions[index.get() - 1]);

        binding.buttonNext.setOnClickListener(view -> {
            if(index.get() < 7) {
                binding.buttonPrev.setEnabled(true);
                index.getAndIncrement();
                binding.imageView4.setImageResource(getResources()
                        .getIdentifier("img" + index.toString(), "drawable", root.getContext().getPackageName()));
                binding.textView2.setText(descriptions[index.get() - 1]);
                if(index.get() == 7) {
                    binding.buttonNext.setEnabled(false);
                }
            }
        });

        binding.buttonPrev.setOnClickListener(view -> {
            if(index.get() > 1) {
                binding.buttonNext.setEnabled(true);
                index.getAndDecrement();
                binding.imageView4.setImageResource(getResources()
                        .getIdentifier("img" + index.toString(), "drawable", root.getContext().getPackageName()));
                binding.textView2.setText(descriptions[index.get() - 1]);
                if(index.get() == 1){
                    binding.buttonPrev.setEnabled(false);
                }
            }
        });

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(Task5ViewModel.class);
        // TODO: Use the ViewModel
    }

}