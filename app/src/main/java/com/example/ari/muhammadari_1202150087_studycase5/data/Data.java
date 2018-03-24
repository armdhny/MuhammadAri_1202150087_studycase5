package com.example.ari.muhammadari_1202150087_studycase5.data;

/**
 * Created by Ari on 24/03/2018.
 */

public class Data {
    //deklarasi variable
    String todo, desc, prior;



    public Data(String todo, String desc, String prior) {
        this.todo = todo;
        this.desc = desc;
        this.prior = prior;
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPrior() {
        return prior;
    }

    public void setPrior(String prior) {
        this.prior = prior;
    }
}
