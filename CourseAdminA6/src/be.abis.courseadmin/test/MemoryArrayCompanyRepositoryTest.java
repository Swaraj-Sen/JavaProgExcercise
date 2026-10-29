package be.abis.courseadmin.test;

import be.abis.courseadmin.exception.CompanyNotFoundException;
import be.abis.courseadmin.model.Company;
import be.abis.courseadmin.repository.MemoryArrayCompanyRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MemoryArrayCompanyRepositoryTest {
    private static MemoryArrayCompanyRepository memoryArrayCompanyRepository;

    @BeforeAll
    static void setup(){
        memoryArrayCompanyRepository = new MemoryArrayCompanyRepository();
    }

    @Test @DisplayName("Test Array Size")
    void testArraySize()
    {
        assertEquals(5, Arrays.stream(memoryArrayCompanyRepository.findAllCompanies().stream().toArray()).count());
    }

    //Test the find methods
    @Test @DisplayName("Test find with id")
    void testFindCompanybyId() throws CompanyNotFoundException
    {
        Company com = memoryArrayCompanyRepository.findCompany(1);
        assertEquals(1, com.getCompanyNumber());
    }

    @Test @DisplayName("Find Company by name")
    void testFindCompanyByName() throws CompanyNotFoundException
    {
        assertEquals("ABIS",memoryArrayCompanyRepository.findCompany("ABIS").getName());
    }

    //Test company not found
    @Test @DisplayName("Company not found by name")
    void testFindCompanyByNameNotFound()
    {
        assertThrows(CompanyNotFoundException.class,
                ()-> memoryArrayCompanyRepository.findCompany("ABIS1"));
    }

    @AfterAll
    static void disposeObjects()
    {
        memoryArrayCompanyRepository = null;
    }
}
