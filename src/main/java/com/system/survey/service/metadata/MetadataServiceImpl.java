package com.system.survey.service.metadata;

import com.system.survey.dto.metadata.*;
import com.system.survey.model.SysParameter;
import com.system.survey.repository.address.AddressTypeRepository;
import com.system.survey.repository.countries.CountriesRepository;
import com.system.survey.repository.states.StatesRepository;
import com.system.survey.repository.sysparameter.SysParameterRepository;
import com.system.survey.repository.usermenu.UIMenuItemDetailsRepository;
import com.system.survey.service.utils.ObjectTransformationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MetadataServiceImpl implements IMetadataService {

    private Logger logger = LoggerFactory.getLogger(MetadataServiceImpl.class);

    @Autowired
    private CountriesRepository countryRepostory;

    @Autowired
    private StatesRepository statesRepository;

    @Autowired
    private AddressTypeRepository addressTypeRepository;

    @Autowired
    private UIMenuItemDetailsRepository uiMenuItemDetailsRepository;

    @Autowired
    private SysParameterRepository sysParameterRepository;

    @Autowired
    private ObjectTransformationService objTransformationService;

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public List<CountryDto> findAllCountries() throws Exception {
        // TODO Auto-generated method stub
        try {
            return objTransformationService.transformCountryModelsToCountryDtos(countryRepostory.findAll());
        } catch (Exception e) {
            logger.error("Error fetching country metadata details", e);
            throw new Exception("Error fetching country metadata details");
        }

    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public List<StateDto> findAllStates() throws Exception {
        // TODO Auto-generated method stub
        try {
            return objTransformationService.transformStateModelsToStateDtos(statesRepository.findAll());
        } catch (Exception e) {
            logger.error("Error fetching state metadata details", e);
            throw new Exception("Error fetching state metadata details");
        }

    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public List<StateDto> findStatesByCountryUuid(String countryUuid) throws Exception {
        // TODO Auto-generated method stub
        try {
            return objTransformationService.transformStateModelsToStateDtos(statesRepository.findByCountryUuid(countryUuid));
        } catch (Exception e) {
            logger.error("Error fetching state metadata details for country uuid " + countryUuid, e);
            throw new Exception("Error fetching state metadata details for country uuid " + countryUuid);
        }
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public List<AddressTypeDto> findAllAddressTypes() throws Exception {
        // TODO Auto-generated method stub
        try {
            return objTransformationService.transformAddressTypeModelsToAddressTypeDtos(addressTypeRepository.findAll());
        } catch (Exception e) {
            logger.error("Error fetching address types", e);
            throw new Exception("Error fetching address types");
        }
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public List<UIMenuItemDetailsDto> findSurveyProfileAttachmentsUIMenuItemDetails() throws Exception {
        // TODO Auto-generated method stub
        try {
            return objTransformationService.transformUIMenuItemDetailModelsToDtos(uiMenuItemDetailsRepository.findSurveyProfileAttachmentsUIMenuItemDetails());
        } catch (Exception e) {
            logger.error("Error fetching UI Menu Details Details", e);
            throw new Exception("Error fetching UI Menu Details");
        }
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Optional<SysParameterDto> findSysParameterByParameterName(String sysParameterName) throws Exception {
        Optional<SysParameterDto> sysParameterDtoOpt = Optional.empty();
        Optional<SysParameter> sysParameterOpt = sysParameterRepository.findSysParameterBySysParameterName(sysParameterName);
        if (sysParameterOpt.isPresent()) {
            SysParameterDto sysParameterDto = new SysParameterDto();
            SysParameter sysParameter = sysParameterOpt.get();
            sysParameterDto.setSystemParameterId(sysParameter.getSystemParameterId());
            sysParameterDto.setSysParameterName(sysParameter.getSysParameterName());
            sysParameterDto.setSysParameterUuid(sysParameter.getSysParameterUuid());
            sysParameterDto.setSysParameterValue(sysParameter.getSysParameterValue());
            sysParameterDtoOpt = Optional.of(sysParameterDto);
        }
        return sysParameterDtoOpt;
    }
}
