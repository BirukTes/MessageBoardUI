package topic;


import message.Message;
import utility.Keyboard;

public class TopicMenu {
    Topic topic;
    int userChoice;

    public TopicMenu(Topic topic, int choice) {
        this.topic = topic;
        userChoice = choice;
    }

    private void displayMenu() {
        System.out.println("    Topic Menu:");
        System.out.println("    ----------");
        System.out.println("    1. Post message");
        System.out.println("    2. List message(s)");
        System.out.println("    3. Delete Message");
        System.out.println("    4. Display Menu");
        System.out.println("    5. Return to Main Menu");
        System.out.println("    ----------");
    }

    public void displayTopicMenu() {
        int option = 0;
        Keyboard keyBoard = new Keyboard();

        displayMenu();
        do {
            System.out.print("\n    Enter your choice: ");
            option = keyBoard.nextInt();

            switch (option) {

                case 1:
                    System.out.print("\n    Enter the Subject: ");
                    String subject = keyBoard.nextLine();
                    System.out.print("    Enter the Message: ");
                    String message = keyBoard.nextLine();

                    topic.addMessage(new Message(subject, message));
                    System.out.println("\n    Message has been posted.\n");
                    break;
                case 2:
                    System.out.println();
                    int count = 0;
                    for (Message m : topic.getMessages()) {
                        count++;
                        System.out.println(String.format("\n(%d)\n----------\n%s", count, m.displayMessage()));
                    }
                    break;
                case 3:
                    System.out.print("\n    Enter the Message number/index to delete: ");
                    int deleteValue = keyBoard.nextInt();
                    if (deleteValue >= 0 && deleteValue < topic.getMessages().size()) {
                        topic.removeMessage(deleteValue);
                        System.out.println(String.format("Message, %d deleted.", deleteValue));
                    } else {
                        System.out.println("Invalid index.\n");
                    }
                    break;
                case 4:
                    displayMenu();
                    break;
                case 5:
                    System.out.println("    --------------------\n");
                    break;
                default:
                    System.out.println("Invalid option. Please enter one of the options above.\n");
            }
        } while (option != 5);
    }

}
