package br.unicamp.ic.mc437.g1.model.dao;

import br.unicamp.ic.mc437.g1.entity.TestResult;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author Fernando H. S. Goncalves (fernando.goncalves@movile.com)
 */
@Repository
@Transactional
public class TestResultDAOImpl implements TestResultDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public TestResult findById(Integer id) {
        return entityManager.find(TestResult.class, id);
    }

    @Override
    public List<TestResult> list() {
        return entityManager.createQuery("SELECT t FROM TestResult t", TestResult.class).getResultList();
    }

    @Override
    public TestResult save(TestResult testResult) {
        return entityManager.merge(testResult);
    }
}
