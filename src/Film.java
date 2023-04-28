import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.*;
import java.io.*;
public class Film {
    private String title;
    private String duration;
    private double rating;
    private String director;
    private ArrayList<Actor> actors;

    private Boolean available;
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title=title;
    }

    public String getDuration(){
        return duration;
    }
    public void setDuration(String duration){
        this.duration=duration;
    }

    public double getRating(){
        return rating;
    }

    public void setRating(double rating){
        this.rating=rating;
    }

    public String getDirector(){
        return director;
    }

    public void setDirector(String director){
        this.director=director;
    }

    public ArrayList<Actor> getActors(){
        return actors;
    }

    public void setActors(ArrayList<Actor> actors){
        this.actors=actors;
    }

    public Boolean getAvailable(){
        return available;
    }

    public void setAvailable(Boolean available){
        this.available=available;
    }
    public Film(){}
    public Film(String title,double rating,String duration,String director, ArrayList<Actor> actors,Boolean available){
        this.title=title;
        this.rating=rating;
        this.duration=duration;
        this.director=director;
        this.actors=actors;
        this.available=available;
    }

    public Film(String title,double rating,String duration,String director,Boolean available){
        this.title=title;
        this.rating=rating;
        this.duration=duration;
        this.director=director;
        this.available=available;
    }

    public void showInfo(){
        System.out.println("Info about selected film: ");
        System.out.println("Title: " +getTitle());
        System.out.println("Director: " +getDirector());
        System.out.println("Duration: " +getDuration());
        System.out.println("Rating: " +getRating());
        Actor.showActors(actors);
        System.out.println("Available: "+ getAvailable());
    }

    public static void showInfoFilmnumber(ArrayList<Film> films, int number){
        System.out.println("Info about selected film: ");
        System.out.println("Title: " +films.get(number-1).getTitle());
        System.out.println("Director: " +films.get(number-1).getDirector());
        System.out.println("Duration: " +films.get(number-1).getDuration());
        System.out.println("Rating: " +films.get(number-1).getRating());
        Actor.showActors(films.get(number-1).getActors());
        System.out.println("Available: "+ films.get(number-1).getAvailable());
    }

    public void AddActor(Actor actor){
        actors.add(actor);
    }

    public static void AddActorUI(ArrayList<Actor>actors,Actor actor){
        actors.add(actor);
    }

    public static void showFilms(ArrayList<Film> films){
        if(films!=null){
            if(films.size()>0){
                System.out.println("Films: ");
            }
            for(int i=0;i<films.size();i++){
                System.out.println(i+1 + ". Title: " + films.get(i).getTitle() + ", Available: " + films.get(i).getAvailable());
            }
            System.out.println(" ");
        }
    }

    public static void showInfoFilm(ArrayList<Film>films,Scanner scan){
        Film.showFilms(films);
        System.out.println("Type number of film");
        String number=scan.nextLine();
        int numberInt=Integer.parseInt(number);
        if(numberInt>0&&numberInt<=films.size()) {
            Film.showInfoFilmnumber(films, numberInt);
        }
        else{
            System.out.println("You choosed bad number");
        }
    }

    public static void AddFilm(Scanner scan, ArrayList<Film> films,ArrayList<Actor> actors){
        System.out.println("Type title:");
        String title = scan.nextLine();
        System.out.println("Type duration:");
        String duration = scan.nextLine();
        System.out.println("Type rating:");
        String ratingStr = scan.nextLine();
        double rating = Double.parseDouble(ratingStr);
        System.out.println("Type director:");
        String director=scan.nextLine();
        Boolean available=true;
        ArrayList<Actor>actors1= new ArrayList<Actor>();
        Film newFilm = new Film(title,rating,duration,director,actors1,available);
        System.out.println("Choose number of actor, if he was in this film. Otherwise type 0");
        Actor.showActors(actors);
        String chooseActor=scan.nextLine();
        int chooseActornum = Integer.parseInt(chooseActor);
        chooseActornum-=1;
        if(chooseActornum>=0 && chooseActornum<actors.size()) {
            newFilm.AddActor(actors.get(chooseActornum));
        }
        films.add(newFilm);
        System.out.println("Completed!");
    }

    public static void addActorToFilm(Scanner scan,ArrayList<Film> films, ArrayList<Actor> actors){
        Film.showFilms(films);
        System.out.println("Choose film:");
        String numberf=scan.nextLine();
        int numberfi=Integer.parseInt(numberf);
        Actor.showActors(actors);
        System.out.println("Choose actor:");
        String numbera=scan.nextLine();
        int numberai=Integer.parseInt(numbera);
        films.get(numberfi-1).AddActor(actors.get(numberai-1));
        System.out.println("Completed");
    }

    public static void saveFilm(ArrayList<Film> films) throws FileNotFoundException {
        PrintWriter save = new PrintWriter("films.txt");
        for(int i=0;i<films.size();i++){
            save.write(films.get(i).getTitle()+","+
                    films.get(i).getRating()+","+
                    films.get(i).getDuration()+","+
                    films.get(i).getDirector()+","+
            films.get(i).getAvailable().toString());
            save.println("");
        }
        save.close();
    }

    public static void readFilms(String path,ArrayList<Film>films) throws FileNotFoundException {
        BufferedReader reader=null;
        try{
            reader = new BufferedReader(new FileReader(path));
            String line;
            while((line=reader.readLine())!=null){
                String[] separated = line.split(",");
                ArrayList<Actor> actors1 = new ArrayList<Actor>();
                Film newFilm= new Film(separated[0],Double.parseDouble(separated[1]),separated[2],separated[3],actors1,Boolean.valueOf(separated[4]));
                films.add(newFilm);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
