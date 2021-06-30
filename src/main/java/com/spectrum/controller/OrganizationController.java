package com.spectrum.controller;

import com.spectrum.dto.FinalResponse;
import com.spectrum.dto.Organizations;
import com.spectrum.dto.Releases;
import com.spectrum.dto.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;

import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

@RestController
@RequestMapping("/api/v1")
public class OrganizationController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${organization.url}")
    private String organizationUrl;

    @GetMapping("/data")
    public FinalResponse getData()
    {
        FinalResponse finalResponse = getResponse();
      return finalResponse;


    }

    @GetMapping("/data/sortByAsc")
    public FinalResponse getDataBySorting(@RequestParam(name = "sortBy") String sortBy)
    {
        FinalResponse finalResponse = new FinalResponse();
        List<Organizations> organizations = new ArrayList<>();
        if(sortBy.equals("organization")){
            organizations = getResponse().getOrganizations().stream()
                    .sorted(Comparator.comparing(Organizations::getOrganization))
                    .collect(Collectors.toList());
        } else if(sortBy.equals("releaseCount")){
            organizations = getResponse().getOrganizations().stream()
                    .sorted(Comparator.comparing(Organizations::getRelease_count))
                    .collect(Collectors.toList());
        } else if(sortBy.equals("labourHours")){
            organizations = getResponse().getOrganizations().stream()
                .sorted(Comparator.comparing(Organizations::getTotal_labor_hours))
                .collect(Collectors.toList());
        }


        finalResponse.setOrganizations(organizations);

        return finalResponse;

    }

    @GetMapping("/data/sortByDesc")
    public FinalResponse getDataBySortingDesc(@RequestParam(name = "sortBy") String sortBy)
    {
        FinalResponse finalResponse = new FinalResponse();
        List<Organizations> organizations = new ArrayList<>();
        if(sortBy.equals("organization")){
            organizations = getResponse().getOrganizations().stream()
                    .sorted(Comparator.comparing(Organizations::getOrganization).reversed())
                    .collect(Collectors.toList());
        } else if(sortBy.equals("releaseCount")){
            organizations = getResponse().getOrganizations().stream()
                    .sorted(Comparator.comparing(Organizations::getRelease_count).reversed())
                    .collect(Collectors.toList());
        } else if(sortBy.equals("labourHours")){
            organizations = getResponse().getOrganizations().stream()
                    .sorted(Comparator.comparing(Organizations::getTotal_labor_hours).reversed())
                    .collect(Collectors.toList());
        }


        finalResponse.setOrganizations(organizations);

        return finalResponse;

    }



    @GetMapping("/organization/export")
    public void exportToCSV(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=organization_" + currentDateTime + ".csv";
        response.setHeader(headerKey, headerValue);


        FinalResponse result = getResponse();
        
        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
        String[] csvHeader = {"organization", "release_count", "total_labor_hours","all_in_production","licenses","most_active_months"};
        String[] nameMapping = {"organization", "release_count", "total_labor_hours","all_in_production","licenses","most_active_months"};

        csvWriter.writeHeader(csvHeader);

        for (Organizations organizations : result.getOrganizations()) {
            csvWriter.write(organizations, nameMapping);
        }

        csvWriter.close();

    }


    private FinalResponse getResponse() {
        Response result = restTemplate.getForObject(organizationUrl, Response.class);


        FinalResponse finalResponse = new FinalResponse();

        List<Organizations> organizationsList = new ArrayList<>();

        Map<String, Set<String>> licenses = result.getLicenses();
        Map<String, Long> releaseCount = result.getReleaseCount();
        Map<String, Double> totalLabourHours = result.getTotalLabourHours();
        Map<String, Set<Integer>> most_active_months = result.getReleaseDates();
        Map<String, Boolean> production = result.isProduction();

        releaseCount.entrySet().stream().forEach( e-> {
            Organizations organizations = new Organizations();
            organizations.setOrganization(e.getKey());
            organizations.setRelease_count(releaseCount.get(e.getKey()));
            organizations.setTotal_labor_hours(totalLabourHours.get(e.getKey()));
            organizations.setAll_in_production(production.get(e.getKey()));
            organizations.setLicenses(licenses.get(e.getKey()));
            organizations.setMost_active_months(most_active_months.get(e.getKey()));

            organizationsList.add(organizations);
        });

        finalResponse.setOrganizations(organizationsList);
        return finalResponse;
    }


}
