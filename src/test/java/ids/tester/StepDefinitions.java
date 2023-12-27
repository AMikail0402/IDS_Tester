package ids.tester;

import io.cucumber.java.en.*;
import Enum.Address;
import io.cucumber.java.de.*;

public class StepDefinitions {

    @Dann("Drucke die Umgebungsvariable")
    public void printEnv(){
        System.out.println(Address.ADDRESS.getAddress());
    }

}
