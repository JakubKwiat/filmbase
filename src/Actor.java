import java.io.*;
import java.util.*;
public class Actor {
    private String name;
    private String surname;
    private String birthDate;

    private double rating;

    private String country;

    private ArrayList<Film> filmsList;

    public ArrayList<Film> getFilmsList(){
        return filmsList;
    }

    public void setFilmsList(ArrayList<Film> films){
        this.filmsList=films;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    public String getSurname(){
        return surname;
    }

    public void setSurname(String surname){
        this.surname=surname;
    }

    public String getbirthDate(){
        return birthDate;
    }

    public void setBirthDate(String birthDate){
        this.birthDate=birthDate;
    }

    public double getRating(){
        return rating;
    }

    public void setRating(int rating){
        this.rating=rating;
    }

    public String getCountry(){
        return country;
    }

    public void setCountry(String country){
        this.country=country;
    }

    public Actor(){}

    public Actor(String name, String surname,String birthDate,double rating,String country){
        this.name=name;
        this.surname=surname;
        this.birthDate=birthDate;
        this.rating=rating;
        this.country=country;
    }

    public static void showActors(ArrayList<Actor> actors){
        if(actors!=null){
            if(actors.size()>0){
                System.out.println("Actors: ");
            }
            for(int i=0;i<actors.size();i++) {
                System.out.println(i + 1 + ". Name: " + actors.get(i).getName() + ", Surname: " + actors.get(i).getSurname());
            }
        }
    }

    public static void AddActor(Scanner scan,ArrayList<Actor> actors){
        System.out.println("Type name:");
        String name=scan.nextLine();
        System.out.println("Type surname:");
        String surname=scan.nextLine();
        System.out.println("Type birthdate (format: dd-mm-yyyy)");
        String birthdate=scan.nextLine();
        System.out.println("Type rating:");
        String ratingStr = scan.nextLine();
        double rating=Double.parseDouble(ratingStr);
        System.out.println("Type country of origin");
        String country=scan.nextLine();
        Actor actor = new Actor(name,surname,birthdate,rating,country);
        actors.add(actor);
        System.out.println("Completed!");
    }

    public static void showInfoActor(ArrayList<Actor>actors,Scanner scan){
        Actor.showActors(actors);
        System.out.println("Type number of actor");
        String number=scan.nextLine();
        int numberInt = Integer.parseInt(number);
        if(numberInt>0 && numberInt<=actors.size()) {
            System.out.println("Info about selected actor: ");
            System.out.println("Name: " + actors.get(numberInt - 1).getName() + ", Surname: " +
                    actors.get(numberInt - 1).getSurname() + ", Birth date: " +
                    actors.get(numberInt - 1).getbirthDate() + " ,Rating: " +
                    actors.get(numberInt - 1).getRating() + ", Country: " +
                    actors.get(numberInt - 1).getCountry());
        }
        else{
            System.out.println("You choosed bad number!!!");
        }
    }

    public static void saveActor(ArrayList<Actor> actors) throws FileNotFoundException {
        PrintWriter save = new PrintWriter("actors.txt");
        for(int i=0;i<actors.size();i++){
            save.write(actors.get(i).getName()+","+
                    actors.get(i).getSurname()+","+
                    actors.get(i).getbirthDate()+","+
                    actors.get(i).getRating()+","+
                    actors.get(i).getCountry());
            save.println("");
        }
        save.close();
    }

    public static void readActors(String path,ArrayList<Actor>actors) throws FileNotFoundException {
        BufferedReader reader=null;
        try{
            reader = new BufferedReader(new FileReader(path));
            String line;
            while((line=reader.readLine())!=null){
                String[] separated = line.split(",");
                Actor newActor = new Actor(separated[0],separated[1],separated[2],Double.parseDouble(separated[3]),separated[4]);
                actors.add(newActor);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
