package homework4;

//This Friendship class shows us an edge in an edge-weighted graph, and where:
//The two firstFriend and secondFriend represent the nodes connected by the edge.
//The friendshipStrength represents the weight of the edge.
public class Friendship {
    // implement the relevant properties, constructor and methods
    private String firstFriend;
    private String secondFriend;
    private int friendshipStrength;

    public Friendship(String firstFriend, String secondFriend, int friendshipStrength) {
        this.firstFriend = firstFriend;
        this.secondFriend = secondFriend;
        this.friendshipStrength = friendshipStrength;
    }

    public String getFirstFriend() {
        return firstFriend;
    }

    public void setFirstFriend(String firstFriend) {
        this.firstFriend = firstFriend;
    }

    public String getSecondFriend() {
        return secondFriend;
    }

    public void setSecondFriend(String secondFriend) {
        this.secondFriend = secondFriend;
    }

    public int getFriendshipStrength() {
        return friendshipStrength;
    }

    public void setFriendshipStrength(int friendshipStrength) {
        this.friendshipStrength = friendshipStrength;
    }

    @Override
    public String toString(){
        return  "\nFirst Friend: " + this.firstFriend
                + "\nSecond Friend: " + this.secondFriend
                + "\nFriendship Strength: " + this.friendshipStrength;
    }

}
//The class includes constructors for initializing objects and getter and setter methods for
//maneuvering the properties.
//The toString method provides a readable representation of a Friendship object. It is a string representation of the Friendship object,
//showing the names of the two friends and their strength of friendship.