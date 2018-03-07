package com.appleSoft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class BranchService {

    @Autowired
    private BranchRepo repo;

    public void updateBranchCounter(AppleSoftBranch branch) {
        repo.save(branch);
    }

    public AppleSoftBranch fetchBranch(Integer branchId) {
        return repo.findOne(branchId);
    }

    public List<AppleSoftBranch> fetchAllBranches() {
        List<AppleSoftBranch> branches = new ArrayList<>();
        repo.findAll().forEach(branches::add);
        return branches;
    }

    public void addBranch(AppleSoftBranch branch) {
        repo.save(branch);
    }

    public List<AppleSoftBranch> fetchSortedBranches() {
        List<AppleSoftBranch> branches = new ArrayList<>();
        repo.findAll().forEach(branches::add);

        branches.sort((branchOne, branchTwo) -> branchTwo.getCounter().compareTo(branchOne.getCounter()));

        return branches;
    }

    public void deleteAllBranches() {
        repo.deleteAll();
    }
}
