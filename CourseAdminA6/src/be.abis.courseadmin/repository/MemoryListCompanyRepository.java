package be.abis.courseadmin.repository;

import be.abis.courseadmin.exception.CompanyNotFoundException;
import be.abis.courseadmin.model.Company;

import java.util.ArrayList;
import java.util.List;

public class MemoryListCompanyRepository implements CompanyRepository{
    private final List<Company> lstCompany ;

    public MemoryListCompanyRepository() {
        lstCompany = new ArrayList<>();
    }
    @Override
    public Company findCompany(int id) throws CompanyNotFoundException {
        for(Company c: this.lstCompany)
        {
            if(c.getCompanyNumber() == id) {
                return c;
            }
        }
        throw new CompanyNotFoundException("Company with ID "+id+" not found");
    }

    @Override
    public Company findCompany(String name) throws CompanyNotFoundException {
        for(Company c: this.lstCompany)
        {
            if(c.getName().equals(c.getName())) {
                return c;
            }
        }
        throw new CompanyNotFoundException("Company with name "+name+" not found");
    }

    @Override
    public void addCompany(Company c) {
        if(!lstCompany.stream().anyMatch(com->com.getName().equals(c.getName())))
        {
            lstCompany.add(c);
        }
        else
        {
            System.out.println("Company already exists!");
        }
    }

    @Override
    public void updateCompany(Company c) {
        Company fndCompany = lstCompany.stream().filter(com -> com.getCompanyNumber() == c.getCompanyNumber()).findFirst().orElse(null);
        if (fndCompany != null) {
            fndCompany.setName(c.getName());
        }
        else   {
            System.out.println("Company not found");
        }
    }

    @Override
    public void deleteCompany(int id) {
        lstCompany.removeIf(com->com.getCompanyNumber() == id);
    }

    @Override
    public List<Company> findAllCompanies() {
        return lstCompany;
    }
}
