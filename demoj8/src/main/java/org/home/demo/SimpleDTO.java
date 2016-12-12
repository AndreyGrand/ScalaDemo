package org.home.demo;

/**
 * Created by andrey on 11.12.16.
 */
public class SimpleDTO {
    String mmm;
    Integer iii;

    public SimpleDTO(String mmm, Integer iii) {
        this.mmm = mmm;
        this.iii = iii;
    }

    public SimpleDTO() {
        mmm = "mmm";
        iii = 0;
    }

    public String getMmm() {
        return mmm;
    }

    public void setMmm(String mmm) {
        this.mmm = mmm;
    }

    public Integer getIii() {
        return iii;
    }

    public void setIii(Integer iii) {
        this.iii = iii;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SimpleDTO simpleDTO = (SimpleDTO) o;

        if (mmm != null ? !mmm.equals(simpleDTO.mmm) : simpleDTO.mmm != null) return false;
        return iii != null ? iii.equals(simpleDTO.iii) : simpleDTO.iii == null;
    }

    @Override
    public int hashCode() {
        int result = mmm != null ? mmm.hashCode() : 0;
        result = 31 * result + (iii != null ? iii.hashCode() : 0);
        return result;
    }
}
