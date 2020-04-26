
package ohtu;

/*
{
    "goals":0,
    "assists":1,
    "name":"Jack Studnicka",
    "penalties":2,
    "team":"BOS",
    "nationality":"CAN",
    "birthdate":"1999-02-18"
}
*/

public class Player implements Comparable<Player>  {
    private String name;
    private String goals;
    private String assists;
    private String team;
    private String nationality;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getNationality() {
        return nationality;
    }
    
    public int getPoints() {
        return Integer.parseInt(goals) + Integer.parseInt(assists);
    }
   
    @Override
    public String toString() {
        // esim. Henrik Borgstrom   FLA 0 + 0 = 0
        return name + (name.length() > 15 ? "\t" : "\t\t") + team + "\t" + goals + " + " + assists + " = " + this.getPoints();
    }

    @Override
    public int compareTo(Player player) {
        return player.getPoints() - this.getPoints();
    }
}
