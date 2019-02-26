package topic;

import uk.ac.gcu.bereketabgulai.message.Message;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Topic {
    private List<Message> messages;
    private String title;

    public Topic(String title) {
        messages = new ArrayList<>();
        this.title = title;
    }

    public String displayTopic() {
        StringBuilder b = new StringBuilder();
        b.append(title);
        b.append('\n');
        b.append("-----------\n");
        for (int i = 0; i < messages.size(); i++) {
            Message m = messages.get(i);
            b.append(String.format("%d: %s\n", i, m.displayMessage()));
        }
        return b.toString();
    }

    public List<Message> getMessages() {
        return Collections.unmodifiableList(messages);
    }

    public void addMessage(Message m) {
        messages.add(m);
    }

    public Message removeMessage(int index) {
        if (index < 0 || index >= messages.size()) {
            return null;
        }
        return messages.remove(index);
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("Topic: ");
        b.append(title);
        for (Message m : messages) {
            b.append("\n").append(m.displayMessage());
            b.append("\n");
        }
        return b.toString();
    }
}