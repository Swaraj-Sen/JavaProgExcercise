package be.abis.courseadmin.service;

import be.abis.courseadmin.model.Company;
import be.abis.courseadmin.repository.CompanyRepository;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AbisCompanyService implements CompanyService{

    private final CompanyRepository companyRepo;

    public AbisCompanyService(CompanyRepository repo)
    {
        this.companyRepo = repo;
    }

    @Override
    public List<Company> sortAllCompaniesByName() {
        List<Company> allComp = companyRepo.findAllCompanies();
        Collections.sort(allComp);
        //
        return allComp;
    }

    @Override
    public List<Company> sortAllComapniesByCompanyNumber(CompanySortType sortType) {
        List<Company> allComp = companyRepo.findAllCompanies();

        if(sortType == CompanySortType.ASC)
            Collections.sort(allComp,new Company.CompanyNumberComparator(Company.SortOrder.ASCORDER));
        else
            Collections.sort(allComp,new Company.CompanyNumberComparator(Company.SortOrder.DESCORDER));
        return allComp;
    }
}
