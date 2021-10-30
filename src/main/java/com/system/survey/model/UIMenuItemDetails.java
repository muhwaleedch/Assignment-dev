/**
 *
 */
package com.system.survey.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;

/**
 *
 */
@Entity
@Table(name = "ui_Menu_ItemDetails")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UIMenuItemDetails extends BaseEntity {

    @Id
    @Column(name = "ui_Menu_ItemDetails_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uiMenuItemDetailsId;

    @Column(name = "ui_Menu_ItemDetails_uuid")
    private String uiMenuItemDetailsUuid;

    @Column(name = "ui_Menu_ItemDetails_Name")
    private String uiMenuItemDetailsName;

    @Column(name = "ui_Menu_ItemDetails_FrontDispName")
    private String uiMenuItemDetailsFrontDispName;

    @Column(name = "ui_Menu_ItemDetails_onScreendisplay_option")
    private String uiMenuItemDetailsOnScreenDisplayOption;

    @Column(name = "ui_Menu_ItemDetails_sortorder")
    private String uiMenuItemDetailsSortOrder;

    @Column(name = "ui_Menu_ItemDetails_attachmentType_uuid")
    private String uiMenuItemDetailsAttachmentTypeUuid;

    @Column(name = "ui_Menu_ItemDetails_attachmentType_name")
    private String uiMenuItemDetailsAttachmentTypeName;

    @Column(name = "ui_Menu_ItemDetails_menu_id")
    private String uiMenuItemDetailsMenuId;

    @Column(name = "ui_Menu_ItemDetails_menu_uuid")
    private String uiMenuItemDetailsMenuUuid;

    @Column(name = "ui_Menu_ItemDetails_inp_defaultText")
    private String uiMenuItemDetailsInpDefaultText;

    @Column(name = "ui_Menu_ItemDetails_permissionrole_uuid")
    private String uiMenuItemDetailsPermissionRoleUuid;

    @Column(name = "ui_Menu_ItemDetails_permissionrole_name")
    private String uiMenuItemDetailsPermissionRoleName;

    @Column(name = "ui_Menu_ItemDetails_sizeinMB")
    private String uiMenuItemDetailsSizeInMb;

    @Column(name = "ui_Menu_ItemDetails_extofAttachments")
    private String uiMenuItemDetailsExtOfAttachments;

    public Long getUiMenuItemDetailsId() {
        return uiMenuItemDetailsId;
    }

    public void setUiMenuItemDetailsId(Long uiMenuItemDetailsId) {
        this.uiMenuItemDetailsId = uiMenuItemDetailsId;
    }

    public String getUiMenuItemDetailsUuid() {
        return uiMenuItemDetailsUuid;
    }

    public void setUiMenuItemDetailsUuid(String uiMenuItemDetailsUuid) {
        this.uiMenuItemDetailsUuid = uiMenuItemDetailsUuid;
    }

    public String getUiMenuItemDetailsName() {
        return uiMenuItemDetailsName;
    }

    public void setUiMenuItemDetailsName(String uiMenuItemDetailsName) {
        this.uiMenuItemDetailsName = uiMenuItemDetailsName;
    }

    public String getUiMenuItemDetailsFrontDispName() {
        return uiMenuItemDetailsFrontDispName;
    }

    public void setUiMenuItemDetailsFrontDispName(String uiMenuItemDetailsFrontDispName) {
        this.uiMenuItemDetailsFrontDispName = uiMenuItemDetailsFrontDispName;
    }

    public String getUiMenuItemDetailsOnScreenDisplayOption() {
        return uiMenuItemDetailsOnScreenDisplayOption;
    }

    public void setUiMenuItemDetailsOnScreenDisplayOption(String uiMenuItemDetailsOnScreenDisplayOption) {
        this.uiMenuItemDetailsOnScreenDisplayOption = uiMenuItemDetailsOnScreenDisplayOption;
    }

    public String getUiMenuItemDetailsSortOrder() {
        return uiMenuItemDetailsSortOrder;
    }

    public void setUiMenuItemDetailsSortOrder(String uiMenuItemDetailsSortOrder) {
        this.uiMenuItemDetailsSortOrder = uiMenuItemDetailsSortOrder;
    }

    public String getUiMenuItemDetailsAttachmentTypeUuid() {
        return uiMenuItemDetailsAttachmentTypeUuid;
    }

    public void setUiMenuItemDetailsAttachmentTypeUuid(String uiMenuItemDetailsAttachmentTypeUuid) {
        this.uiMenuItemDetailsAttachmentTypeUuid = uiMenuItemDetailsAttachmentTypeUuid;
    }

    public String getUiMenuItemDetailsAttachmentTypeName() {
        return uiMenuItemDetailsAttachmentTypeName;
    }

    public void setUiMenuItemDetailsAttachmentTypeName(String uiMenuItemDetailsAttachmentTypeName) {
        this.uiMenuItemDetailsAttachmentTypeName = uiMenuItemDetailsAttachmentTypeName;
    }

    public String getUiMenuItemDetailsMenuId() {
        return uiMenuItemDetailsMenuId;
    }

    public void setUiMenuItemDetailsMenuId(String uiMenuItemDetailsMenuId) {
        this.uiMenuItemDetailsMenuId = uiMenuItemDetailsMenuId;
    }

    public String getUiMenuItemDetailsMenuUuid() {
        return uiMenuItemDetailsMenuUuid;
    }

    public void setUiMenuItemDetailsMenuUuid(String uiMenuItemDetailsMenuUuid) {
        this.uiMenuItemDetailsMenuUuid = uiMenuItemDetailsMenuUuid;
    }

    public String getUiMenuItemDetailsInpDefaultText() {
        return uiMenuItemDetailsInpDefaultText;
    }

    public void setUiMenuItemDetailsInpDefaultText(String uiMenuItemDetailsInpDefaultText) {
        this.uiMenuItemDetailsInpDefaultText = uiMenuItemDetailsInpDefaultText;
    }

    public String getUiMenuItemDetailsPermissionRoleUuid() {
        return uiMenuItemDetailsPermissionRoleUuid;
    }

    public void setUiMenuItemDetailsPermissionRoleUuid(String uiMenuItemDetailsPermissionRoleUuid) {
        this.uiMenuItemDetailsPermissionRoleUuid = uiMenuItemDetailsPermissionRoleUuid;
    }

    public String getUiMenuItemDetailsPermissionRoleName() {
        return uiMenuItemDetailsPermissionRoleName;
    }

    public void setUiMenuItemDetailsPermissionRoleName(String uiMenuItemDetailsPermissionRoleName) {
        this.uiMenuItemDetailsPermissionRoleName = uiMenuItemDetailsPermissionRoleName;
    }

    public String getUiMenuItemDetailsSizeInMb() {
        return uiMenuItemDetailsSizeInMb;
    }

    public void setUiMenuItemDetailsSizeInMb(String uiMenuItemDetailsSizeInMb) {
        this.uiMenuItemDetailsSizeInMb = uiMenuItemDetailsSizeInMb;
    }

    public String getUiMenuItemDetailsExtOfAttachments() {
        return uiMenuItemDetailsExtOfAttachments;
    }

    public void setUiMenuItemDetailsExtOfAttachments(String uiMenuItemDetailsExtOfAttachments) {
        this.uiMenuItemDetailsExtOfAttachments = uiMenuItemDetailsExtOfAttachments;
    }

}
