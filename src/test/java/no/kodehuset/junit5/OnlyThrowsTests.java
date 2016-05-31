package no.kodehuset.junit5;

import org.junit.gen5.api.extension.ConditionEvaluationResult;
import org.junit.gen5.api.extension.TestExecutionCondition;
import org.junit.gen5.api.extension.TestExtensionContext;

public class OnlyThrowsTests implements TestExecutionCondition {

    @Override
    public ConditionEvaluationResult evaluate(TestExtensionContext context) {

        return context.getName().indexOf("Throws") > -1 ? ConditionEvaluationResult.enabled("Test contains Throws") :
                ConditionEvaluationResult.disabled("Not testing Throws");
    }
}
