package com.system.survey.controller.rest;

import com.system.survey.dto.Response;
import com.system.survey.dto.metadata.AddressTypeDto;
import com.system.survey.dto.metadata.StateDto;
import com.system.survey.dto.metadata.SysParameterDto;
import com.system.survey.dto.metadata.UIMenuItemDetailsDto;
import com.system.survey.exception.ExceptionUtil;
import com.system.survey.service.metadata.IMetadataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/metadata")
public class MetadataRestController {

    private Logger logger = LoggerFactory.getLogger(MetadataRestController.class);

    @Autowired
    private IMetadataService metadataService;

    @RequestMapping(value = "/findAllCountries", method = RequestMethod.GET)
    public ResponseEntity<?> findAllCountries() {
        try {
            return new ResponseEntity<>(new Response("Success", "Country information fetched successfully", metadataService.findAllCountries()), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while fetching Country metadata ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/findAllStates", method = RequestMethod.GET)
    public ResponseEntity<?> findAllStates() {
        try {
            return new ResponseEntity<>(new Response("Success", "State information fetched successfully", metadataService.findAllStates()), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while fetching State metadata ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/findStatesByCountryUuid/{countryUuid}", method = RequestMethod.GET)
    public ResponseEntity<?> findStatesByCountryUuid(@PathVariable String countryUuid) {
        ResponseEntity<?> responseEntity = null;
        try {
            countryUuid = countryUuid != null ? countryUuid.split("\\|")[0] : "0000-0000-0000-0000-0000";
            List<StateDto> stateDtos = metadataService.findStatesByCountryUuid(countryUuid);
            if (stateDtos != null && !stateDtos.isEmpty()) {
                responseEntity = new ResponseEntity<>(new Response("Success", "State information fetched successfully", stateDtos), HttpStatus.OK);
            } else {
                responseEntity = new ResponseEntity<>(new Response("Not Found", "No state found with provided country uuid", new ArrayList<StateDto>()), HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            logger.error("An error occurred while fetching State metadata ", ExceptionUtil.getRootCauseMessage(ex));
            responseEntity = new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @RequestMapping(value = "/findAllAddressTypes", method = RequestMethod.GET)
    public ResponseEntity<?> findAllAddressTypes() {
        ResponseEntity<?> responseEntity = null;
        try {
            List<AddressTypeDto> addressTypeDtos = metadataService.findAllAddressTypes();
            if (addressTypeDtos != null && !addressTypeDtos.isEmpty()) {
                responseEntity = new ResponseEntity<>(new Response("Success", "Address Types information fetched successfully", addressTypeDtos), HttpStatus.OK);
            } else {
                responseEntity = new ResponseEntity<>(new Response("Not Found", "No Address Type found", new ArrayList<AddressTypeDto>()), HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            logger.error("An error occurred while fetching Address metadata ", ExceptionUtil.getRootCauseMessage(ex));
            responseEntity = new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @RequestMapping(value = "/findAllUserMenuItemDetails", method = RequestMethod.GET)
    public ResponseEntity<?> findAllUserMenuItemDetails() {
        ResponseEntity<?> responseEntity = null;
        try {
            List<UIMenuItemDetailsDto> uiMenuItemDetailsDto = metadataService.findSurveyProfileAttachmentsUIMenuItemDetails();
            if (uiMenuItemDetailsDto != null && !uiMenuItemDetailsDto.isEmpty()) {
                responseEntity = new ResponseEntity<>(new Response("Success", "UI Menu Item Details information fetched successfully", uiMenuItemDetailsDto), HttpStatus.OK);
            } else {
                responseEntity = new ResponseEntity<>(new Response("Not Found", "No UI Menu Item Detail found", new ArrayList<AddressTypeDto>()), HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            logger.error("An error occurred while fetching Address metadata ", ExceptionUtil.getRootCauseMessage(ex));
            responseEntity = new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @RequestMapping(value = "/getSysParamByName", method = RequestMethod.GET)
    public ResponseEntity<?> findSysParamByName(String sysParameterName) {
        try {
            Optional<SysParameterDto> sysParameterDtoOpt = metadataService.findSysParameterByParameterName(sysParameterName);
            if (sysParameterDtoOpt.isPresent()) {
                return new ResponseEntity<>(new Response("Success", "Sys Parameter information fetched successfully", sysParameterDtoOpt.get()), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new Response("Success", "Sys Parameter information not found with Parameter Name: " + sysParameterName), HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            logger.error("An error occurred while fetching sys paremeter by name ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
