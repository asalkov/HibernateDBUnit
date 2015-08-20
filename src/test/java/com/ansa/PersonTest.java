package com.ansa;

import junit.framework.Assert;
import org.dbunit.Assertion;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by asalkov on 20.08.2015.
 */
public class PersonTest extends DBUnitConfig {
    private PersonService service = new PersonService();

    public PersonTest(String name) {
        super(name);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        beforeData = new FlatXmlDataSetBuilder().build(
                Thread.currentThread().getContextClassLoader()
                        .getResourceAsStream("person-data.xml"));

        tester.setDataSet(beforeData);
        tester.onSetup();
    }

    @Test
    public void testGetAll() throws Exception {
        List<Person> persons = service.getAll();

        IDataSet expectedData = new FlatXmlDataSetBuilder().build(
                Thread.currentThread().getContextClassLoader()
                        .getResourceAsStream("person-data.xml"));

        IDataSet actualData = tester.getConnection().createDataSet();
        Assertion.assertEquals(expectedData, actualData);
        Assert.assertEquals(expectedData.getTable("person").getRowCount(), persons.size());
    }

    @Test
    public void testSave() throws Exception {
        Person person = new Person();
        person.setName("Lilia");
        person.setSurname("Vernugora");

        service.save(person);

        IDataSet expectedData = new FlatXmlDataSetBuilder().build(
                Thread.currentThread().getContextClassLoader()
                        .getResourceAsStream("person-data-save.xml"));

        IDataSet actualData = tester.getConnection().createDataSet();

        String[] ignore = {"id"};
        Assertion.assertEqualsIgnoreCols(expectedData, actualData, "person", ignore);
    }
}
