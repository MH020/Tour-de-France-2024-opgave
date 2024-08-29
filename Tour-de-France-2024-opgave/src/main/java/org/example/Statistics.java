package org.example;
import java.io.FileNotFoundException;
import java.util.*;

public class Statistics {
    List <Cyclist> cyclists;

    public Statistics() throws FileNotFoundException {
        TDFFileReader fileReader = new TDFFileReader("tdffinishers2024.csv");
        cyclists = fileReader.readFile();

    }

    //get hold (uden medlemmer)
    public Set<String> getTeams(){
        Set <String> teamSet = new HashSet<>();
        for (Cyclist c : cyclists) {
            teamSet.add(c.getTeam());
        }
        return teamSet;
    }

    //get hold og medlemmer
    public Map <String, Set <String>> GetTeamsWithMembers(){
        Map <String, Set <String>> teamMap = new HashMap<String, Set <String>>(); //teamMap returneres.

        Set <String> teamSet = getTeams();//keys. Holdnavne.

        for (String t : teamSet){ //for hvert hold
            Set <String> memberSet = new HashSet<>();//values
            for (Cyclist c : cyclists){
                if (c.getTeam().equals(t)){
                    memberSet.add(c.getName()); //hvis cyklistens hold er = t (hold i teamSet) tilføjes til memerSet
                }
            }
            teamMap.put(t,memberSet); //tilføje hold og medlemslister til teamMap.
        }

        return teamMap;
    }

    //get medlemmer, for specifikt hold.
    public Set <String> getTeamMembers(String team){
        Set <String> teamMembers = GetTeamsWithMembers().get(team); //String team er key til teamswithmembers map.
        return teamMembers;
    }
}
