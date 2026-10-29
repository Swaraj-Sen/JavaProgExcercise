package be.abis.courseadmin.test;

import be.abis.courseadmin.enumeration.Gender;
import be.abis.courseadmin.model.Person;
import be.abis.courseadmin.exception.CompanyNotFoundException;
import be.abis.courseadmin.model.Company;
import be.abis.courseadmin.model.Course;
import be.abis.courseadmin.repository.MemoryArrayCompanyRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {
    private Person person;

    @BeforeEach
    void setUp()
    {
        person = new Person("John","Smith", Gender.MALE);
    }

    @Test @DisplayName("Add Hobbies")
    void testHobbies()
    {
        person.addHobby("Reading");
        person.addHobby("Writing");
        assertTrue(person.getHobbies().size() == 2);
        assertTrue(person.getHobbies().contains("Reading"));
        assertEquals("Reading", person.getHobbies().get(0));
    }

    @ParameterizedTest
    @ValueSource(strings = "Running")
    void testHobby(String hobbyName)
    {
        person.addHobby(hobbyName);
        assertTrue(person.getHobbies().contains(hobbyName));
    }

    @ParameterizedTest
    @MethodSource("getDemoHobbies")
    void testHobbiesWithDemo(String hobbyName)
    {
        person.addHobby(hobbyName);
        assertTrue(person.getHobbies().contains(hobbyName));
    }


    private static String[] getDemoHobbies()
    {
        return new String[] {"Walking","Running","Swimming"};
    }
}
