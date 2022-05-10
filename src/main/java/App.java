import static spark.Spark.*;
import spark.template.handlebars.HandlebarsTemplateEngine;
import spark.ModelAndView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        //all animals
        get("/animals", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<EndangeredAnimal> animals = EndangeredAnimal.all();
            List<Sightings> sightings = Sightings.all();

            model.put("sightings", sightings);
            model.put("animals", animals);

            return new ModelAndView(model, "animal.hbs");
        }, new HandlebarsTemplateEngine());

        //post submission
        post("/animals/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String animal = request.queryParams("animal");
            String danger = request.queryParams("danger");
            String health = request.queryParams("health");
            String age = request.queryParams("age");
            String location = request.queryParams("location");
            String ranger = request.queryParams("ranger");

            EndangeredAnimal endangeredAnimal = new EndangeredAnimal(animal, danger, health, age, location, ranger);
            endangeredAnimal.save();
            Sightings sighting = new Sightings(endangeredAnimal.getId(), location, ranger);
            sighting.save();

            model.put("endangeredAnimal", endangeredAnimal);
            model.put("sighting", sighting);

            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());
    }
}

