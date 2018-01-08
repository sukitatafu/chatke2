package com.splash.billy.chatke2;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Billy on 08/01/2018.
 */

public class Chat {
    private User sender;
    private String pesan;
    private Long tanggal;

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }

    public Long getTanggal() {
        return tanggal;
    }

    public void setTanggal(Long tanggal) {
        this.tanggal = tanggal;
    }

    private Long tanggal;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference chatRef = database.getReference("chats");


    public void send(){
        chatRef.push().setValue(this);
    }

    public String getPesan() {
        return pesan;
    }
}