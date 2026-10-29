package be.abis.courseadmin.test;

import be.abis.courseadmin.exception.CompanyNotFoundException;
import be.abis.courseadmin.model.Company;
import be.abis.courseadmin.model.Course;
import be.abis.courseadmin.repository.MemoryArrayCompanyRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CourseTest {
    private Course course;

    @BeforeEach
    void setUp(){
        course = new Course("Java Programming",5,100.0);
    }

    @Test @DisplayName("Calculate Total Price")
    void testCalculateTotalPrice(){
        assertEquals(100.0,course.getPricePerDay());
    }

    @Test
    void testToString()
    {
        assertNotEquals("Java Programming",course.toString());
    }
}
