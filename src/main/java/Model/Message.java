/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import com.google.gson.Gson;

/**
 *
 * @author Admins
 */
public class Message {
    String option;
    String message;

    public Message(String option, String message) {
        this.option = option;
        this.message = message;
    }

    public Message() {
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
        
    }
    
    public String exchangeJSON(Message mes) {
        String Json;
        Gson gson = new Gson();
        Json = gson.toJson(mes);
        return Json;
    }
}
