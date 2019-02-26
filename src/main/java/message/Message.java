package message;

import java.util.Date;

public class Message {

    private String subject;
    private String message;
    private Date postDate;

    public Message(String subject, String message) {
        this.subject = subject;
        this.message = message;
        this.postDate = new Date();
    }

    public String displayMessage() {
        StringBuilder post = new StringBuilder();
        post.append("Subject: ").append(subject);
        post.append('\n');
        post.append("Message: ").append(message).append("\n");
        post.append("Post Date: ").append(postDate);

        return post.toString();
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
