import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

/**
 * Object-oriented design for a chat server.
 * 
 * @author Gillis Werrebrouck
 */

public class Chat_Server {
    public static void main(final String args[]) {
        
    }
}

class User {
    private UUID id;
    private String firstname;
    private String lastname;
    private String email;
    private String password; // encrypted
    private boolean isOnline; // online/offline or could be an enum with more options
    private ArrayList<Request> sentRequests;
    private ArrayList<Request> receivedRequests;
    private ArrayList<PrivateChat> privateChats;
    private ArrayList<GroupChat> groupChats;

    public User(String firstname, String lastname, String email, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setOnline(boolean isOnline) {
        this.isOnline = isOnline;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public ArrayList<Request> getSentRequests() {
        return sentRequests;
    }

    public void addSentRequest(Request request) {
        this.sentRequests.add(request);
    }

    public ArrayList<Request> getReceivedRequests() {
        return receivedRequests;
    }

    public void addReceivedRequest(Request request) {
        this.receivedRequests.add(request);
    }

    public ArrayList<PrivateChat> getPrivateChats() {
        return privateChats;
    }

    public void addPrivateChat(PrivateChat privateChat) {
        this.privateChats.add(privateChat);
    }

    public ArrayList<GroupChat> getGroupChat() {
        return groupChats;
    }

    public void addGroupChat(GroupChat groupChat) {
        this.groupChats.add(groupChat);
    }

    // other actions with requests, chats, messages etc.
}

enum RequestStatus {
    AWAITING,
    ACCEPTED,
    REJECTED,
}

class Request {
    private UUID id;
    private User fromUser;
    private User toUser;
    private RequestStatus status;
    private Date timestamp;

    public Request(User fromUser, User toUser) {
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.status = RequestStatus.AWAITING;
    }

    public User getFromUser() {
        return fromUser;
    }

    public User getToUser() {
        return toUser;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
    }

    public Date getTimestamp() {
        return timestamp;
    }
}

class UserManager {
    private static UserManager instance; // singleton

    private HashMap<UUID, User> usersById;
    private HashMap<String, User> usersByName;
    private HashMap<UUID, User> onlineUsersById;

    private UserManager() {}

    public static UserManager getInstance() {
        if (instance == null) {
            instance = new UserManager();
        }
        return instance;
    }

    public void sendRequest(User toUser) {
        // TODO: add implementation
    }

    public void approveRequest(Request request) {
        // TODO: add implementation
    }

    public void rejectRequest(Request request) {
        // TODO: add implementation
    }

    public void signOn(User user) {
        // TODO: add implementation
    }

    public void signOff(User user) {
        // TODO: add implementation
    }
}

class TextMessage {
    private UUID id;
    private String content;
    private Date timestamp;
    private User sender;

    public TextMessage(String content, User sender) {
        this.content = content;
        this.sender = sender;
    }
}

abstract class Chat {
    protected UUID id;
    protected ArrayList<TextMessage> messages = new ArrayList<TextMessage>();
    protected ArrayList<User> members = new ArrayList<User>();

    public void addMessage(TextMessage message) {
        this.messages.add(message);
    }

    public ArrayList<TextMessage> getMessages() {
        return messages;
    }
}

class PrivateChat extends Chat {
    public PrivateChat(User user1, User user2) {
        this.members.add(user1);
        this.members.add(user2);
    }

    public User getOtherMember() {
        // TODO: add implementation
        return null;
    }
}

class GroupChat extends Chat {
    public GroupChat(ArrayList<User> members) {
        this.members = members;
    }

    public void addMember(User user) {
        this.members.add(user);
    }
}
