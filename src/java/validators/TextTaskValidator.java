package validators;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Mikhail
 */
@FacesValidator("textTaskValidator")
public class TextTaskValidator implements Validator {	
    
    public final String errorNonInteger = "Введите целое число";
    public final String errorNonPositiveInteger = "Введите целое положительное число";
    public final String errorNumberIsVeryLarge = "Число не должно превышать количество символов в исходной строке";

    public TextTaskValidator(){}
    
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String strCount = (String) ((HtmlInputText) component).getSubmittedValue();
        String input = (String) component.findComponent("textInput").getAttributes().get("value");

        int count;
        FacesMessage message = new FacesMessage();
        message.setSeverity(FacesMessage.SEVERITY_ERROR);
        try {
            count = Integer.parseInt(strCount);
        } catch (NumberFormatException ex) {
            message.setDetail(errorNonInteger);
            message.setSummary(errorNonInteger);
            throw new ValidatorException(message);
        }
        if (count < 0) {
            message.setDetail(errorNonPositiveInteger);
            message.setSummary(errorNonPositiveInteger);
            throw new ValidatorException(message);
        }

        if ((input == null) ? true : (count > input.length())) {
            message.setDetail(errorNumberIsVeryLarge);
            message.setSummary(errorNumberIsVeryLarge);
            throw new ValidatorException(message);
        }
    }
}