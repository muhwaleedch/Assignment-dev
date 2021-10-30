package com.system.survey.repository.sysparameter;

import com.system.survey.model.SysParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SysParameterRepository extends JpaRepository<SysParameter, Long> {

    Optional<SysParameter> findSysParameterBySysParameterUuid(String sysParameterUuid);

    Optional<SysParameter> findSysParameterBySysParameterName(String sysParameterName);
}
