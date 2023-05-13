package com.example.bulksms.ui.group_creation;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.bulksms.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;


public class Group_creation<uri> extends Fragment {

    EditText groupNameEditText, groupDescriptionEditText;
    ImageView groupImageView;
    Button groupcreationButton;
    RecyclerView groupRecyclerView;

    Uri filepath;
    FirebaseAuth lauth;
    FirebaseFirestore lstore;
    FirebaseStorage lstorage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_group_creation, container, false);
        // Inflate the layout for this fragment
       groupNameEditText =view.findViewById(R.id.creategroup_groupNameEditText);
       groupDescriptionEditText =view.findViewById(R.id.creategroup_groupDescriptionEditText);
       groupImageView =view.findViewById(R.id.creategroup_groupImageImageView);
       groupcreationButton =view.findViewById(R.id.creategroup_createGroupButton);
       groupRecyclerView=view.findViewById(R.id.creategroup_groupsRecyclerView);

       lauth=FirebaseAuth.getInstance();
       lstore=FirebaseFirestore.getInstance();
       lstorage=FirebaseStorage.getInstance();

        ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == getActivity().RESULT_OK) {
                        Intent data = result.getData();
                        filepath = data.getData();
                        groupImageView.setImageURI(filepath);
                    }
                }
        );
        groupImageView.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            activityResultLauncher.launch(intent);
        });

        return view;
    }

}
