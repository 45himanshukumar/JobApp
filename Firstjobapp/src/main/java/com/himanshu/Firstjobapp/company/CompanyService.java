package com.himanshu.Firstjobapp.company;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompany();
    boolean updateCompany(Long id,Company company);

    void createCompany(Company company);

    boolean DeleteCompany(Long id);

    Company getCompanyById(Long id);

}
