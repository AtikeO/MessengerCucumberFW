package framework;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)     // JUnit Annotation
@CucumberOptions(            // This is an interface, Asagidaki commandline lari calistirir.

        plugin = {"pretty", "html:target/site/cucumber-pretty", "json:target/cucumber-html-reports/cucumber.json"},     // Plugin generates cucumber reports

        snippets = cucumber.api.SnippetType.CAMELCASE,    //This create auto method name in camelCase

        features = {"src/test/resources/features"},     //Path to your feature file

        //tags = {"@messenger-1"},                     // Specify tags to be executed
        tags = {"@login"},

        glue = {"stepdefinition"}                     //Glue is path of stepdefinition (Note: make sure to have this package on current directory)
)


public class TestRunner {          // This class creates cucumber reports
                                    // Execute test
}

    /*
    monocrome ==>okunabilir bir formatta konsola ciktiyi yazdirir
    thisplays the concole output in a proper readeable format

    Scrict==>it will check if any step is not defined in step definition file
    step definition dosyasinda tanimlanmayan birsey var mi yokmu diye kontrol eder

    dryRun ==>it is use to check the mapping is propper between feature file and  step definition file
    step defination file step definetion dosyasi arasinda duzgun baglanti varmi yokmu diye kontrol eder

    Format==> is used to specify different formatting options for the output reports
        output raporlari icin farkli format  tiplerini belirler

        Pretty==> it prints the gherkin source with additional colors and stack traces for users.
        kullanici icin gherkin kaynaklarini yazdirir(renk vs)

        Format = {“pretty”} ==>(you can use plugin)
        pretty plugin ile kullaniyoruz (uste bak anlamadigin durumda :)  */


