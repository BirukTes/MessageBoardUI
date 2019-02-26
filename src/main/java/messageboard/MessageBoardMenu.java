package messageboard;

import uk.ac.gcu.bereketabgulai.topic.Topic;
import uk.ac.gcu.bereketabgulai.topic.TopicMenu;
import uk.ac.gcu.bereketabgulai.utility.Keyboard;

public class MessageBoardMenu {

    private MessageBoard currentBoard;

    public MessageBoardMenu(MessageBoard messageBoard) {
        currentBoard = messageBoard;
    }

    public void displayMessageBoardMenu() {
        currentBoard.display();

        int option = 0;
        Keyboard keyBoard = new Keyboard();
        do {
            System.out.println("Main Menu:");
            System.out.println("----------");
            System.out.println("1. Add new topic");
            System.out.println("2. Select a topic to view or post to");
            System.out.println("3. Quit");
            System.out.println("----------");
            System.out.print("Enter your choice: ");
            option = keyBoard.nextInt();

            switch (option) {
                case 1:
                    System.out.print("\nEnter the title of your new topic: ");
                    String title = keyBoard.nextLine();
                    System.out.println("Topic is: " + title);
                    currentBoard.addTopic(new Topic(title));
                    currentBoard.display();
                    break;
                case 2:
                    System.out.print("\nEnter the number of the topic you would like to go to: ");
                    int choice = keyBoard.nextInt();
                    if (choice >= 0 && choice < currentBoard.getNumberOfTopics()) {
                        Topic topic = currentBoard.getTopic(choice);
                        System.out.println("Topic " + choice + " (" + topic.getTitle() + ") selected");
                        new TopicMenu(topic, choice).displayTopicMenu();
                    } else {
                        System.out.println("Invalid index.\n");
                    }
                    break;
                case 3:
                    System.out.println("Goodbye.\n");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please enter one of the options above.\n");
                    displayMessageBoardMenu();
            }
        } while (option != 3);
    }
}
