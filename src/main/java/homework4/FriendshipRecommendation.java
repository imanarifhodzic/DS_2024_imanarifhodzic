package homework4;

public class FriendshipRecommendation implements Comparable<FriendshipRecommendation> {
    //"Implements Comparable" here allows instances of this class to be compared based on their recommendation strength.
    // implement the relevant properties, constructor and methods
    private String user; //Representing the user being recommended.
    private int recommendationStrength; //Here we are representing the strength of the recommendation.

    public FriendshipRecommendation(String user, int recommendationStrength) {
        //First we have to make a constructor that initializes a FriendshipRecommendation
        this.user = user;
        this.recommendationStrength = recommendationStrength;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getRecommendationStrength() {
        return recommendationStrength;
    }

    public void setRecommendationStrength(int recommendationStrength) {
        this.recommendationStrength = recommendationStrength;
    }

    @Override
    public int compareTo(FriendshipRecommendation o) {
        return Integer.compare(o.recommendationStrength, this.recommendationStrength);
        //Here, compareTo compares the current FriendshipRecommendation object with another FriendshipRecommendation object based on the recommendationStrength.
        //We put the comparison so it is done in descending order, so stronger recommendations come first.
    }

    @Override
    public String toString() {
        return user + ": " + recommendationStrength;
        //Here the method provides a string representation of the FriendshipRecommendation object,
        //showing the user and the recommendation strength.
    }

}
