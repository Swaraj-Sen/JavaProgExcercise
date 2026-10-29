package be.abis.courseadmin.repository;

import be.abis.courseadmin.exception.CompanyNotFoundException;
import be.abis.courseadmin.model.Company;

import java.util.Arrays;
import java.util.List;

public class MemoryArrayCompanyRepository implements CompanyRepository
{
    private Company[] companyList = null;

    public MemoryArrayCompanyRepository()
    {
        this.companyList = new Company[5];
        this.companyList[0] = new Company(1,"ABIS");
        this.companyList[1] = new Company(2,"Java");
        this.companyList[2] = new Company(3,"JavaScript");
        this.companyList[3] = new Company(4,"PHP");
        this.companyList[4] = new Company(5,"Python");
    }

    @Override
    public Company findCompany(int id) throws CompanyNotFoundException{
        for(Company company : this.companyList){
            if(company!=null && company.getCompanyNumber() == id) {
                return company;
            }
        }

        throw new CompanyNotFoundException("Company with ID "+id+" not found");
    }

    @Override
    public Company findCompany(String name) throws CompanyNotFoundException {
        for(Company company : this.companyList){
            if(company!=null && company.getName().equals(name)) {
                return company;
            }
        }
        throw new CompanyNotFoundException("Company with name "+name+" not found");
    }

    @Override
    public void addCompany(Company c) {
        int index = 0;
        while(index < this.companyList.length){
            if(this.companyList[index] == null){
                this.companyList[index] = c;
                System.out.println("Company added: " + c.getName());
                return;
            }
            index++;
        }

        System.out.println("Company can't be added: " + c.getName());
    }

    @Override
    public void updateCompany(Company c) {
        int index = 0;
        while(index < this.companyList.length){
            if(this.companyList[index] != null && this.companyList[index].getCompanyNumber() == c.getCompanyNumber())
            {
                this.companyList[index].setName(c.getName());
                System.out.println("Company updated: " + c.getName());
                return;
            }
            index++;
        }
        System.out.println("Company can't be updated: " + c.getName());
    }

    @Override
    public void deleteCompany(int id) {
        int index = 0;
        while(index < this.companyList.length){
            if(this.companyList[index] != null && this.companyList[index].getCompanyNumber() == id)
            {
                this.companyList[index] = null;
                System.out.println("Company deleted: " + this.companyList[index].getName());
                return;
            }
            index++;
        }

        System.out.println("Company can't be deleted: " + id);
    }

    @Override
    public List<Company> findAllCompanies() {
        return Arrays.stream(this.companyList).toList();
    }

    private boolean isCompanyExist(String name) {
        for (Company company : this.companyList){
            if(company != null && company.getName().equals(name))
                return true;
        }

        return false;
    }

    private boolean isListFull(String name) {
        for (Company company : this.companyList){
            if(company != null && company.getName().equals(name))
                return true;
        }

        return false;
    }
}
