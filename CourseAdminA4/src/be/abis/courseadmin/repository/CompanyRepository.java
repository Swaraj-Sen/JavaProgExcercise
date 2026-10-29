package be.abis.courseadmin.repository;

import be.abis.courseadmin.model.Company;
import be.abis.courseadmin.model.CompanySession;

import java.util.List;

public interface CompanyRepository {
    Company findCompany(int id);
    Company findCompany(String name);
    void addCompany(Company c);
    void updateCompany(Company c);
    void deleteCompany(int id);
}
