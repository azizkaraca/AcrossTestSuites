package Steps;

import Pages.DialogContent;
import io.cucumber.java.en.And;

public class ControlMMstep {

    DialogContent dc =new DialogContent();

    @And("User uses ctrl MM combination to open edit mode")
    public void userUsesCtrlMMCombinationToOpenEditMode() {

        dc.ctrlMM();
        //dc.switchToEditMode();
    }
}
