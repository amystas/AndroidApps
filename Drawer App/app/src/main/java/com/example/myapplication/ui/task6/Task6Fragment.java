package com.example.myapplication.ui.task6;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentTask2Binding;
import com.example.myapplication.databinding.FragmentTask6Binding;

import java.util.ArrayList;

public class Task6Fragment extends Fragment {

    private Task6ViewModel mViewModel;
    private FragmentTask6Binding binding;
    private ArrayList<String> listToView;

    public static Task6Fragment newInstance() {
        return new Task6Fragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
            binding = FragmentTask6Binding.inflate(inflater, container, false);
            View root = binding.getRoot();

            listToView = new ArrayList<>();

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.custom_list_item, R.id.item_text, listToView) {
                @NonNull
                @Override
                public View getView(int position, View convertView, ViewGroup parent) {
                    if (convertView == null) {
                        LayoutInflater inflater = LayoutInflater.from(getContext());
                        convertView = inflater.inflate(R.layout.custom_list_item, parent, false);
                    }

                    TextView text = convertView.findViewById(R.id.item_text);
                    Button remove = convertView.findViewById(R.id.remove_button);

                    text.setText(getItem(position));
                    remove.setOnClickListener(v -> {
                        listToView.remove(position);
                        notifyDataSetChanged();
                    });

                    return convertView;
                }
            };

            // Attach the adapter to the ListView
            binding.listView.setAdapter(adapter);

            // Set the listener for the addButton
            binding.addButton.setOnClickListener(view -> {
                String item = binding.editTextText.getText().toString();
                if (!item.isEmpty()) {
                    listToView.add(item);
                    adapter.notifyDataSetChanged();
                }
            });

            return root;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(Task6ViewModel.class);
        // TODO: Use the ViewModel
    }

}