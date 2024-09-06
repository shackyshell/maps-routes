package com.shacky.maps_routes;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class Country {
    private Name name;
    private List<String> tld;
    private String cca2;
    private String ccn3;
    private String cca3;
    private String cioc;
    private boolean independent;
    private String status;
    private boolean unMember;
    private Map<String, Currency> currencies;
    private Idd idd;
    private List<String> capital;
    private List<String> altSpellings;
    private String region;
    private String subregion;
    private Map<String, String> languages;
    private Map<String, Translation> translations;
    private List<Double> latlng;
    private boolean landlocked;
    private List<String> borders;
    private double area;
    private String flag;
    private Map<String, Demonym> demonyms;

    // Getters and Setters
    // ...

    // Nested classes for specific fields

    public static class Name {
        private String common;
        private String official;
        @JsonProperty("native")
        private Map<String, NativeName> nativeName;

        // Getters and Setters
        public String getCommon() {
            return common;
        }

        public void setCommon(String common) {
            this.common = common;
        }

        public String getOfficial() {
            return official;
        }

        public void setOfficial(String official) {
            this.official = official;
        }

        public Map<String, NativeName> getNativeName() {
            return nativeName;
        }

        public void setNativeName(Map<String, NativeName> nativeName) {
            this.nativeName = nativeName;
        }
    }

    public static class NativeName {
        private String official;
        private String common;

        // Getters and Setters
        public String getOfficial() {
            return official;
        }

        public void setOfficial(String official) {
            this.official = official;
        }

        public String getCommon() {
            return common;
        }

        public void setCommon(String common) {
            this.common = common;
        }
    }

    public static class Currency {
        private String name;
        private String symbol;

        // Getters and Setters
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSymbol() {
            return symbol;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }
    }

    public static class Idd {
        private String root;
        private List<String> suffixes;

        // Getters and Setters
        public String getRoot() {
            return root;
        }

        public void setRoot(String root) {
            this.root = root;
        }

        public List<String> getSuffixes() {
            return suffixes;
        }

        public void setSuffixes(List<String> suffixes) {
            this.suffixes = suffixes;
        }
    }

    public static class Translation {
        private String official;
        private String common;

        // Getters and Setters
        public String getOfficial() {
            return official;
        }

        public void setOfficial(String official) {
            this.official = official;
        }

        public String getCommon() {
            return common;
        }

        public void setCommon(String common) {
            this.common = common;
        }
    }

    public static class Demonym {
        private String f;
        private String m;

        // Getters and Setters
        public String getF() {
            return f;
        }

        public void setF(String f) {
            this.f = f;
        }

        public String getM() {
            return m;
        }

        public void setM(String m) {
            this.m = m;
        }
    }

    // Getters and Setters for Country fields

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public List<String> getTld() {
        return tld;
    }

    public void setTld(List<String> tld) {
        this.tld = tld;
    }

    public String getCca2() {
        return cca2;
    }

    public void setCca2(String cca2) {
        this.cca2 = cca2;
    }

    public String getCcn3() {
        return ccn3;
    }

    public void setCcn3(String ccn3) {
        this.ccn3 = ccn3;
    }

    public String getCca3() {
        return cca3;
    }

    public void setCca3(String cca3) {
        this.cca3 = cca3;
    }

    public String getCioc() {
        return cioc;
    }

    public void setCioc(String cioc) {
        this.cioc = cioc;
    }

    public boolean isIndependent() {
        return independent;
    }

    public void setIndependent(boolean independent) {
        this.independent = independent;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isUnMember() {
        return unMember;
    }

    public void setUnMember(boolean unMember) {
        this.unMember = unMember;
    }

    public Map<String, Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(Map<String, Currency> currencies) {
        this.currencies = currencies;
    }

    public Idd getIdd() {
        return idd;
    }

    public void setIdd(Idd idd) {
        this.idd = idd;
    }

    public List<String> getCapital() {
        return capital;
    }

    public void setCapital(List<String> capital) {
        this.capital = capital;
    }

    public List<String> getAltSpellings() {
        return altSpellings;
    }

    public void setAltSpellings(List<String> altSpellings) {
        this.altSpellings = altSpellings;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSubregion() {
        return subregion;
    }

    public void setSubregion(String subregion) {
        this.subregion = subregion;
    }

    public Map<String, String> getLanguages() {
        return languages;
    }

    public void setLanguages(Map<String, String> languages) {
        this.languages = languages;
    }

    public Map<String, Translation> getTranslations() {
        return translations;
    }

    public void setTranslations(Map<String, Translation> translations) {
        this.translations = translations;
    }

    public List<Double> getLatlng() {
        return latlng;
    }

    public void setLatlng(List<Double> latlng) {
        this.latlng = latlng;
    }

    public boolean isLandlocked() {
        return landlocked;
    }

    public void setLandlocked(boolean landlocked) {
        this.landlocked = landlocked;
    }

    public List<String> getBorders() {
        return borders;
    }

    public void setBorders(List<String> borders) {
        this.borders = borders;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Map<String, Demonym> getDemonyms() {
        return demonyms;
    }

    public void setDemonyms(Map<String, Demonym> demonyms) {
        this.demonyms = demonyms;
    }
}
