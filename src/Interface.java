import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
public class Interface {
   public static String Menu(Scanner scan){
       System.out.println("Menu:");
       System.out.println("1.Show films");
       System.out.println("2.Show actors");
       System.out.println("3.Add film");
       System.out.println("4.Add actor");
       System.out.println("5.Show info about actor");
       System.out.println("6.Show info about film");
       System.out.println("7.Add actor to film");
       System.out.println("8.Quit");
       System.out.println("Choose number:");
       String choose=scan.nextLine();
       return choose;
   }
   public static void Initialize(ArrayList<Film> films,ArrayList<Actor> actors){
       ArrayList<Actor>godfatheracts= new ArrayList<Actor>();
       ArrayList<Actor>godfather2acts= new ArrayList<Actor>();
       ArrayList<Actor>godfellasacts= new ArrayList<Actor>();
       ArrayList<Actor>sevenacts= new ArrayList<Actor>();
       ArrayList<Actor>irishmanacts= new ArrayList<Actor>();
       Actor kevinSpacey=new Actor("Kevin","Spacey","26-07-1959",8.8,"USA");
       Actor alPacino = new Actor("Alfredo","Pacino","25-04-1940",8.9,"USA");
       Actor marlonBrando=new Actor("Marlon","Brando","03-04-1924",8.6,"USA");
       Actor joePesci = new Actor("Joseph","Pesci","09-02-1943",8.9,"USA");
       Actor robertDeNiro = new Actor("Robert","De Niro","17-08-1943",8.7,"USA");
       Film goodfellas = new Film("Goodfellas",8.3,"2:26","Martin Scorsese",godfellasacts,true);
       Film godfather2 = new Film("The Godfather:Part II",8.38,"3:20","Francis Ford Coppola",godfather2acts,true);
       Film godfather = new Film("The Godfather",8.7, "2:55", "Francis Ford Coppola",godfatheracts,true);
       Film seven = new Film("Seven",8.27,"2:07","David Fincher",sevenacts,true);
       Film irishman = new Film("The Irishman",7.1,"3:30","Martin Scorsese",irishmanacts,true);
       actors.add(kevinSpacey);
       actors.add(alPacino);
       actors.add(marlonBrando);
       actors.add(joePesci);
       actors.add(robertDeNiro);
       godfather.AddActor(kevinSpacey);
       films.add(godfather);
       films.add(goodfellas);
       films.add(godfather2);
       films.add(seven);
       films.add(irishman);
   }




}
