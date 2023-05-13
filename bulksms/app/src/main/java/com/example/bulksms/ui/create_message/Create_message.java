package com.example.bulksms.ui.create_message;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.bulksms.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;


public class Create_message extends Fragment {

    FirebaseAuth lAuth;
    FirebaseFirestore lStore;

    EditText messageNameEditText, messageDescriptionEditText;
    Button createMessageButton;
    RecyclerView messageRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_create_message, container, false);
        lAuth=FirebaseAuth.getInstance();
        lStore=FirebaseFirestore.getInstance();

        messageNameEditText = view.findViewById(R.id.createmessage_messageNameEditText);
        messageDescriptionEditText = view.findViewById(R.id.createmessage_messageDescriptionEditText);
        createMessageButton = view.findViewById(R.id.createmessage_createMessageButton);
        messageRecyclerView=view.findViewById(R.id.createmessage_messagesRecyclerView);

        //mesaj oluşturma butonu bağla
        createMessageButton.setOnClickListener(v->{
            String messageName = messageNameEditText.getText().toString();
            String messageDescription= messageDescriptionEditText.getText().toString();

        });

        return view;
    }

    //Mesaj olulturma butonu fonksiyonunu yazalım

    private void CreateMessage(String messageName,String messageDescription){
        String userId = lAuth.getCurrentUser()
                .getUid();
    lStore.collection("userdata" +userId + "/messages").add(new HashMap<String,String>())


    }
}