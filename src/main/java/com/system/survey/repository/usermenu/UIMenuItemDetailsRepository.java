package com.system.survey.repository.usermenu;

import com.system.survey.model.UIMenuItemDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UIMenuItemDetailsRepository extends JpaRepository<UIMenuItemDetails, Long> {

    @Query(value = "Select * from  ui_Menu_ItemDetails where ui_Menu_ItemDetails_menu_uuid = (seLECT ui_Menu_uuid FROM ui_Menu where ui_menu_name = 'surveyprofileattachments' and ui_Menu_org_uuid = (select organization_uuid from organization where organization_name = 'survey_org'))", nativeQuery = true)
    public List<UIMenuItemDetails> findSurveyProfileAttachmentsUIMenuItemDetails();

}
