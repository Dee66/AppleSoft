package com.appleSoft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.Response;
import java.util.List;

@RestController
public class BranchController {

    @Autowired
    private BranchService service;

    @RequestMapping("/api/fetchAll")
    public List<AppleSoftBranch> getAllBranches() {
        return service.fetchAllBranches();
    }

    @RequestMapping("/api/branch/{branchId}")
    public AppleSoftBranch getBranch(@PathVariable Integer branchId) {
        return service.fetchBranch(branchId);
    }

    @RequestMapping(value = "/api/branch/addBranch", method = RequestMethod.POST)
    public Response addBranch(@RequestBody AppleSoftBranch branch) {
        service.addBranch(branch);
        String result = "Created Branch: " + branch.getBranchName();
        return Response.status(201).entity(result).build();
    }

    @RequestMapping(value = "/api/updateBranchCounter/{branchId}", method = RequestMethod.PUT)
    public void updateBranchCounter(@PathVariable Integer branchId) {
        AppleSoftBranch branch = service.fetchBranch(branchId);
        branch.setCounter(branch.getCounter() + 1);
        service.updateBranchCounter(branch);
    }

    @RequestMapping("/api/branchRankings")
    public List<AppleSoftBranch> getRankings() {
        return service.fetchSortedBranches();
    }

    @RequestMapping(value = "/api/deleteAll", method = RequestMethod.DELETE)
    public void deleteAllBranches() {
        service.deleteAllBranches();
    }

}
