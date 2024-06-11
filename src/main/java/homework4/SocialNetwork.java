package homework4;

import java.util.*;

public class SocialNetwork {
    private int V; //Here we represent the number of vertices which are users in the social network.
    private int E; //Here we represent the number of edges which are friendships in the social network.

    private HashMap<String, ArrayList<Friendship>> adj;
    //Here we represent the adjacency list of the social network, where the key is the user and the value is a list of friendships.
    //Also where each user is mapped to a list of friendships.

    public SocialNetwork() {
        // implement the actual logic
        this.adj = new HashMap<>();
    }

    public SocialNetwork(Scanner in) {
        //Initializes the adjacency list from a file, skipping the header and parsing the friendship data.
        // implement the actual logic
        this.adj = new HashMap<>(); //Initializing the adjacency list
        boolean isFirstLine = true; //Skip the first line (header) of the file.
        while (in.hasNextLine()) { //Reading file line by line.
            String line = in.nextLine().trim(); //Trimming the line to remove leading and trailing whitespaces.
            if (isFirstLine) {
                isFirstLine = false;
                continue;
            }
            if (line.isEmpty()) continue;

            String[] data = line.split(";"); //Splitting the line into parts using ";".
            if (data.length != 3) { //Skips lines that don't contain exactly three data points.
                System.out.println("Invalid line skipped: " + line);
                continue;
            }

            String friend1 = data[0];
            String friend2 = data[1];
            int strength; //Declaring a variable to store the strength of the friendship.
            try {
                strength = Integer.parseInt(data[2]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid strength value: " + data[2]);
                continue;
                //Parses the friendship strength to an integer. If parsing fails, skips the line.
            }

            Friendship friendship = new Friendship(friend1, friend2, strength); //Creating a new Friendship object.
            this.addFriendship(friendship); //Adding the friendship to the adjacency list by using the addFriendship method.
        }
    }

    public void addUser(String user) {
        //Now we have to add a new user to the social network if they don't exist already.
        // implement the actual logic
        if (!adj.containsKey(user)) {
            adj.put(user, new ArrayList<>());
            V++;
        }
    }

    public void addFriendship(Friendship f) {
        //Now add a new friendship to the social network, ensuring both users exist in the network.
        // implement the actual logic
        addUser(f.getFirstFriend());
        addUser(f.getSecondFriend());
        adj.get(f.getFirstFriend()).add(f);
        //Add the friendship in reverse order, as the graph is undirected and the friendship is recorded in both directions.
        adj.get(f.getSecondFriend()).add(new Friendship(f.getSecondFriend(), f.getFirstFriend(), f.getFriendshipStrength()));
        //Adding the friendship to the adjacency list of both users.
        E++; //increment the number of friendships.
    }

    public ArrayList<FriendshipRecommendation> recommendFriends(String user) {
        //Now we should generate a list of friendship recommendations for a given user based on their friends' friends, taking into account the strength of existing friendships.
        // implement the actual logic (remove next line)
        ArrayList<FriendshipRecommendation> recommendations = new ArrayList<>();
        //Initializing an empty list to store the recommendations.
        if (!adj.containsKey(user)) return recommendations;
        //Checking if the user exists in the network. If not, it returns an empty list.

        Map<String, Integer> potentialFriends = new HashMap<>();
        //Initializing a map to store potential friends and their recommendation strengths.

        for (Friendship friendShip : adj.get(user)) { //Iterates over the friendships of the given user.
            String friend = friendShip.getSecondFriend();
            int userFriendStrength = friendShip.getFriendshipStrength(); //Gets the strength of the friendship between the user and the friend.

            for (Friendship friendOfFriendShip : adj.get(friend)) { //Iterates over the friendships of the friend.
                String potentialFriend = friendOfFriendShip.getSecondFriend();
                int friendToPotentialFriendStrength = friendOfFriendShip.getFriendshipStrength();

                if (potentialFriend.equals(user) || adj.get(user).stream().anyMatch(f -> f.getSecondFriend().equals(potentialFriend)))
                    //This if statement: if the potential friend is the user or already a direct friend of the user.
                    continue;

                int minStrength = Math.min(userFriendStrength, friendToPotentialFriendStrength);
                //Calculating the minimum strength between the user and the friend, and the friend and the potential friend.
                potentialFriends.put(potentialFriend, potentialFriends.getOrDefault(potentialFriend, 0) + minStrength);
            }
        }

        for (Map.Entry<String, Integer> entry : potentialFriends.entrySet()) {
            //Iterates over the potential friends and their recommendation strengths.
            recommendations.add(new FriendshipRecommendation(entry.getKey(), entry.getValue()));
            //Adds a new FriendshipRecommendation object to the list of recommendations.
        }

        Collections.sort(recommendations);
        return recommendations;
        //Sorting the recommendations based on the recommendation strength (in descending order).
    }

    public int getUserCount() {
        //Now lets return the total number of users in the social network.
        return adj.size();
    }

    public int getFriendshipCount() {
        //And return the total number of friendships in the social network.
        int count = 0;
        for (List<Friendship> friends : adj.values()) {
            count += friends.size();
        }
        return count / 2;
    }

    public boolean hasUser(String user) {
        //Let's check if a given user exists in the social network.
        return adj.containsKey(user);
    }
}
