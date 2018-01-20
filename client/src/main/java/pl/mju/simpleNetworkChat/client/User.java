package pl.mju.simpleNetworkChat.client;

public class User {

    private String userName;
    private String userNick;

    public User(String userName) {
        this.userName = userName;
    }

    public User(String userName, String userNick) {
        this(userName);
        this.userNick = userNick;
    }

}
