package controllers;

import java.util.*;
import models.*;
import play.mvc.*;
import play.data.Form;
import views.html.*;
import play.db.ebean.*;
import play.data.validation.Constraints.*;
//import javax.inject.*;

public class IdeasController extends Controller{


    //WHO WE ARE
    public static Result index(){
        Set<movie> sense=movie.allMovies();
        return ok(index.render(sense));
    }

    //To contribute ideas
    public static Result create(){
        Form<NewMovie> movieForm = Form.form(NewMovie.class);
        return ok(newcreate.render(movieForm));
    }

    //To save ideas
    public static Result save(){
        System.out.println("IN POST CONTACT");
        Form<NewMovie> movieForm = Form.form(NewMovie.class).bindFromRequest();
        NewMovie data = movieForm.get();
        System.out.format("%s, %s, %s%n",data.first,data.Last,data.email);
        return ok(newcreate.render(movieForm));
    }

    public static Result getIndex(long id) {
        YourMovie studentData = (id == 0) ? new YourMovie() : models.newEntry.makeStudentFormData(id);
        Form<YourMovie> formData = Form.form(YourMovie.class).fill(studentData);
        return ok(create.render(
                formData,
                Hobby.makeHobbyMap(studentData),
                GradeLevel.getNameList(),
                Experience.makeGPAMap(studentData),
                Major.makeMajorMap(studentData)
        ));
    }
    public static Result postIndex() {

        // Get the submitted form data from the request object, and run validation.
        Form<YourMovie> formData = Form.form(YourMovie.class).bindFromRequest();

        if (formData.hasErrors()) {
            // Don't call formData.get() when there are errors, pass 'null' to helpers instead.
            flash("error", "Please correct errors above.");
            return badRequest(create.render(formData,
                    Hobby.makeHobbyMap(null),
                    GradeLevel.getNameList(),
                    Experience.makeGPAMap(null),
                    Major.makeMajorMap(null)
            ));
        }
        else {
            // Convert the formData into a Student model instance.
            newEntry student = newEntry.makeInstance(formData.get());
            flash("success", "Student instance created/edited: " + student);
            return ok(create.render(formData,
                    Hobby.makeHobbyMap(formData.get()),
                    GradeLevel.getNameList(),
                    Experience.makeGPAMap(formData.get()),
                    Major.makeMajorMap(formData.get())
            ));
        }
    }

    public static Result edit(Integer id){
        return TODO;
    }

    public static Result update(){
        return TODO;
    }

    public static Result distroy(Integer id){
        return TODO;
    }

    //for ideas
    public static Result show(Integer id){
        return TODO;
    }
}