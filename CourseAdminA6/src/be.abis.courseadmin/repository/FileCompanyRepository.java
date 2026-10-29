package be.abis.courseadmin.repository;

import be.abis.courseadmin.exception.CompanyNotFoundException;
import be.abis.courseadmin.model.Company;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class FileCompanyRepository implements CompanyRepository{
    private List<Company> companies;
    private static final String FILE_PATH = "C:\\temp\\javacourses\\companies.txt";
    private String filePath = FILE_PATH;

    public FileCompanyRepository() {
        companies = new ArrayList<Company>();
        loadCompaniesFromFile();
    }

    public FileCompanyRepository(String filePath) {
        this();
        this.filePath = filePath;
    }


    @Override
    public Company findCompany(int id) throws CompanyNotFoundException {
        for(Company c: this.companies)
        {
            if(c.getCompanyNumber() == id) {
                return c;
            }
        }
        throw new CompanyNotFoundException("Company with ID "+id+" not found");
    }

    @Override
    public Company findCompany(String name) throws CompanyNotFoundException {
        for(Company c: this.companies)
        {
            if(c.getName().equals(c.getName())) {
                return c;
            }
        }
        throw new CompanyNotFoundException("Company with name "+name+" not found");
    }

    @Override
    public void addCompany(Company c) {

        if(!companies.stream().anyMatch(com->com.getName().equals(c.getName())))
        {
            companies.add(c);
            saveCompaniesToFile();
        }
        else
        {
            System.out.println("Company already exists!");
        }
    }

    @Override
    public void updateCompany(Company c) {
        Company fndCompany = companies.stream().filter(com -> com.getCompanyNumber() == c.getCompanyNumber()).findFirst().orElse(null);
        if (fndCompany != null) {
            fndCompany.setName(c.getName());
            saveCompaniesToFile();
        }
        else   {
            System.out.println("Company not found");
        }
    }

    @Override
    public void deleteCompany(int id) {
        if(this.companies.removeIf(com->com.getCompanyNumber() == id)) {
            saveCompaniesToFile();
        }
    }

    @Override
    public List<Company> findAllCompanies() {
        return this.companies;
    }

    private void loadCompaniesFromFile() {
        File file = new File(filePath);
        int recNum = 1;
        String line = "";
        boolean firstRec = true;

        if (!file.exists()) {
            System.out.println("File not found");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while ((line = reader.readLine()) != null)
            {
                line = line.trim();
                if(!line.isEmpty() || !line.isBlank())
                {
                    if(firstRec)
                    {
                        companies.clear();
                        firstRec = false;
                    }
                    Company c = new Company(recNum++,line);
                    companies.add(c);
                }
            }
            System.out.println("loaded " + companies.size() + " companies from file");
        }
        catch (IOException e) {
            System.out.println("Error reading file: "+e.getMessage());
        }
    }

    private void saveCompaniesToFile() {
        File file = new File(filePath);

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath)))
        {
            for(Company c : companies)
            {
                writer.write(c.getName());
                writer.newLine();
            }
        }
        catch (IOException e) {
            System.out.println("Error writing file"+e.getMessage());
        }
    }

}
