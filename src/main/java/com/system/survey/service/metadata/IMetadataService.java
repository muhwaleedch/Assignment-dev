/**
 *
 */
package com.system.survey.service.metadata;

import com.system.survey.dto.metadata.*;

import java.util.List;
import java.util.Optional;

/**
 * @author ZZ001Z808
 *
 */
public interface IMetadataService {

    List<CountryDto> findAllCountries() throws Exception;

    List<StateDto> findAllStates() throws Exception;

    List<StateDto> findStatesByCountryUuid(String countryUuid) throws Exception;

    List<AddressTypeDto> findAllAddressTypes() throws Exception;

    List<UIMenuItemDetailsDto> findSurveyProfileAttachmentsUIMenuItemDetails() throws Exception;

    Optional<SysParameterDto> findSysParameterByParameterName(String sysParameterName) throws Exception;
}
