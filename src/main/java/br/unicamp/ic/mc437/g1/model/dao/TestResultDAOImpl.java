package br.unicamp.ic.mc437.g1.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.search.errors.EmptyQueryException;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.unicamp.ic.mc437.g1.entity.TestResult;

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
	@SuppressWarnings("unchecked")
    public List<TestResult> list(String criteria) {
    	FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
    	
    	QueryBuilder qb = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(TestResult.class).get();
    	
    	Query query;
    	if (criteria != null && !criteria.isEmpty()) {
    		
    		try {
    			query = fullTextEntityManager.createFullTextQuery(
    					qb.keyword().onFields(
    							"email",
    							"name",
    							"testSetResults.id",
    							"testSetResults.cod",
    							"testSetResults.path",
    							"testSetResults.testCaseResults.path",
    							"testSetResults.testCaseResults.testCaseKey",
    							"testSetResults.testCaseResults.testOutputs.mutantKey",
    							"mutants.contextId",
    							"mutants.name",
    							"mutants.path",
    							"mutants.map.name",
    							"mutants.map.mutantMapStates.name",
    							"mutants.map.mutantMapStates.transition.event",
    							"mutants.map.mutantMapStates.transition.guard.targetState",
    							"resultModels.contextId",
    							"resultModels.name",
    							"resultModels.path",
    							"resultModels.map.name",
    							"resultModels.map.mutantMapStates.name",
    							"resultModels.map.mutantMapStates.transition.event",
    							"resultModels.map.mutantMapStates.transition.guard.targetState",
    							"testCases.testCaseEntries.key",
    							"testCases.testCaseEntries.testCaseEntryValue.name",
    							"testCases.testCaseEntries.testCaseEntryValue.datas.event",
    							"testCases.testCaseEntries.testCaseEntryValue.datas.testCaseEntryValueDataTestOutput.enterState",
    							"testCases.testCaseEntries.testCaseEntryValue.datas.testCaseEntryValueDataTestOutput.enterTransition",
    							"testCases.testCaseEntries.testCaseEntryValue.datas.testCaseEntryValueDataTestOutput.livingState",
    							"testCases.testCaseEntries.testCaseEntryValue.datas.testCaseEntryValueDataTestOutput.output"
    							).matching(criteria).createQuery(),
    					TestResult.class);
    		} catch (Exception e) {
    			e.printStackTrace();
    			query = entityManager.createQuery("SELECT t FROM TestResult t WHERE 0 = 1", TestResult.class);
    		}
    	} else {
    		query = entityManager.createQuery("SELECT t FROM TestResult t", TestResult.class);
    	}
    	
        return query.getResultList();
    }

    @Override
    public TestResult save(TestResult testResult) {
        return entityManager.merge(testResult);
    }
}
