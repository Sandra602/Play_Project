package models;
import java.util.*;

public class movie {

    public Integer id;
    public String title;
    public String writer;
    public String budget;
    public Integer noOfActors;

    public movie(Integer id, String title, String writer,String budget,Integer noOfActors){
        this.id=id;
        this.title=title;
        this.writer=writer;
        this.budget=budget;
        this.noOfActors=noOfActors;
    }

    private static Set<movie> sense;
    static{
        sense=new HashSet<>();
        sense.add(new movie(1,"Hridayam","Vineeth","5 Crore",100));
        sense.add(new movie(2,"Minnal Murali","Basil Joseph","18 Crore",200));
        sense.add(new movie(3,"Bro Daddy","PridhviRaj","20 Crore",150));
        sense.add(new movie(4,"Medppadiyan","Nirmal","5 Crore",130));
    }

    public static Set<movie> allMovies(){
        return sense;
    }

    public static movie findById(Integer id){
        for (movie mov:sense){
            if (id.equals(mov.id)){
                return mov;
            }
        }
        return null;
    }

    public static void add(movie mov){
        sense.add(mov);

    }

    public static boolean remove(movie mov){
        return sense.remove(mov);
    }
}
