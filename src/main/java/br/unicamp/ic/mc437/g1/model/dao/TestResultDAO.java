package br.unicamp.ic.mc437.g1.model.dao;

import br.unicamp.ic.mc437.g1.entity.TestResult;

import java.util.List;

/**
 * @author Fernando H. S. Goncalves (fernando.goncalves@movile.com)
 */
public interface TestResultDAO {

    TestResult findById(Integer id);

    List<TestResult> list(String criteria);

    TestResult save(TestResult testResult);
}
