package br.unicamp.ic.mc437.g1.model.service;

import br.unicamp.ic.mc437.g1.entity.TestCaseResult;
import br.unicamp.ic.mc437.g1.entity.TestOutput;
import br.unicamp.ic.mc437.g1.entity.TestResult;
import br.unicamp.ic.mc437.g1.entity.TestSetResult;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author Fernando H. S. Goncalves (fernando.goncalves@movile.com)
 */
@Service
public class ScoreService {

    public void calculateScore(final TestResult testResult) {
        Map<String, Boolean> testDeadMap = new HashMap<String, Boolean>();
        for (TestSetResult testSetResult : testResult.getTestSetResults()) {
            testSetResult.setScore(calculateTestSetScore(testDeadMap, testSetResult));
        }

        testResult.setScore(calculateTestScore(testDeadMap));
    }

    private int calculateTestScore(Map<String, Boolean> testDeadMap) {
        int dead = 0;
        for (Boolean it : testDeadMap.values()) {
            if (it) {
                dead++;
            }
        }
        int total = testDeadMap.size();
        return dead * 100 / total;
    }

    private int calculateTestSetScore(Map<String, Boolean> testDeadMap, TestSetResult testSetResult) {
        int dead = 0;
        int total = 0;

        Map<String, Boolean> testSetDeadMap = new HashMap<String, Boolean>();
        for (TestCaseResult testCaseResult : testSetResult.getTestCaseResults()) {
            for (TestOutput testOutput : testCaseResult.getTestOutputs()) {
                Boolean currentMutantAlreadyDead = testSetDeadMap.get(testOutput.getMutantKey());
                if (currentMutantAlreadyDead == null) {
                    total++; // first time of current mutant

                    if (testOutput.getDead()) {
                        dead++;
                    }
                    testSetDeadMap.put(testOutput.getMutantKey(), testOutput.getDead());

                } else {
                    if (testOutput.getDead()) {
                        if (!currentMutantAlreadyDead) {
                            dead++;
                        }
                        testSetDeadMap.put(testOutput.getMutantKey(), testOutput.getDead());
                    }
                }
            }
        }

        for (Entry<String, Boolean> t : testSetDeadMap.entrySet()) {
            if (testDeadMap.containsKey(t.getKey())) {
                if (t.getValue() != null && t.getValue()) {
                    testDeadMap.put(t.getKey(), t.getValue());
                }
            } else {
                testDeadMap.put(t.getKey(), t.getValue());
            }
        }

        return dead * 100 / total;
    }
}
