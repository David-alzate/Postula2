package co.edu.uco.postula2.infraestructure.primaryadapters.controller.response;

import java.util.ArrayList;
import java.util.List;

public class Response<T> {

    private List<String> messages = new ArrayList<>();
    private List<T> data;


    public final List<String> getMessages() {
        return messages;
    }

    public final void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public final List<T> getData() {
        return data;
    }

    public final void setData(List<T> data) {
        this.data = data;
    }

}
