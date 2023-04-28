import java.util.*;
import java.io.*;
import java.awt.EventQueue;
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Actor>actors= new ArrayList<Actor>();
        ArrayList<Film>films= new ArrayList<Film>();
        //Interface.Initialize(films,actors);
        Film.readFilms("films.txt",films);
        Actor.readActors("actors.txt",actors);
        Scanner scan=new Scanner(System.in);
        Boolean condition=true;
        while(condition){
            String choose=Interface.Menu(scan);
            switch(choose){
                case "1":
                    Film.showFilms(films);
                    break;
                case "2":
                    Actor.showActors(actors);
                    break;
                case "3":
                    Film.AddFilm(scan,films,actors);
                    break;
                case "4":
                    Actor.AddActor(scan,actors);
                    break;
                case "5":
                    Actor.showInfoActor(actors,scan);
                    break;
                case "6":
                    Film.showInfoFilm(films,scan);
                    break;
                case "7":
                    Film.addActorToFilm(scan,films,actors);
                    break;
                case "8":
                    Film.saveFilm(films);
                    Actor.saveActor(actors);
                    condition=false;
                    break;
            }
        }
    }
}