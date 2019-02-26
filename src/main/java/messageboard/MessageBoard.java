package messageboard;


import uk.ac.gcu.bereketabgulai.topic.Topic;

import java.util.ArrayList;
import java.util.List;

public class MessageBoard {
    private final String mBTitle;
    private List<Topic> topics;

    public MessageBoard(String name) {
        mBTitle = name;
        topics = new ArrayList<Topic>();
}

    public void addTopic(Topic topic) {
        topics.add(topic);
    }

    public Topic getTopic(int n) {
        return topics.get(n);
    }

    public int getNumberOfTopics() {
        return topics.size();
    }

    public void display() {
        System.out.println(mBTitle);
        System.out.println("-----------");
        for (int i = 0; i < topics.size(); i++) {
            System.out.println(String.format("%d: %s", i, topics.get(i).toString()));
        }

        System.out.println();
    }
}
