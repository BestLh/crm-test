package com.sm.cn.entity;

import com.sm.cn.entity.base.BaseEntity;

import java.util.Date;

public class Brand extends BaseEntity {

    private String brandName;

    private String brandSite;

    private String brandDesc;

    private String branddLogo;

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName == null ? null : brandName.trim();
    }

    public String getBrandSite() {
        return brandSite;
    }

    public void setBrandSite(String brandSite) {
        this.brandSite = brandSite == null ? null : brandSite.trim();
    }

    public String getBrandDesc() {
        return brandDesc;
    }

    public void setBrandDesc(String brandDesc) {
        this.brandDesc = brandDesc == null ? null : brandDesc.trim();
    }

    public String getBranddLogo() {
        return branddLogo;
    }

    public void setBranddLogo(String branddLogo) {
        this.branddLogo = branddLogo == null ? null : branddLogo.trim();
    }
}