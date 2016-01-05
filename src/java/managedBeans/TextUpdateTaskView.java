package managedBeans;

import beans.TextUpdateTaskFacade;
import entities.TextUpdateTask;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 * @author Mikhail
 */
@Named(value = "textUpdateTaskView")
@RequestScoped
public class TextUpdateTaskView {
    
    @EJB
    private TextUpdateTaskFacade textUpdateTaskFacade;
    
    // Creates a new field
    private final TextUpdateTask textUpdateTask;

    // Calls getTextUpdateTask to retrieve the textUpdateTask
    public TextUpdateTask getTextUpdateTask() {
       return textUpdateTask;
    }

    // Returns the total number of textUpdateTask
    public int getNumberOfTextUpdateTask(){
       return textUpdateTaskFacade.findAll().size();
    }
    
    public String postTextUpdateTask(){
       this.textUpdateTaskFacade.create(textUpdateTask);
       return "theend";
    }
    
    /** Creates a new instance of TextUpdateTaskView */
    public TextUpdateTaskView() {
        this.textUpdateTask = new TextUpdateTask();
    }
}