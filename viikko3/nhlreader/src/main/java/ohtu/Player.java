
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

public class Player {
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
   
    @Override
    public String toString() {
        // esim. Henrik Borgstrom team FLA goals 0 assists 0
        return name + " team " + team + " goals " + goals + " assists " + assists;
    }
      
}
