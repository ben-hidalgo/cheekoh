package cheekoh

class GspToStringService {
   def groovyPagesTemplateEngine;

   // view is a path relative to the grails-app/views/ directory
   String toString(view, model) {
        // Get a template of the view gsp
        def tmpl = groovyPagesTemplateEngine.createTemplate(view);

        // Provide a place to store the processed gsp
        def out = new StringWriter();
        
        // Process the gsp with the given model and write to the StringWriter
        tmpl.make(model).writeTo(out);
        
        return out.toString();
   }
}
