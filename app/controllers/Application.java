package controllers;


import play.*;
import play.mvc.*;
import views.html.*;


public class Application extends Controller {

    public static Result index() {
        return TODO;
    }

    public static Result homes(){

        return ok(intro.render());
    }
}
